package model;

public class GridGame5T extends GridGameAbstract{
	
	public GridGame5T() {
		super();
	}
	
	public boolean isAligned(int x, int y, int alignmentNumber) {
		return super.isAligned(x, y, alignmentNumber, 1);
	}
	
	public void placePoint(int x, int y) {
		super.placePoint(x, y, 5, 1);
	}
	

}
