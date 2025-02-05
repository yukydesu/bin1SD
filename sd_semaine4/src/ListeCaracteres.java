import java.util.NoSuchElementException;

import java.util.ArrayList;
public class ListeCaracteres {

	private NoeudCaractere tete;
	// N'ajoutez pas d'autres attributs
	
	public ListeCaracteres() {
		this.tete=null;
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
		String aRenvoyer = "";
		NoeudCaractere baladeur = tete;
		while(baladeur != null) {
			aRenvoyer += " " + baladeur.caractere;
			baladeur = baladeur.suivant;
		}
		return aRenvoyer;
	}
	
	// A NE PAS MODIFIER --> POUR LES TESTS !!!
	public void remplacerToutParX(){
		NoeudCaractere baladeur = tete;
		while(baladeur != null) {
			baladeur.caractere = 'x';
			baladeur = baladeur.suivant;
		}
	}
	
	/**
	 * verifie la presence du caractere passe en parametre dans la liste
	 * @param caractereRecherche
	 * @return true si le caractere est present dans la liste, false sinon
	 */
	public boolean contient(char caractereRecherche){
		//TODO //


		NoeudCaractere baladeur = tete;

		while (baladeur != null) {
			if (baladeur.caractere == caractereRecherche)
				return true;

			baladeur = baladeur.suivant;
		}
		
		return false;

	}

	
	/**
	 * calcule le nombre de fois qu'apparait le caractere passe en parametre dans la liste
	 * @param caractereRecherche
	 * @return le nombre d'occurrences du caractere
	 */
	public int nombreOccurrences(char caractereRecherche){
		//TODO //

		NoeudCaractere baladeur = tete;
		int count = 0;

		while (baladeur != null) {
			if (baladeur.caractere == caractereRecherche)
				count ++;

			baladeur = baladeur.suivant;
		}
		
		return count;
	}

	
	/**
	 * remplace la 1ere occurrences du caractere a remplacer par un nouveau caractere
	 * @param caractereARemplacer le caractere a remplacer
	 * @param nouveauCaractere le nouveau caractere
	 */
	public void remplacer(char caractereARemplacer, char nouveauCaractere){
		//TODO //

		NoeudCaractere baladeur = tete;

		while (baladeur != null) {
			if (baladeur.caractere == caractereARemplacer)  {
				baladeur.caractere = nouveauCaractere;
				break;
			}

			baladeur = baladeur.suivant;
		}
	}

	
	/**
	 * remplace toutes les occurrences du caractere a remplacer par un nouveau caractere
	 * @param caractereARemplacer le caractere a remplacer
	 * @param nouveauCaractere le nouveau caractere
	 */
	public void remplacerTout(char caractereARemplacer, char nouveauCaractere){
		//TODO /

		NoeudCaractere baladeur = tete;

		while (baladeur != null) {
			if (baladeur.caractere == caractereARemplacer)
				baladeur.caractere = nouveauCaractere;

			baladeur = baladeur.suivant;
		}
	}
	
	/**
	 * recherche le plus grand caractere de la liste ('a'<'b'< ...)
	 * @return le plus grand caractere 
	 * @throws NoSuchElementException si la liste est vide
	 */
	public char max() throws NoSuchElementException{
		// TODO	//

		if (tete == null)
			throw new NoSuchElementException();

		NoeudCaractere baladeur = tete;
		char charTemp = ' ';

		while (baladeur != null) {

			if (baladeur.caractere > charTemp)
				charTemp = baladeur.caractere;

			baladeur = baladeur.suivant;
		}
		return charTemp;
	}
	
	
	
	
	/**
	 * cree une arrayList contenant les caracteres de la liste 
	 * L'ordre doit etre respecte (une liste est une structure lineaire)
	 * @return l'arrayList cree
	 */
	public ArrayList<Character> enArrayList(){
		// add() est en O(1)!
		// TODO //

		ArrayList<Character> listeTemp = new ArrayList<>();
		NoeudCaractere baladeur = tete;

		while (baladeur != null) {

			listeTemp.addLast(baladeur.caractere);
			baladeur = baladeur.suivant;
		}
		return  listeTemp;
	}

	/**
	 * verifie si les 2 listes contiennent les memes caracteres et ceci dans le meme ordre
	 * Une liste est une structure LINEAIRE!
	 * @param l la liste a comparer a la liste courante
	 * @return true si les 2 listes sont les memes, false sinon
	 */
	public boolean estEgalA(ListeCaracteres l){
		// N'utilisez pas la methode toString()!
		// TODO //

		if (this.tete == null && l.tete != null)
			return false;

		if (this.tete != null && l.tete == null)
			return false;

		NoeudCaractere baladeurThis = tete;
		NoeudCaractere baladeurL = l.tete;


		while(baladeurThis != null) {

			if (baladeurThis.suivant == null && baladeurL.suivant != null)
				return false;

			if (baladeurThis.suivant != null && baladeurL.suivant == null)
				return false;

			if (baladeurThis.caractere != baladeurL.caractere)
				return false;

			baladeurThis = baladeurThis.suivant;
			baladeurL = baladeurL.suivant;
		}
		return true;
	}
	
	/**
	 * cree une liste qui est une copie de la liste courante (meme ordre)
	 * @return une copie de la liste courante
	 */
	public ListeCaracteres clone(){
		// DEFI!
		// TODO //



		ListeCaracteres listeCLone = new ListeCaracteres();
		NoeudCaractere baladeurThis = tete;

		if (this.tete == null)
			return listeCLone;

		NoeudCaractere teteCopie = new NoeudCaractere(tete.caractere, null);
		listeCLone.tete = teteCopie;
		NoeudCaractere baladeurCopier = teteCopie;

		while (baladeurThis.suivant != null) {

			NoeudCaractere noeudTemp = new NoeudCaractere(baladeurThis.suivant.caractere, null);
			baladeurCopier.suivant = noeudTemp;

			baladeurThis = baladeurThis.suivant;
			baladeurCopier = baladeurCopier.suivant;
		}
		return listeCLone;
	}

	

	/**
	 * supprime une fois le caractere passe en parametre
	 * si le caractere se trouve plusieurs fois, c est sa premiere occurrence qui sera supprimee
	 * @param caractereASupprimer
	 * @return true si le caractere etait bien present dans la liste, false sinon
	 */
	public boolean supprimerPremiereOccurrence(char caractereASupprimer){

		if(tete==null)
			return false;
		
		if(tete.caractere==caractereASupprimer){
			this.tete = this.tete.suivant;
			return true;
		}
		
		NoeudCaractere baladeur = this.tete;
		while(baladeur.suivant != null) {
			if(baladeur.suivant.caractere == caractereASupprimer){
				baladeur.suivant = baladeur.suivant.suivant;
				return true;
			}
			baladeur = baladeur.suivant;
		}
		
		return false;	
	}

	
	
	/**
	 * supprime le caractere autant de fois qu'il est present dans la liste
	 * @param caractereASupprimer
	 * @return le nombre de suppressions effectuees
	 */
	public int supprimerToutesLesOccurrences(char caractereASupprimer){
		// TODO //

		int count = 0;

		if(tete==null)
			return count;

		while (tete.caractere == caractereASupprimer) {

			if (this.tete.suivant == null) {
				this.tete = null;
				count ++;
				return count;
			}

			this.tete = this.tete.suivant;
			count ++;
		}

		NoeudCaractere baladeur = this.tete;

		while(baladeur.suivant != null) {
			if(baladeur.suivant.caractere == caractereASupprimer){
				baladeur.suivant = baladeur.suivant.suivant;
				count ++;
			} else {
				baladeur = baladeur.suivant;
			}
		}
		return count;
	}
	

	

	private class NoeudCaractere{
		private char caractere;
		private NoeudCaractere suivant;

		public NoeudCaractere(char caractere, NoeudCaractere suivant){
			this.caractere = caractere;
			this.suivant = suivant;
		}
	}
}
