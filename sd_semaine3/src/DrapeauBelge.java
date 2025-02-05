
public class DrapeauBelge {
	
	private NoeudCouleur premierNoir;	
	private NoeudCouleur dernierJaune;
	// NE PAS AJOUTER D'AUTRES ATTRIBUTS!!!
	
	/**
	 * construit une chaine contenant 3 noeuds avec les caracteres 'n', 'j' et 'r' (dans cet ordre)
	 */
	public DrapeauBelge() {
		//TODO //

		NoeudCouleur noeudNoir = new NoeudCouleur('n');
		NoeudCouleur noeudJaune = new NoeudCouleur('j');
		NoeudCouleur noeudRouge = new NoeudCouleur('r');

		noeudNoir.suivant = noeudJaune;
		noeudJaune.suivant = noeudRouge;

		premierNoir = noeudNoir;
		dernierJaune = noeudJaune;
	}

	/**
	 * ajoute un noeud avec la couleur passee en parametre dans la chaine
	 * La chaine doit respecter les couleurs du  drapeau belge : noir/jaune/rouge
	 * @param couleur un caractere representant une couleur du drapeau belge : 'n', 'j' ou 'r'
	 * @throws IllegalArgumentException si le caractere ne correspond pas a un des 3 caracteres : 'n', 'j' ou 'r'
	 */
	public void ajouter(char couleur){
		// TODO

		if (couleur != 'n' && couleur != 'j' && couleur != 'r')
			throw new IllegalArgumentException();

		NoeudCouleur noeudTemp = new NoeudCouleur(couleur);

		if (couleur == 'n') {
			noeudTemp.suivant = premierNoir;
			premierNoir = noeudTemp;
		}

		if (couleur == 'j') {
			noeudTemp.suivant = dernierJaune.suivant;
			dernierJaune.suivant = noeudTemp;
			dernierJaune = noeudTemp;
		}

		if (couleur == 'r') {
			noeudTemp.suivant = dernierJaune.suivant;
			dernierJaune.suivant = noeudTemp;
		}
	}

	// A NE PAS MODIFIER. VA SERVIR POUR LES TESTS
	public String toString(){
		String drapeau="";
		NoeudCouleur baladeur = premierNoir;
		int cpt = 0;
		while(baladeur!=null){
			cpt++;
			if(cpt==100){
				return "boucle infinie dans toString(), chainage a verifier";
			}
			drapeau+=baladeur.couleur;
			baladeur = baladeur.suivant;
		}
		return drapeau;
	}
	
	private class NoeudCouleur{
		
		private char couleur;
		private NoeudCouleur suivant;
		
		private NoeudCouleur(char couleur){
			this.couleur = couleur;
			this.suivant = null;
		}
		
		private NoeudCouleur(char couleur, NoeudCouleur suivant){
			this.couleur = couleur;
			this.suivant = suivant;
		}

	}
}
