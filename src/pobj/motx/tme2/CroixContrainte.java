package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

public class CroixContrainte implements IContrainte {

	private int m1, m2, c1, c2;

	public CroixContrainte(int m1, int c1, int m2, int c2) {
		this.m1 = m1;
		this.c1 = c1;
		this.m2 = m2;
		this.c2 = c2;
	}

	@Override
	public int reduce(GrillePotentiel grille) {
		Dictionnaire dico1 = grille.getMotsPot().get(m1);
		Dictionnaire dico2 = grille.getMotsPot().get(m2);
		List<Character> l1 = new ArrayList<Character>();
		List<Character> l2 = new ArrayList<Character>();
		List<Character> croisement = new ArrayList<Character>();
		int ecart;

		// parcourt la liste de mots du dico et stocke les
		// char dans des listes
		for (String mot : dico1.getListeMots()) {
			if (l1.contains(mot.charAt(c1)) == false)
				l1.add(mot.charAt(c1));
		}
		for (String mot : dico2.getListeMots()) {
			if (l1.contains(mot.charAt(c2)) == false)
				l1.add(mot.charAt(c2));
		}

		// parcourt les listes de char ci dessus
		// et stocke dans croisement
		for (Character c : l1) {
			if (l2.contains(c) && !croisement.contains(c)) {
				croisement.add(c);
			}
		}
		for (Character c : l2) {
			if (l1.contains(c) && !croisement.contains(c)) {
				croisement.add(c);
			}
		}

		// Constituer une liste. Intersection des deux dicos
		EnsembleLettre el = new EnsembleLettre();
		for (Character c : croisement) {
			el.add(c);
		}

		if (l1.size() > croisement.size()) {
			ecart = dico1.size();
			dico1.filtreParLettre(el, c1);
			return ecart - dico1.size();
		}
		if (l2.size() > croisement.size()) {
			ecart = dico2.size();
			dico1.filtreParLettre(el, c2);
			return ecart - dico2.size();
		}
		return 0;
	}
	
	public boolean equals(Object o) {
		
		return false;
	}
}
