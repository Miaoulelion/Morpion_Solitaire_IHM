package joueurs;

public class Gamer {
	private boolean winner;
	private int score;
	private Symbol symbol;
	
	public Gamer(Symbol symbol) {
		if(symbol.getValue()==' ') {
			throw new IllegalArgumentException("Symbole vide ne représente pas un joueur");
		}
		this.symbol=symbol;
		initGamer();
	}

	
	public void initGamer() {
		this.winner=false;
		this.score=0;
	}
	
	public Symbol getSymbol() {
		return this.symbol;
	}
	
	public void incrementScore() {
		++this.score;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void isWinner() {
		this.winner=true;
	}
	
	public boolean getWinner() {
		return this.winner;
	}

}
