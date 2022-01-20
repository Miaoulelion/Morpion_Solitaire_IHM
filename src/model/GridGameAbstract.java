package model;

import java.util.ArrayList;
import java.util.Objects;
import utils.Direction;

public abstract class GridGameAbstract implements IGridGame {
	private ArrayList<Point>GridPoints;
	private ArrayList<Line> listOfAlignment;

	
	
	public GridGameAbstract() {
		this.GridPoints=new ArrayList<Point>();
		this.listOfAlignment=new ArrayList<Line>();
		gridInitialization(10,3,4);
	}
	
	
	/**
	 * This method place the points to form a cross. 
	 * @param x : coordinate (x value) of the beginning of the cross.
	 * @param y : coordinate (y value) of the beginning of the cross.
	 * @param widthCross : the width of the cross.
	 */
	
	public void gridInitialization(int x, int y, int widthCross) {
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
	
	
	public void placePoint(int x, int y) {
		if(!this.GridPoints.contains(new Point(x,y))&&this.isAligned(x, y, 5)) {
			this.GridPoints.add(new Point(x,y));
			System.out.println("Add point x="+x + " y="+y);
		}
	}
	

	

	public ArrayList<Point> AlignedPointsByDirection(int x, int y, Direction dir, int nbPointAlreadyAligned) {
		Objects.requireNonNull(dir);
		ArrayList<Point> alignPoint = new ArrayList<Point>();
		alignPoint.add(new Point(x,y));
		int cptPointAlreadyAligned=0;
		for(int j=1;this.GridPoints.contains(new Point(x + dir.getDx()*j,y + dir.getDy()*j));++j){
			Point p=this.GridPoints.get(this.GridPoints.indexOf(new Point(x + dir.getDx()*j,y + dir.getDy()*j)));
			if(p.getDirAlignment().isPresent()&&p.getDirAlignment().get()==dir) {
				++cptPointAlreadyAligned;
				if(cptPointAlreadyAligned>=nbPointAlreadyAligned) {
					break;
				}
			}
			alignPoint.add(p);
		}
		for(int j=1;this.GridPoints.contains(new Point(x - dir.getDx()*j,y - dir.getDy()*j));++j){
			Point p=this.GridPoints.get(this.GridPoints.indexOf(new Point(x - dir.getDx()*j,y - dir.getDy()*j)));
			if(p.getDirAlignment().isPresent()&&p.getDirAlignment().get()==dir) {
				++cptPointAlreadyAligned;
				if(cptPointAlreadyAligned>=nbPointAlreadyAligned) {
					break;
				}
			}
			alignPoint.add(p);
		}
		return alignPoint;
	}
	
	
	
	public boolean isAligned(int x, int y, int alignmentNumber, int nbPointAlreadyAligned) {
		for(Direction d : Direction.values()) {
			if(this.AlignedPointsByDirection(x, y, d,nbPointAlreadyAligned).size()>=alignmentNumber) {
				ArrayList<Point> alignment=this.AlignedPointsByDirection(x, y, d,nbPointAlreadyAligned);
				this.listOfAlignment.add(new Line(alignment));//on ajoute l'alignement pour le tracer plus tard
				for(Point p: alignment) {
					p.setDirAlignment(d);//SALE on écrit que le point est aligné
				}
				System.out.println("Alignment ("+x+";"+y+") : true");
				return true;
			}
		}
		return false;
	}
	
	public boolean isAligned(int x, int y, int alignmentNumber) {
		return isAligned(x, y, alignmentNumber,0);
	}
	
	
	//Puis dans la version 5T on vérifierait en plus l'autre condition
	
	public ArrayList<Point> getGridPoints(){
		ArrayList<Point> GridPointsCopy= new ArrayList<Point>(this.GridPoints);
		return GridPointsCopy;
	}


	public ArrayList<Line> getListOfAlignment() {
		return new ArrayList<Line>(this.listOfAlignment);
	}
	
	
	
}
