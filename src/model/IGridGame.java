package model;

import java.util.Iterator;

public interface IGridGame {
	public void placePoint(int x, int y);
	public boolean isAligned(int numLig, int numCol, int nbr);
	public Iterator<Point> getGridPoints();
}
