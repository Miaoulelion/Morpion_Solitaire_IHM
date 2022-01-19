package model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author chat-
 *
 */

public class Line {
	ArrayList<Point> LinePoint;
	Direction dirLine;
	
	public Line(List<Point> linePoint) {
		Point firstPoint = linePoint.get(0);
		Point lastPoint = linePoint.get(linePoint.size());
		if(!(this.isValidLine(firstPoint.getX(), firstPoint.getY(), lastPoint.getX(), lastPoint.getY()))) {
			throw new IllegalArgumentException("this is not a valid line");
		}

		this.LinePoint=new ArrayList<Point>(linePoint);
	}
	
	
	
	//Ca c'est le travail du controller !!! de v�rifier que c'est valide et tout
	
	public boolean isValidLine(int x1, int y1, int x2, int y2) {
		if(x1-x2==0||y1-y2==0||((x1-x2)==(y1-y2))){
			return true;
		}
		return false;
	}
	/*
	public Direction getDirectionLine(int x1, int y1, int x2, int y2) {
		if(x1)
	}*/
	
	//Un point doit appartenir � une ligne pour qu'on v�rifie en 5T que �a ne foire pas 

}
