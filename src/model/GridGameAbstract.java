package model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

import utils.Direction;

public abstract class GridGameAbstract implements IGridGame {
	private ArrayList<Point>GridPoints;
	private ArrayList<Line> listOfAlignment;
	private ArrayList<Point>PointPlayed;
	
	
	public GridGameAbstract() {
		this.GridPoints=new ArrayList<Point>();
		this.listOfAlignment=new ArrayList<Line>();
		this.PointPlayed=new ArrayList<Point>();
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
	 * for a number of some Points already aligned. We check all the direction and 
	 * return a LinkedList with the Points aligned.
	 * @param x the coordinate of the Point 
	 * @param y the coordinate of the Point 
	 * @param dir
	 * @param alignNumber
	 * @param nbPointAlreadyAligned
	 * @return
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
	 * @param x
	 * @param y
	 * @param alignmentNumber
	 * @param nbPointAlreadyAligned
	 * @return
	 */
	
	protected boolean isAligned(int x, int y, int alignmentNumber, int nbPointAlreadyAligned) {
		for(Direction d : Direction.values()) {
			if(this.AlignedPointsByDirection(x, y, d,alignmentNumber,nbPointAlreadyAligned).size()>=alignmentNumber) {//A MODIFIER SI CHOIX
				return true;
			}
		}
		return false;
	}
	
	public void placePoint(int x, int y, int alignmentNumber, int nbPointAlreadyAligned) {
		if(alignmentNumber<1||nbPointAlreadyAligned<0) {
			throw new IllegalArgumentException();
		}
		if(this.GridPoints.contains(new Point(x,y))) {
			return;
		}
		for(Direction d : Direction.values()) {
			if(this.AlignedPointsByDirection(x, y, d,alignmentNumber,nbPointAlreadyAligned).size()>=alignmentNumber) {
				LinkedList<Point> alignment=this.AlignedPointsByDirection(x, y, d,alignmentNumber,nbPointAlreadyAligned);
				this.listOfAlignment.add(new Line(new ArrayList<Point>(alignment)));//on ajoute l'alignement pour le tracer plus tard
				for(Point p: alignment) {
					p.addDirection(d);
				}
				this.GridPoints.add(alignment.getFirst());
				this.PointPlayed.add(alignment.getFirst());
				break;//sinon il continue de sortir les autres alignements, bien si on veut
				//faire bien les choses !
			}
		}

	}
	
	public ArrayList<Point> getGridPoints(){
		ArrayList<Point> GridPointsCopy= new ArrayList<Point>(this.GridPoints);
		return GridPointsCopy;
	}


	public ArrayList<Line> getListOfAlignment() {
		return new ArrayList<Line>(this.listOfAlignment);
	}
	
	/**
	 * 
	 * @return Get all the neighbors points of the grid points.
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
	 * @return All the points that can be played by the gamer thanks to isAligned() method.
	 *
	 */
	
	public Set<Point> getPossiblePoint(int nbPointForAlign, int nbPointsAlreadyALigned){//proposer des modif selon la version
		Set<Point> setPossiblePoints=new LinkedHashSet<Point>();
		for(Point p : this.getNeighborsPoints()) {
			if(this.isAligned(p.getX(), p.getY(), nbPointForAlign,nbPointsAlreadyALigned)) {
				setPossiblePoints.add(p);
			}
		}
		
		return setPossiblePoints;
	}
	
	/**
	 * Select randomly a point among the possible point that can be played,
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

	public ArrayList<Point> getPointPlayed() {
		return PointPlayed;
	}
	
	public void restartGame() {
		this.gridInitialization(10, 3, 4);
		this.PointPlayed=new ArrayList<Point>();
		this.listOfAlignment=new ArrayList<Line>();
	}
	
	
	
}
