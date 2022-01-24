package main.model;

import java.util.ArrayList;
import java.util.Set;

/**
 * Main methods of a Grid Game, which interact with the controller and the view.
 */

public interface IGridGame {
	public void placePoint(int x, int y);
	public ArrayList<Point> getGridPoints();
	public ArrayList<Line> getListOfAlignment();
	public Set<Point> getPossiblePoint();
	public void randomSolve();
	public void restartGame();
	public void cancelPlay();
}
