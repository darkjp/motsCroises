package pobj.motx.tme1;

import java.util.List;

public class Emplacement {

	private List<Case> lettres;
	private int taille;

	public Emplacement(List<Case> c) {
		lettres = c;
		taille = c.size();
	}

	public List<Case> getCases() {
		return lettres;
	}

	public int getLigne() {
		return taille;
	}

	public int size() {
		return lettres.size();
	}

	public String getMot() {
		StringBuilder str = new StringBuilder();
		for (Case c : lettres)
			str.append(c.getChar());
		return str.toString();
	}

	public String toString(String result) {
		return result;

	}

}
