package main.model;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import main.utils.Direction;

public class Point {
	private int x;
	private int y;
	private Set<Direction> dirAlignments;
	
	public Point(int x, int y) {
		if(x<0||y<0) {
			throw new IllegalArgumentException("x and y point coordinates can't be <0.");
		}
		this.x=x;
		this.y=y;
		this.dirAlignments=new LinkedHashSet<Direction>();
	}
	
	/**
	 * A point can be aligned in many directions. We need to save all that directions,
	 * to verify if a new point can be added next to this point.
	 * @param dir
	 */
	public void addDirection(Direction dir) {
		Objects.requireNonNull(dir);
		this.dirAlignments.add(dir);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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


	public Set<Direction> getDirAlignments() {
		return dirAlignments;
	}



}
