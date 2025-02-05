import com.sun.jdi.connect.spi.TransportService;

import java.nio.channels.NoConnectionPendingException;
import java.util.*;

public class ListeRecCaracteres {

	private NoeudCaractere tete;
	// N'ajoutez pas d'autres attributs
	
	public ListeRecCaracteres() {
		this.tete=null;
	}
	

	
	/**
	 * verifie la presence du caractere passe en parametre dans la liste
	 * @param caractereRecherche
	 * @return true si le caractere est present dans la liste, false sinon
	 */
	public boolean contient(char caractereRecherche){
		//TODO //

		if (caractereRecherche == ' ')
			throw new NoSuchElementException();

		return contient(tete, caractereRecherche);
	}

	private boolean contient(NoeudCaractere noeud, char caractereRecherche) {

		if (noeud == null)
			return false;

		if (noeud.caractere == caractereRecherche)
			return true;

		return contient(noeud.suivant, caractereRecherche);
	}
	
	/**
	 * calcule le nombre de fois qu'apparait le caractere passe en parametre dans la liste
	 * @param caractereRecherche
	 * @return le nombre d'occurrences du caractere
	 */
	public int nombreOccurrences(char caractereRecherche){
		//TODO //

		if (caractereRecherche == ' ')
			throw new NoSuchElementException();

		return nombreOccurrences(tete, caractereRecherche);
	}

	private int nombreOccurrences(NoeudCaractere noeud, char caractereRecherche) {

		if (noeud == null)
			return 0;
		int nbr = nombreOccurrences(noeud.suivant, caractereRecherche);
		if (noeud.caractere == caractereRecherche)
			nbr += 1;
		return nbr;
	}

	
	/**
	 * remplace la 1ere occurrences du caractere a remplacer par un nouveau caractere
	 * @param caractereARemplacer le caractere a remplacer
	 * @param nouveauCaractere le nouveau caractere
	 */
	public void remplacer(char caractereARemplacer, char nouveauCaractere){
		//TODO //

		if (caractereARemplacer == ' ' || nouveauCaractere == ' ')
			throw new NoSuchElementException();

		this.remplacer(tete, caractereARemplacer, nouveauCaractere);
	}

	private void remplacer(NoeudCaractere noeud, char caractereARemplacer, char nouveauCaractere) {
		if (noeud == null) {

		}else if (noeud.caractere == caractereARemplacer) {
			noeud.caractere = nouveauCaractere;
		} else {
			remplacer(noeud.suivant, caractereARemplacer, nouveauCaractere);
		}
	}
	
	/**
	 * remplace toutes les occurrences du caractere a remplacer par un nouveau caractere
	 * @param caractereARemplacer le caractere a remplacer
	 * @param nouveauCaractere le nouveau caractere
	 */
	public void remplacerTout(char caractereARemplacer, char nouveauCaractere){
		//TODO //

		if (caractereARemplacer == ' ' || nouveauCaractere == ' ')
			throw new NoSuchElementException();

		this.remplacerTout(tete, caractereARemplacer, nouveauCaractere);

	}

	private void remplacerTout(NoeudCaractere noeud, char caractereARemplacer, char nouveauChar) {

		if (noeud == null) {

		}else if (noeud.caractere == caractereARemplacer) {
			noeud.caractere = nouveauChar;
			remplacerTout(noeud.suivant, caractereARemplacer, nouveauChar);
		} else {
			remplacerTout(noeud.suivant, caractereARemplacer, nouveauChar);
		}
	}

	
	/**
	 * recherche le plus grand caractere de la liste ('a'<'b'< ...)
	 * @return le plus grand caractere 
	 * @throws NoSuchElementException si la liste est vide
	 */
	public char max() {
		//TODO //

		if (tete == null)
			throw new NoSuchElementException();

		return max(tete);

		// c'est cette methode qui leve une exception en cas de liste vide!
		// suggestion : la methode recursive (private!) pourrait renvoyer ' ' si le noeud passe en parametre est null
	}

	private char max(NoeudCaractere noeud) {

		if (noeud == null)
			return ' ';

		if (noeud.caractere > max(noeud.suivant))
			return noeud.caractere;

		return max(noeud.suivant);
	}
	
	
	
	/**
	 * cree une arrayList contenant les caracteres de la liste 
	 * L'ordre doit etre respecte (une liste est une structure lineaire)
	 * @return l'arrayList cree
	 */
	public ArrayList<Character> enArrayList(){
		// TODO //

		ArrayList<Character> listeRenvoye = new ArrayList<>();

		return enArrayList(tete, listeRenvoye);

		// cette methode s'occupe de creer (1x!) l'arraylist et la passe en parametre de la methode recursive
		// l'arrayList est un objet --> passage de parametre par adresse 
		// La methode recursive est une methode void!
		
	}

	private ArrayList<Character> enArrayList(NoeudCaractere noeud, ArrayList<Character> array){

		if (noeud == null)
			return array;

		array.add(noeud.caractere);
		enArrayList(noeud.suivant, array);

		return array;
	}

	/**
	 * verifie si les 2 listes contiennent les memes caracteres et ceci dans le meme ordre
	 * Une liste est une structure LINEAIRE!
	 * @param l la liste a comparer a la liste courante
	 * @return true si les 2 listes sont les memes, false sinon
	 */
	public boolean estEgalA(ListeRecCaracteres l){
		// TODO //

		return estEgalABis(this.tete, l.tete);

	}
	
	private boolean estEgalABis(NoeudCaractere noeud1, NoeudCaractere noeud2){

		if (noeud1 == null && noeud2 == null)
			return true;

		// pas besin du OR EXCL '^' ici car la condition de 2null est deja vérifié juste au dessus
		if (noeud1 == null || noeud2 == null)
			return false;

		if (noeud1.caractere != noeud2.caractere)
			return false;

		return estEgalABis(noeud1.suivant, noeud2.suivant);

	}
	

	/**
	 * supprime une fois le caractere passe en parametre
	 * si le caractere se trouve plusieurs fois, c est sa premiere occurrence qui sera supprimee
	 * @param caractereASupprimer
	 * @return true si le caractere etait bien present dans la liste, false sinon
	 */
	
	// VERSION 1
	
	public boolean supprimerPremiereOccurrence(char caractereASupprimer){
		if(!contient(caractereASupprimer))
			return false;
		tete = supprimerPremiereOccurrence(tete,caractereASupprimer);
		return true;		
	}
	
	private NoeudCaractere supprimerPremiereOccurrence(NoeudCaractere noeud, char caractereASupprimer) {
		if(noeud==null)
			return null;
		if(noeud.caractere==caractereASupprimer)
			return noeud.suivant;
		noeud.suivant=supprimerPremiereOccurrence(noeud.suivant, caractereASupprimer);
		return noeud;
	}
	
	// VERSION 2
	
//	public boolean supprimerPremiereOccurrence(char caractereASupprimer) {
//		if(tete == null)
//			return false;
//		if(tete.caractere==caractereASupprimer){
//			tete = tete.suivant;
//			return true;
//		}
//			
//		return this.supprimerPremiereOccurrence(tete, caractereASupprimer) ;
//	}
//	
//	private boolean supprimerPremiereOccurrence(NoeudCaractere noeud, char caractereASupprimer) {
//		if (noeud.suivant == null)
//			return false ;
//		if (noeud.suivant.caractere == caractereASupprimer) {
//			noeud.suivant = noeud.suivant.suivant ;
//			return true ;
//		}
//		return supprimerPremiereOccurrence(noeud.suivant, caractereASupprimer);
//	}
	
	
	

	/**
	 * cree une liste qui est une copie de la liste courante (meme ordre)
	 * @return une copie de la liste courante
	 */
	public ListeRecCaracteres clone(){
		// TODO //
		// DEFI!
		ListeRecCaracteres listeClone = new ListeRecCaracteres();
		if (tete == null)
			return listeClone;
		NoeudCaractere noeudTemp = new NoeudCaractere(tete.caractere, null);
		listeClone.tete = noeudTemp;
		clone(tete.suivant, noeudTemp);
		return listeClone;
	}

	private void clone(NoeudCaractere noeud1, NoeudCaractere noeud2) {

		if (noeud1 != null) {

			noeud2.suivant = new NoeudCaractere(noeud1.caractere, null);
			clone(noeud1.suivant, noeud2.suivant);
		}
	}

	
	/**
	 * supprime le caractere autant de fois qu'il est present dans la liste
	 * @param caractereASupprimer
	 * @return le nombre de suppressions effectuees
	 */
	public int supprimerToutesLesOccurrences(char caractereASupprimer){
		
		return 0;
	
		// TODO
		
		// DEFI!
		
		// Lisez attentivement la version 1 ou la version 2 de la solution recursive de supprimerPremiereOccurrence
	}


	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public ListeRecCaracteres(char[] tableCaracteres) {
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

	private class NoeudCaractere{
		private char caractere;
		private NoeudCaractere suivant;

		public NoeudCaractere(char caractere, NoeudCaractere suivant){
			this.caractere = caractere;
			this.suivant = suivant;
		}

	}
}
