package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class Grille {
	Case[][] matCase;

	public Grille(int hauteur, int largeur) {
		this.matCase = new Case[hauteur][largeur];

		/*
		 * parcours la matrice matCase et crée une case qui a pour hauteur i et largeur
		 * les indices de la double boucle for. La valeur de la case est "vide"
		 */
		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++)
				matCase[i][j] = new Case(i, j, ' ');
		}
	}

	public Case getCase(int lig, int col) {
		return matCase[lig][col];
	}

	public int nbLig() {
		return matCase.length;
	}

	public int nbCol() {
		return matCase[0].length;
	}

	public List<Case> getLig(int lig) {
		List<Case> casesDansLaLigne = new ArrayList<>();

		for (Case c : matCase[lig]) {
			casesDansLaLigne.add(c);
		}
		return casesDansLaLigne;
	}

	// r�cup�re le nombre de colonne
	public List<Case> getCol(int col) {
		List<Case> casesDansLaColonne = new ArrayList<>();

		for (int i = 0; i < matCase.length; i++) {
			casesDansLaColonne.add(getCase(i, col));
		}
		return casesDansLaColonne;

	}

	public Grille copy() {
		int copyLig = nbLig();
		int copyCol = nbCol();
		char value;
		Grille matCaseCopy = new Grille(copyLig, copyCol);

		for (int i = 0; i < copyLig; i++) {
			for (int j = 0; j < copyCol; j++) {
				value = matCase[i][j].getChar();
				matCaseCopy.getCase(i, j).setChar(value);
			}
		}

		return matCaseCopy;
	}

	public String toString() {
		return GrilleLoader.serialize(this, false);

	}

}
