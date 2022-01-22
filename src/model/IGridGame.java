package model;

import java.util.ArrayList;
import java.util.Set;


public interface IGridGame {
	public void placePoint(int x, int y);
	public ArrayList<Point> getGridPoints();
	public ArrayList<Line> getListOfAlignment();
	public Set<Point> getPossiblePoint();
	public void randomSolve();
	public void restartGame();
}
