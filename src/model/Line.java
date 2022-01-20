package model;

import java.util.ArrayList;
import java.util.Objects;

import utils.Direction;
import utils.ComparePointByX;
import utils.ComparePointByY;

/**
 * 
 * @author chat-
 *
 */

public class Line {
	ArrayList<Point> linePoint;
	Direction dirLine;
	
	public Line() {
		this.linePoint=new ArrayList<Point>();
	}
	
	public Line(ArrayList<Point> linePoint) {
		Objects.requireNonNull(linePoint);
		this.linePoint=linePoint;
		this.linePoint.sort(new ComparePointByX());
		this.linePoint.sort(new ComparePointByY());
	}
	
	

	public ArrayList<Point> getLinePoint() {
		//System.out.println(this.linePoint);
		return new ArrayList<Point>(this.linePoint);
	}
	


}
