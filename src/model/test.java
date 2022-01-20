package model;

import java.util.ArrayList;
import java.util.Comparator;

import utils.Direction;

public class test {

	public static void main(String[] args) {
		GridGame5D game=new GridGame5D();
		System.out.println(game.getGridPoints());
		game.placePoint(9, 5);
		System.out.println(game.AlignedPointsByDirection(9, 5, Direction.DIAGONALLEFT, 0));
		ArrayList<Point> a=game.AlignedPointsByDirection(9, 5, Direction.DIAGONALLEFT,0);
		
		
		
		//a.sort(new byY());
		//System.out.println(a);
		//a.sort(new byX());
		//System.out.println(a);
		
		game.placePoint(6, 8);
		System.out.println(game.AlignedPointsByDirection(6, 8, Direction.DIAGONALLEFT, 0));
		for(Point p : a) {
			p.setDirAlignment(Direction.DIAGONALLEFT);
		}
		System.out.println(game.AlignedPointsByDirection(6, 8, Direction.DIAGONALLEFT, 0));
		

	}
	


}




