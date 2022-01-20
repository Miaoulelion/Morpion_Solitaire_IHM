package utils;

import java.util.Comparator;

import model.Point;

public class ComparePointByY implements Comparator<Point>{

	@Override
	public int compare(Point p1, Point p2) {
		// TODO Auto-generated method stub
		return Integer.compare(p1.getY(), p2.getY());
	}
	
}