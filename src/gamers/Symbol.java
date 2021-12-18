package gamers;

public enum Symbol {
	Vide(' '), J1('X'), J2('O');
	
	private char value;


	Symbol(char Symbole) {
		this.value=Symbole;

	}
	
	public char getValue() {
		return this.value;
	}
}
