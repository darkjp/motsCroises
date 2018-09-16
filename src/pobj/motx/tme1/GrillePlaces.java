package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class GrillePlaces {
	private List<Emplacement> places;
	private int cpt, nbHori;
	private Grille grille;

	public GrillePlaces(Grille grille) {
		this.places = new ArrayList<Emplacement>();
		this.cpt = 0;
		this.grille = grille;

		for (int i = 0; i < grille.nbLig(); i++) {
			cherchePlace(grille.getLig(i));
			nbHori += cpt;
		}

		for (int i = 0; i < grille.nbCol(); i++) {
			cherchePlace(grille.getCol(i));
		}

	}

	/*
	 * parcours la liste de cases envoy�es en param et v�rifie si la case est vide
	 * (blanche). Si vide: ajoutee la liste "mot" Si la case est pleine, on verifie
	 * que "mot" contient quelque chose et on ajoute ce quelquechose "places" (la
	 * liste d'emplacement en attribut de classe).
	 **/
	private void cherchePlace(List<Case> cases) {
		List<Case> mot = new ArrayList<Case>();
		cpt = 0;

		for (Case c : cases) {
			if (c.isPleine()) {
				if (mot.size() > 1) {
					places.add(new Emplacement(mot));
					cpt++;
				}
				mot = new ArrayList<Case>();
			} else {
				mot.add(c);
			}
		}
		if (mot.size() > 1) {
			places.add(new Emplacement(mot));
			cpt++;
		}
	}

	// acceder aux mots detectes
	public List<Emplacement> getPlaces() {
		return places;

	}

	public int getNbHorizontal() {
		// System.out.println("cpt : "+ cpt + "places : " + places.size());
		return nbHori;

	}

	public String getEmplacement() {
		StringBuilder str = new StringBuilder();

		for (Emplacement e : places)
			str.append(e.toString());
		return str.toString();
	}

	public GrillePlaces fixer(int m, String soluce) {
		GrillePlaces grilleCpy = new GrillePlaces(grille.copy());
		Emplacement e = grilleCpy.getPlaces().get(m);
		// parcourir toutes les cases de "e"
		for (int i = 0; i < e.size(); i++) {
			e.getCases().get(i).setChar(soluce.charAt(i));
		}
		return grilleCpy;
	}

	public String toString(String result) {
		return result;

	}

}
