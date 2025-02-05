import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Algorithme de tri : UnshuffleSort 

 * Cet algorithme de tri necessite l�utilisation d�une liste de deques.
 * Cet algorithme de tri comporte deux etapes. La premiere consiste a repartir 
 * les entiers a trier dans un nombre variable de deques. Lorsque tous
 * les entiers auront ete repartis, la deuxieme etape se chargera de remplir la
 * table a renvoyer.
 * 
 * Les 2 etapes sont basees sur le principe suivant : La liste des deques devra
 * toujours etre triee en utilisant le premier entier de chaque deque comme clef de tri.
 * Les deques aussi sont tries.
 * 
 * 
 */
public class UnshuffleSort {
	
	private LinkedList<ArrayDeque<Integer>>  listeDeDeques;

	public UnshuffleSort() {
		this.listeDeDeques = new LinkedList<ArrayDeque<Integer>>();
	}

	/**
	 * tri de la table d'entiers re�ue en parametre
	 * 
	 * @param tableATrier la table a trier
	 * @return table contenant les entiers tries
	 */
	public int[] trier(int[] tableATrier) {
		remplirDeques(tableATrier);
		return viderDeques(tableATrier.length);
	}

	/**
	 * 1ere etape du tri : repartition des entiers dans des deques
	 * @param tableATrier la table a trier
	 */
	private void remplirDeques(int[]tableATrier) {
		// TODO
		// Pour le debug:
		System.out.println("etape1");
		// pour plus de lisibilite cette methode pourrait appeler la methode suivante :

		for (int i = 0; i < tableATrier.length ; i++) {
			this.placerEntier(tableATrier[i]);
		}
	}

	public void placerEntier(int entier) {
		// TODO
		// methode private --> public car verifiee par la classe TestEtape1UnshuffleSort
		// Pour le debug:
		System.out.println(listeDeDeques);

		boolean dejaPlacer = false;

		for (ArrayDeque<Integer> dequeDansLaListe : listeDeDeques) {
			if (entier > dequeDansLaListe.getLast()) {
				dequeDansLaListe.add(entier);
				dejaPlacer = true;
				return;
			}
			if (entier < dequeDansLaListe.getFirst()) {
				dequeDansLaListe.addFirst(entier);
				dejaPlacer = true;
				return;
			}
		}

		//if (!dejaPlacer) {
			ArrayDeque nouveauDeque = new ArrayDeque<>();
			nouveauDeque.add(entier);
			listeDeDeques.add(nouveauDeque);
		//}
	}
	

	/**
	 * 2eme etape du tri : on vide les deques
	 * 
	 * @param taille nombre d'entiers de la table a trier
	 * @return table contenant les entiers tries
	 */
	private int[] viderDeques(int taille) {
		
		// Pour le debug:
		System.out.println("etape2");

		// TODO
		// triage

		for (int i = 0; i < taille; i++) {

		}

		while (!listeDeDeques.get(0).isEmpty()) {
			supprimerPlusPetitEntier();
		}

		// pour plus de lisibilite cette methode pourrait appeler les methodes suivantes :
	return null;
	}
	
	private int supprimerPlusPetitEntier(){

		//if (listeDeDeques.getFirst() )
		// supprime et renvoie l'entier supprime

		return 0;
	}
	
	private void reorganiserListe(){

		// Pour le debug:
		System.out.println(listeDeDeques);

		// pour plus de lisibilite cette methode pourrait appeler la methode suivante :

	}
		
	private void deplacerPremierDeque() {

	}

	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	public String toString(){
		return listeDeDeques.toString();
	}

}
