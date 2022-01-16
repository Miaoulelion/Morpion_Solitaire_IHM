package model;

import java.util.ArrayList;

public interface IGridGame {
	public void placePoint(int x, int y);
	public boolean isAligned(int numLig, int numCol, int nbr);
	public ArrayList<Point> getGridPoints();
}
