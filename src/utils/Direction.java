package utils;

public enum Direction {
    VERTICAL(0,-1),HORIZONTAL(-1,0),DIAGONALRIGHT(1,1),DIAGONALLEFT(1,-1);

	private final int dx, dy;

	Direction(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

}
