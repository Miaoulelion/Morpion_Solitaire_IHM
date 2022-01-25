package main.model;

import java.util.ArrayList;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

import main.utils.Direction;

/**
 * This class represent a model of Morpion Solitaire. 
 *
 */

public abstract class GridGameAbstract implements IGridGame {
	private ArrayList<Point>GridPoints;
	private LinkedList<Line> listOfAlignment;
	private LinkedList<Point>PointPlayed;
	
	
	public GridGameAbstract() {
		this.GridPoints=new ArrayList<Point>();
		this.listOfAlignment=new LinkedList<Line>();
		this.PointPlayed=new LinkedList<Point>();
		gridInitialization(10,3,4);
	}
	
	
	/**
	 * This method place the points to form a cross. 
	 * @param x : coordinate (x value) of the beginning of the cross.
	 * @param y : coordinate (y value) of the beginning of the cross.
	 * @param widthCross : the width of the cross.
	 */
	
	private void gridInitialization(int x, int y, int widthCross) {
		if(widthCross<=3) {
			throw new IllegalArgumentException();
		}
		this.GridPoints=new ArrayList<Point>();
		for(int i=0;i<widthCross;++i) {
			this.GridPoints.add(new Point(x+i,y));
			this.GridPoints.add(new Point(x+i-widthCross+1,y+widthCross-1));
			this.GridPoints.add(new Point(x+i+widthCross-1,y+widthCross-1));
			this.GridPoints.add(new Point(x+i-widthCross+1,y+2*widthCross-2));
			this.GridPoints.add(new Point(x+i+widthCross-1,y+2*widthCross-2));
			this.GridPoints.add(new Point(x+i,y+3*widthCross-3));
			this.GridPoints.add(new Point(x,y+i));
			this.GridPoints.add(new Point(x+widthCross-1,y+i));
			this.GridPoints.add(new Point(x-widthCross+1,y+i+widthCross-1));
			this.GridPoints.add(new Point(x+2*widthCross-2,y+i+widthCross-1));
			this.GridPoints.add(new Point(x,y+i+2*widthCross-2));
			this.GridPoints.add(new Point(x+widthCross-1,y+i+2*widthCross-2));
		}
	}
	
	
	public String toString() {
		return this.GridPoints.toString();
	}
	
	/**
	 * We want to verify if a Point is aligned for An alignment with a length of 'alignNumber', and 
	 * for a number of some Points already aligned. We check the direction given in argument.
	 * If there is a another Point in this direction, if it is already aligned we compare to the
	 * "nbPointAlreadyAligned" (number of point already aligned authorised, 1 for 5T, 0 for 5D),
	 * and according to the comparaison we add or not the Point.
	 * @param x the coordinate of the Point 
	 * @param y the coordinate of the Point 
	 * @param dir
	 * @param alignNumber
	 * @param nbPointAlreadyAligned
	 * @return LinkedList with the Points aligned (maximum "alignNumber", 5 for 5T and 5 for 5D)
	 */
	
	private LinkedList<Point> AlignedPointsByDirection(int x, int y, Direction dir, int alignNumber,int nbPointAlreadyAligned) {
		if(alignNumber<1||nbPointAlreadyAligned<0) {
			throw new IllegalArgumentException();
		}
		Objects.requireNonNull(dir);
		LinkedList<Point> alignPoint = new LinkedList<Point>();
		alignPoint.add(new Point(x,y));
		int cptPointAlreadyAligned=0;
		for(int j=1;this.GridPoints.contains(new Point(x + dir.getDx()*j,y + dir.getDy()*j))
				&&alignPoint.size()<=alignNumber-1;++j){//A RETIRER SI ON VEUT FAIRE LE CHOIX
			Point p=this.GridPoints.get(this.GridPoints.indexOf(new Point(x + dir.getDx()*j,y + dir.getDy()*j)));
			if(p.getDirAlignments().contains(dir)){
				++cptPointAlreadyAligned;
				if(cptPointAlreadyAligned>nbPointAlreadyAligned) {
					break;
				}
			}
			alignPoint.add(p);
		}
		for(int j=1;this.GridPoints.contains(new Point(x - dir.getDx()*j,y - dir.getDy()*j))
				&&alignPoint.size()<=alignNumber-1;++j){//A MODIFIER SI ON VEUT FAIRE LE CHOIX
			Point p=this.GridPoints.get(this.GridPoints.indexOf(new Point(x - dir.getDx()*j,y - dir.getDy()*j)));
			if(p.getDirAlignments().contains(dir)){
				++cptPointAlreadyAligned;
				if(cptPointAlreadyAligned>nbPointAlreadyAligned) {
					break;
				}
			}
			alignPoint.add(p);
		}
		return alignPoint;
	}
	
	/**
	 * Check if an alignment of 'alignmentNumber' length with a certain number of Points already aligned
	 * exists.
	 * @param x coordinate checked
	 * @param y coordinate checked
	 * @param alignmentNumber
	 * @param nbPointAlreadyAligned
	 * @return true if the alignment is correct.
	 */
	
	protected boolean isAligned(int x, int y, int alignmentNumber, int nbPointAlreadyAligned) {
		for(Direction d : Direction.values()) {
			if(this.AlignedPointsByDirection(x, y, d,alignmentNumber,nbPointAlreadyAligned).size()>=alignmentNumber) {//A MODIFIER SI CHOIX
				return true;
			}
		}
		return false;
	}
	
	protected void placePoint(int x, int y, int alignmentNumber, int nbPointAlreadyAligned) {
		if(alignmentNumber<1||nbPointAlreadyAligned<0) {
			throw new IllegalArgumentException();
		}
		if(this.GridPoints.contains(new Point(x,y))) {
			return;
		}
		for(Direction d : Direction.values()) {
			if(this.AlignedPointsByDirection(x, y, d,alignmentNumber,nbPointAlreadyAligned).size()>=alignmentNumber) {
				LinkedList<Point> alignment=this.AlignedPointsByDirection(x, y, d,alignmentNumber,nbPointAlreadyAligned);
				this.listOfAlignment.add(new Line(new ArrayList<Point>(alignment)));
				for(Point p: alignment) {
					p.addDirection(d);
				}
				this.GridPoints.add(alignment.getFirst());
				this.PointPlayed.add(alignment.getFirst());
				break;//can find all the alignment possible for this point.
			}
		}

	}
	
	public ArrayList<Point> getGridPoints(){
		return new ArrayList<Point>(this.GridPoints);
	}


	public ArrayList<Line> getListOfAlignment() {
		return new ArrayList<Line>(this.listOfAlignment);
	}
	
	/**
	 * We look around the points already present in the grid if Points exist. 
	 * If not, it is a potential future neighbor that could allow an alignment. 
	 * Since two points can have the same neighbor, we use a set to avoid redundancy.
	 * @return Get all the potential future neighbors points of the grid points.
	 */


	private Set<Point> getNeighborsPoints() {
		Set<Point> setPoints=new LinkedHashSet<Point>();
		for(Point p : this.GridPoints) {
			for(Direction d : Direction.values()) {
				setPoints.add(new Point(p.getX()+d.getDx(),p.getY()+d.getDy()));
				setPoints.add(new Point(p.getX()-d.getDx(),p.getY()-d.getDy()));
			}
			
		}
		setPoints.removeAll(this.GridPoints);
		return setPoints;
	}
	
	/**
	 * We go through each of the potential neighbors of our points. 
	 * We look for each of them if they can allow an alignment. 
	 * If so, they are added to the set.
	 * @return All the points that can be played by the player thanks to isAligned() method.
	 *
	 */
	
	public Set<Point> getPossiblePoint(int nbPointForAlign, int nbPointsAlreadyALigned){//proposer des modif selon la version
		Set<Point> setPossiblePoints=new LinkedHashSet<Point>();
		for(Point p : this.getNeighborsPoints()) {
			if(this.isAligned(p.getX(), p.getY(), nbPointForAlign,nbPointsAlreadyALigned)) {
				setPossiblePoints.add(p);
			}
		}
		
		return new LinkedHashSet<Point>(setPossiblePoints);
	}//A vérifier
	
	/**
	 * This method selects randomly a point among the possible point that can be played,
	 * as long there is an eligible point.
	 */
	
	
	public void randomSolve() {
		Random random = new Random();
		while(this.getPossiblePoint().size()>0) {
			ArrayList<Point> setPoint = new ArrayList<Point>(this.getPossiblePoint());
			random.nextInt(setPoint.size());
			Point selectedPoint = setPoint.get(random.nextInt(setPoint.size()));
			this.placePoint(selectedPoint.getX(),selectedPoint.getY());
	
		}
	}

	public LinkedList<Point> getPointPlayed() {
		return PointPlayed;
	}
	
	public void restartGame() {
		this.gridInitialization(10, 3, 4);
		this.PointPlayed=new LinkedList<Point>();
		this.listOfAlignment=new LinkedList<Line>();
	}
	
	/**
	 * This method cancel the last Point placed. 
	 * We need to remove the last Point played, its last alignment, 
	 * and the direction (alignment direction) of the Points of the last alignments.
	 */
	
	public void cancelPlay() {
		if(this.getPointPlayed().size()>0) {
			Point lasPointPlaced = this.PointPlayed.getLast();
			Line line = this.listOfAlignment.getLast();
			for(Point p : line.getLinePoint()) {
				p.deleteLastDirection();
			}
			this.GridPoints.remove(lasPointPlaced);
			this.PointPlayed.removeLast();
			this.listOfAlignment.removeLast();
		}
	}
	
	
	
}
