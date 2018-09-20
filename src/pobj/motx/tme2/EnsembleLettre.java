package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

public class EnsembleLettre {
	
	private List<Character> allLettres;
	
	public EnsembleLettre () {
		allLettres = new ArrayList();
	}

	public void add(char charAt) {
		allLettres.add(charAt);
		
	}
	
	public int size() {
		return allLettres.size();
	}

	public boolean contains(char c) {
		if (allLettres.contains(c))
			return true;
		return false;
	}
		
}
