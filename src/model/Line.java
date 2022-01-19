package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author chat-
 *
 */

public class Line {
	ArrayList<Point> linePoint;
	Direction dirLine;
	
	public Line(ArrayList<Point> linePoint) {
		Objects.requireNonNull(linePoint);
		this.linePoint=linePoint;
	}

	public ArrayList<Point> getLinePoint() {
		return new ArrayList<Point>(linePoint);
	}
	


}
