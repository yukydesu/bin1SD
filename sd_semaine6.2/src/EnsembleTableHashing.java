import java.util.ArrayDeque;

/**
 * implementation de l'interface Ensemble via une table de listes
 * @author 
 *
 */

public class EnsembleTableHashing<E> implements Ensemble<E>{
	
	private ListeSimpleImpl<E>[] tableListes;
	private int taille;
	private double loadFactor;  //pour le defi 

	// taille : taille logique 
	// capacite : taille physique 
	public EnsembleTableHashing(int capacite){	
		// TODO /

		tableListes = new ListeSimpleImpl[capacite];
		taille = 0;
		loadFactor = 0.75;

		for (int i = 0; i < capacite; i++) {
			tableListes[i] = new ListeSimpleImpl<>();
		}

	}
	
	// taille : taille logique 
	// capacite : taille physique 
	public EnsembleTableHashing(int capacite, double loadFactor){	
		// pour le  defi
		this(capacite);
		this.loadFactor = loadFactor;
	}

	public boolean estVide(){
		return taille == 0;
	}

	
	public int taille(){
		return taille;
	}

	
	public boolean contient(E element){
		// TODO /
		// Attention la methode hashCode() renvoie un entier quelconque
		// Il n'est donc pas necessairement compris entre 0 et taille physique de la table
		// Il pourrait meme etre negatif
		// solution pbm compris entre 0 et taille physique : % taille physique
		// solution pbm negatif : Math.abs()

		if (element !=null) {

		int hashTemp = (Math.abs(element.hashCode())) % tableListes.length;
		return tableListes[hashTemp].contient(element);
		}

		return false;
	}

	
	public boolean ajouter(E element) {
		// TODO /
		if (contient(element))
			return false;

		int hashTemp = Math.abs(element.hashCode()) % tableListes.length;

		tableListes[hashTemp].insererEnTete(element);
		taille ++;

		return true;

	}


	public boolean enlever(E element) {
		// TODO /

		if (!contient(element))
			return false;

		int hashTemp = Math.abs(element.hashCode()) % tableListes.length;

		tableListes[hashTemp].supprimer(element);
		taille --;

		return true;
	}
	
	
	public String toString(){
	
		// Pour le debug cette methode renvoie le contenu de la structure de donnees utilisee
		// on y voit apparaitre une table avec les differentes listes, meme celles qui sont vides!
		// la methode proposee est utilisee par la classe de tests pour le defi

		// Cette methode devrait renvoyer uniquement les donnees comprises dans l'ensemble
		// Ex supplementaire 
		
		
		String aRenvoyer="";
		for (int i = 0; i < tableListes.length; i++) {
			aRenvoyer += "\ntable"+i+tableListes[i];
		}
		return aRenvoyer;
	}



}

