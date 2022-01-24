package main.model;

import java.util.Set;

public class GridGame5T extends GridGameAbstract{
	
	public GridGame5T() {
		super();
		
	}
	
	protected boolean isAligned(int x, int y, int alignmentNumber) {
		return super.isAligned(x, y, alignmentNumber, 1);
	}
	
	/**
	 * In the 5T Grid Game an alignment is define by 5 points and 
	 * one of this points can be already aligned in the same direction.
	 */
	
	public void placePoint(int x, int y) {
		super.placePoint(x, y, 5, 1);
	}

	@Override
	public Set<Point> getPossiblePoint() {
		return super.getPossiblePoint(5, 1);
	}
	

}
