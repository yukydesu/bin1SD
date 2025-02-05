
import java.util.HashSet;

public class ListeCaracteres {

	private NoeudCaractere tete;
	// N'ajoutez pas d'autres attributs
	
	
	public ListeCaracteres() {
		this.tete=null;
		// N'ajoutez pas de noeud sentinelle!
	}
	
	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public ListeCaracteres(char[] tableCaracteres) {
		if(tableCaracteres==null)
			throw new IllegalArgumentException();
		for (int i = tableCaracteres.length-1; i>=0; i--) {
			this.tete=new NoeudCaractere(tableCaracteres[i],tete);
		}	
	}
	
	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public String toString(){	
		return toString(tete);
	}
	// A NE PAS MODIFIER --> POUR LES TESTS!!!	
	private String toString(NoeudCaractere noeud) {
		if(noeud == null)
			return "";
		return " " + noeud.caractere + toString(noeud.suivant);
	}

	/**
	 * insere un nouveau noeud soit en debut de liste, soit dans la liste, soit en fin
	 * @param position la position du nouveau noeud
	 * @param caractere le caractere place dans le nouveau noeud
	 * @return true si l'insertion a pu se faire, false sinon.
	 */
	public boolean inserer(int position, char caractere){
		//TODO
		//des indications sur l'implementation a suivre se trouvent dans le questionnaire d'examen 
		return false;
	}

	
	/**
	 * verifie la presence de caracteres identiques dans la liste
	 * @return true si la liste contient au moins 2 x un meme caractere, false sinon
	 */
	public boolean contientExAequos(){
		//TODO
		//des indications sur l'implementation a suivre se trouvent dans le questionnaire d'examen 
		return false;
	}
	
	
	/**
	 * verifie la presence du caractere passe en parametre dans la liste
	 * @param caractereRecherche
	 * @return true si le caractere est present dans la liste, false sinon
	 */
	public boolean contient(char caractereRecherche){
		return contient(tete,caractereRecherche);
	}
	
	private boolean contient(NoeudCaractere noeud, char caractereRecherche) {
		if(noeud == null)
			return false;
		if(noeud.caractere==caractereRecherche)
			return true;
		return contient(noeud.suivant, caractereRecherche);
	}

	
	/**
	 * calcule le nombre de fois qu'apparait le caractere passe en parametre dans la liste
	 * @param caractereRecherche
	 * @return le nombre d'occurrences du caractere
	 */
	public int nombreOccurrences(char caractereRecherche){
		//TODO
		//des indications sur l'implementation a suivre se trouvent dans le questionnaire d'examen
		return 0;
	}
	
	
	
	/**
	 * verifie la presence dans la liste d'au moins un des caracteres contenus dans la table passee en parametre
	 * @param tableCaracteresRecherches la table des caracteres recherches
	 * @return true si la liste contient au moins un caractere, false sinon
	 * @throws IllegalArgumentException
	 */

	public boolean contientCaractereTable(char[] tableCaracteresRecherches){
		if(tableCaracteresRecherches==null||tableCaracteresRecherches.length==0)
			throw new IllegalArgumentException();
		//TODO
		//des indications sur l'implementation a suivre se trouvent dans le questionnaire d'examen
		return false;
	}


	private class NoeudCaractere{
		private char caractere;
		private NoeudCaractere suivant;

	
		public NoeudCaractere(char caractere, NoeudCaractere suivant)throws IllegalArgumentException{
			this.caractere = caractere;
			this.suivant = suivant;
		}

	}
}
