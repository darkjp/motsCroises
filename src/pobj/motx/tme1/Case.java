package pobj.motx.tme1;

public class Case {
	private int mLigne, mColonne;
	private char mLettre;

	public Case(int lig, int col, char c) {
		mLigne = lig;
		mColonne = col;
		mLettre = c;
	}

	public int getLig() {
		return mLigne;
	}

	public int getCol() {
		return mColonne;
	}

	public char getChar() {
		return mLettre;
	}

	public void setChar(char c) {
		mLettre = c;
	}

	public boolean isVide() {
		if (mLettre == ' ')
			return true;
		return false;
	}

	public boolean isPleine() {
		if (mLettre == '*')
			return true;
		return false;
	}

}
