package main.model;

import java.util.LinkedList;
import java.util.Objects;
import main.utils.Direction;

public class Point {
	private int x;
	private int y;
	private LinkedList<Direction> dirAlignments;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
		this.dirAlignments=new LinkedList<Direction>();
	}
	
	/**
	 * A point can be aligned in many directions. We need to save all that directions,
	 * to verify if a new point can be added next to this point.
	 * @param dir
	 */
	protected void addDirection(Direction dir) {
		Objects.requireNonNull(dir);
		this.dirAlignments.add(dir);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	/**
	 * We the gamer wants to cancel the last point that he have placed,
	 * we need to delete the last direction added at this point and its alignment.
	 * This method allows it.
	 */

	protected void deleteLastDirection() {
		this.dirAlignments.removeLast();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y +"]";
	}


	protected LinkedList<Direction> getDirAlignments() {
		return dirAlignments;
	}



}
