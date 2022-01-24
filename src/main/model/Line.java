package main.model;

import java.util.ArrayList;
import java.util.Objects;

import main.utils.ComparePointByX;
import main.utils.ComparePointByY;

/**
 * The Line class permit to trace the lines possible when the point is placed.
 *
 */


public class Line {
	ArrayList<Point> linePoint;
	
	public Line() {
		this.linePoint=new ArrayList<Point>();
	}
	
	/**
	 * The line need to be sorted because we draw the line between the first and the last point.
	 * @param linePoint
	 */
	
	public Line(ArrayList<Point> linePoint) {
		Objects.requireNonNull(linePoint);
		this.linePoint=linePoint;
		this.linePoint.sort(new ComparePointByX());
		this.linePoint.sort(new ComparePointByY());
	}

	public ArrayList<Point> getLinePoint() {
		return new ArrayList<Point>(this.linePoint);
	}
}
