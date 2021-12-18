package gridGames;

import joueurs.Gamer;
import joueurs.Symbol;

public abstract class GridGameAbstract implements IGridGame {
	private int nbLig;
	private int nbCol;
	private boolean FinDePartie;
	private Symbol [][] Grille;
	final private int [] DirX = {0,1,1,1};
	final private int [] DirY = {-1,-1,0,1};
	private Gamer J1;
	private Gamer J2;
	private Gamer JoueurActuel;
	private boolean isVictory;
	
	
	public GridGameAbstract(int nbCol, int nbLig) {
		this.nbCol=nbCol;
		this.nbLig=nbLig;
		this.FinDePartie=false;
		this.Grille=new Symbol[nbLig][nbCol];
		this.J1=new Gamer(Symbol.J1);
		this.JoueurActuel=this.J1;
		this.J2=new Gamer(Symbol.J2);

		this.isVictory=false;
		gridInitialization();
	}
	
	
	public void gridInitialization() {
		for(int i=0;i<this.nbLig;++i) {
			for(int j=0;j<this.nbCol;++j) {
				this.Grille[i][j]=Symbol.Vide;
			}
		}
	}
	
	
	public String toString() {
		String s="";
		for(int i=0;i<this.nbCol;++i) {
			s+="[" + (i+1) + "]";
		}
		s+="\n";
		for(int i=0;i<this.nbLig;++i) {
			for(int j=0;j<this.nbCol;++j) {
				s+="[" + Grille[i][j].getValue() + "]";
			}
			s+="\n";
		}
		return s;
	}
	
	
	public void placePawn(int numCol, int numLig, Symbol Joueur) {
		this.Grille[numLig-1][numCol-1]=Joueur;
	}
	
	
	public boolean isAllowed(int numCol, int numLig) {
		if(!isInTheGrid(numCol,numLig)) {
			return false;
		}
		else if(isOccupied(numCol,numLig)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean isInTheGrid(int numCol, int numLig) {
		if(numCol<1 || numLig<1 || numCol>this.nbCol || numLig>this.nbLig) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	public boolean isOccupied(int numCol, int numLig) {
		if(this.Grille[numLig-1][numCol-1]!=Symbol.Vide) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isCompleted() {
		for(int i=0;i<this.nbCol;++i) {
			for(int j=0;j<this.nbLig;++j) {
				if(this.Grille[j][i]==Symbol.Vide) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public boolean getVictory() {
		return this.isVictory;
	}
	
	
	public boolean getEndGame() {
		return this.FinDePartie;
	}
	
	public Symbol getSymboleGrille(int numLig, int numCol) {
		return this.Grille[numLig-1][numCol-1];
	}
	
	
	//Renvoi sur une direction donnée le nombre de Symboles==Symboles en param alignés
	//Ne comptabilise pas le Symbole placé ni le sens opposé !
	public int NbrSymbolesAdjDir(int numLig, int numCol, int DirX, int DirY, Symbol symbole) {
		if(!(DirX==1 || DirX==-1 || DirX==0) && !(DirY==1 || DirY==-1 || DirY==0)) {
			throw new IllegalArgumentException("La direction donnée en paramètre est invalide : " + DirX + " " + DirY);
		}
		int nbSymbole=0;
		for(int j=1;(this.isInTheGrid(numCol + DirY*j, numLig + DirX*j)) 
				&& (this.Grille[numLig-1 + DirX*j][numCol-1 + DirY*j]==symbole);++j){
			++nbSymbole;
		}
		return nbSymbole;
	}
	
	//attention compte par avance le pion placé
	public int NbrSymbolesAlignés(int numLig, int numCol, int DirX, int DirY, Symbol symbole) {
		int nbSymbole=NbrSymbolesAdjDir(numLig, numCol, DirX, DirY, symbole);
		nbSymbole+=NbrSymbolesAdjDir(numLig, numCol, -DirX, -DirY, symbole);
		return nbSymbole+1;
	}
	 
	public boolean estAlignement(int numLig, int numCol, int nbr, Symbol symbole) {
		for(int i=0;i<this.DirX.length;++i) {
			int nbSymb=0;
			nbSymb=NbrSymbolesAlignés(numLig, numCol, this.DirX[i], this.DirY[i], symbole);
			if(nbSymb>=nbr) {
				return true;
			}
		}
		return false;
	}
	
	
	
	protected void isEndGame(int numLig, int numCol, int nbr, Symbol symbole) {
		if(this.estAlignement(numLig, numCol, nbr, symbole)) {
			this.isVictory=true;
			this.FinDePartie=true;
		}
		else if(this.isCompleted()) {
			this.isVictory=false;
			this.FinDePartie=true;
		}
	}
	
	public int getNbLig() {
		return this.nbLig;
	}
	
	
	public Gamer getJoueurActuel() {
		return this.JoueurActuel;
	}
	
	public void ChangerJoueur() {
		if(this.JoueurActuel.getSymbol()==Symbol.J1) {
			this.JoueurActuel=this.J2; //J2
		}
		else if(this.JoueurActuel.getSymbol()==Symbol.J2) {
			this.JoueurActuel=this.J1; //J1
		}
	}
	
	public Symbol getSymboleJoueurActuel() {
		return this.JoueurActuel.getSymbol();
	}
}
