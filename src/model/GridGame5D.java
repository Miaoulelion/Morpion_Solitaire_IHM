package model;

import java.util.Set;

public class GridGame5D extends GridGameAbstract{

	public GridGame5D() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected boolean isAligned(int x, int y, int alignmentNumber) {
		return super.isAligned(x, y, alignmentNumber, 0);
	}
	
	/**
	 * In the 5T Grid Game an alignment is define by 5 points and 
	 * no one of this points can be already aligned in the same direction.
	 */
	
	public void placePoint(int x, int y) {
		super.placePoint(x, y, 5, 0);
	}

	@Override
	public Set<Point> getPossiblePoint() {
		return super.getPossiblePoint(5, 0);
	}
	
}
