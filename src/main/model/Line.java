package main.model;

import java.util.ArrayList;
import java.util.Objects;

import main.utils.ComparePointByX;
import main.utils.ComparePointByY;
import main.utils.Direction;


public class Line {
	ArrayList<Point> linePoint;
	Direction dirLine;
	
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
