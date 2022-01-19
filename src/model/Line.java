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
	
	
	
	//Ca c'est le travail du controller !!! de vérifier que c'est valide et tout
	
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
	
	//Un point doit appartenir à une ligne pour qu'on vérifie en 5T que ça ne foire pas 

}
