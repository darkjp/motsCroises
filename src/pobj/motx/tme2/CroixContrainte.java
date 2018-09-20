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
		int ecart = 0;
		Dictionnaire dico1 = grille.getMotsPot().get(m1);
		Dictionnaire dico2 = grille.getMotsPot().get(m2);
		List<Character> liste1 = new ArrayList<>();
		List<Character> liste2 = new ArrayList<>();
		EnsembleLettre el = new EnsembleLettre();

		// parcourt la liste de mots du dico et stocke les
		// char dans des listes
		for (String mot : dico1.getListeMots()) {
			if (!liste1.contains(mot.charAt(c1)))
				liste1.add(mot.charAt(c1));
		}
		for (String mot : dico2.getListeMots()) {
			if (!liste2.contains(mot.charAt(c2)))
				liste2.add(mot.charAt(c2));
		}

		// parcourt les listes de char ci dessus
		// et stocke dans croisement
		for (Character c : liste1) {
			if ((liste2.contains(c)) && !el.contains(c)) {
				el.add(c);
			}
		}
		for (Character c : liste2) {
			if ((liste1.contains(c)) && !el.contains(c)) {
				el.add(c);
			}
		}

		// check la taille des liste comme indiqué dans l'énoncé
		// pourquoi ? Ca par contre...
		if (liste1.size() > el.size()) {
			ecart = dico1.size();
			dico1.filtreParLettre(el, c1);
			return ecart - dico1.size();
		} else if (liste2.size() > el.size()) {
			ecart = dico2.size();
			dico2.filtreParLettre(el, c2);
			return ecart - dico2.size();
		} else
			return 0;
	}

	@Override
	public boolean equals(Object obj) {
		CroixContrainte cont;
		if (obj instanceof CroixContrainte) {
			cont = (CroixContrainte) obj;
			return (this.m1 == cont.m1) && (this.m2 == cont.m2) && (this.c1 == cont.c1) && (this.c2 == cont.c2);
		} else
			return false;
	}
}
