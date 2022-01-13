package gridGames;

public interface IGridGame {
	public void placePawn(int x, int y);
	public boolean isAligned(int numLig, int numCol, int nbr);
}
