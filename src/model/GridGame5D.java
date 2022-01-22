package model;

public class GridGame5D extends GridGameAbstract{

	public GridGame5D() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public boolean isAligned(int x, int y, int alignmentNumber) {
		return super.isAligned(x, y, alignmentNumber, 0);
	}
	
	
	public void placePoint(int x, int y) {
		super.placePoint(x, y, 5, 0);
	}
	
}
