package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.GrillePlaces;

public class GrillePotentiel {

	private GrillePlaces grilleActuelle;
	private Dictionnaire dicoFR;
	private List<Dictionnaire> motsPot;
	private List<IContrainte> contraintes;

	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		this.grilleActuelle = grille;
		this.dicoFR = dicoComplet;
		this.motsPot = new ArrayList<>();
		this.contraintes = new ArrayList<>();

		for (Emplacement e : grilleActuelle.getPlaces()) {
			Dictionnaire copyDico = dicoFR.copy();
			copyDico.filtreLongueur(e.size());

			// récup la liste de cases
			for (int i = 0; i < e.getCases().size(); i++) {
				// récup la case & la check
				Case c = e.getCases().get(i);
				if (!c.isPleine() && !c.isVide()) {
					char lettre = c.getChar();
					copyDico.filtreParLettre(lettre, i);
				}
			}
			motsPot.add(copyDico);
		}
				
		// parcourt les emplacements Horizontaux
		for (int m1 = 0; m1 < grilleActuelle.getNbHorizontal(); m1++) {
			List<Case> caseH = grilleActuelle.getPlaces().get(m1).getCases();
			// parcourt les emplacements Verticaux
			for (int m2 = grilleActuelle.getNbHorizontal(); m2< grilleActuelle.getPlaces().size(); m2++) {
				List<Case> caseV = grilleActuelle.getPlaces().get(m2).getCases();
				// parcourt les les cases des emplacements Horizontaux
				for (int c1= 0; c1 < caseH.size(); c1++) {
					// parcourt les cases des emplacements Verticaux
					for (int c2 = 0; c2< caseV.size(); c2++) {
						// verif case = case, et les cases vides pour Horiz et Vert
						if (caseH.get(c1).equals(caseV.get(c2)) && caseH.get(c1).isVide() && caseV.get(c2).isVide()) {
									contraintes.add(new CroixContrainte(m1, c1, m2, c2));
						}
					}
				}
			}
		}
	}

	public GrillePlaces getGrillePlaces() {
		return grilleActuelle;
	}

	public GrillePotentiel fixer(int m, String soluce) {
		GrillePlaces gp = grilleActuelle.fixer(m, soluce);
		return new GrillePotentiel(gp, dicoFR);
	}

	public boolean isDead() {
		for (int i = 0; i < grilleActuelle.getPlaces().size(); i++) {
			if (motsPot.get(i).size() == 0) {
				return true;
			}
		}
		return false;
	}

	public List<Dictionnaire> getMotsPot() {
		return motsPot;
	}

	public List<IContrainte> getContraintes() {
		return contraintes;
	}

}
