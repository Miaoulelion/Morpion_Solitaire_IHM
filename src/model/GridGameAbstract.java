package model;

import java.util.ArrayList;

public abstract class GridGameAbstract implements IGridGame {
	private ArrayList<Point>GridPoints;
	final private int [] DirX = {0,1,1,1};
	final private int [] DirY = {-1,-1,0,1};
	
	
	public GridGameAbstract() {
		this.GridPoints=new ArrayList<Point>();
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
			System.out.println("Alignment : "+ this.isAligned(x, y, 5));
		}
	}
	
	
	public boolean isOccupied(int x, int y) {
		if(this.GridPoints.contains(new Point(x,y))) {
			return true;
		}
		return false;
	}
	
	/** 
	 * We see if there is an adjacent point. 
	 * In this case, we go in its direction, we sum the points aligned on this direction.
	 * And we return the maximal number of aligned points (after all the directions are checked).
	 * Here we visit the direction in one way only (to the top, to the left, to the right, ...).
	 * @param x
	 * @param y
	 * @param DirX
	 * @param DirY
	 * @return the maximal number of aligned Point from a Point (in one way of a direction)
	 */
	
	public int numberAlignedPointsByDirection(int x, int y, int DirX, int DirY) {
		if(!(DirX==1 || DirX==-1 || DirX==0) && !(DirY==1 || DirY==-1 || DirY==0)) {
			throw new IllegalArgumentException("La direction donnée en paramètre est invalide : " + DirX + " " + DirY);
		}
		int nbPoints=0;
		for(int j=1;this.GridPoints.contains(new Point(x + DirX*j,y + DirY*j));++j){
			++nbPoints;
		}
		return nbPoints;
	}
	
	/**
	 * We use the numberAlignedPointsByDirection() method to check all the ways directions
	 * and return the maximal number of aligned points (to the right AND to the left, to the top AND to the bottom).
	 * @param x
	 * @param y
	 * @param DirX
	 * @param DirY
	 * @return the maximal number of aligned Point from a Point (coordinate x, y) + the point itself
	 */
	
	public int numberAlignedPoints(int x, int y, int DirX, int DirY) {
		int nbSymbole=numberAlignedPointsByDirection(x, y, DirX, DirY);
		nbSymbole+=numberAlignedPointsByDirection(x, y, -DirX, -DirY);
		return nbSymbole+1; 
	}
	
	
	/**
	 * Return true if there is an alignment of "alignmentNumberChoix" length Point.
	 * @return boolean
	 */

	public boolean isAligned(int x, int y, int alignmentNumberChoice) {
		if(alignmentNumberChoice<=0) {
			throw new IllegalArgumentException("The number alignment required need to be >0.");
		}
		for(int i=0;i<this.DirX.length;++i) {
			int nbSymb=0;
			nbSymb=numberAlignedPoints(x, y, this.DirX[i], this.DirY[i]);
			if(nbSymb>=alignmentNumberChoice) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Point> getGridPoints(){
		ArrayList<Point> GridPointsCopy= new ArrayList<Point>(this.GridPoints);
		return GridPointsCopy;
	}
	
	
	
}
