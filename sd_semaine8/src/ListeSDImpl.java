import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListeSDImpl<E> implements ListeSD<E>,Iterable<E> {

	private Noeud tete, queue;
	private HashMap<E, Noeud> mapElementNoeud;

	public ListeSDImpl () {
		//TODO /

		tete = new Noeud();
		queue = new Noeud();

		tete.suivant = queue;
		queue.precedent = tete;

		mapElementNoeud = new HashMap<>();

	}

	public int taille () {
		return mapElementNoeud.size();
	}

	public boolean estVide () {
		//TODO /

		return (mapElementNoeud.isEmpty());

	}

	public boolean contient (E element) {
		//TODO /

		return mapElementNoeud.containsKey(element);

	}

	public E premier() {
		//TODO /
		return tete.suivant.element;

	}

	public E dernier() {
		//TODO /
		return queue.precedent.element;

	}

	public E donnerPrecedent (E element) {
		//TODO /

		Noeud noeudTemp = mapElementNoeud.get(element);

		if (noeudTemp == null)
			return null;

		return mapElementNoeud.get(element).precedent.element;

	}

	public E donnerSuivant (E element) {
		//TODO /

		Noeud noeudTemp = mapElementNoeud.get(element);

		if (noeudTemp == null)
			return null;

		return mapElementNoeud.get(element).suivant.element;

	}

	public boolean insererEnTete (E element){
		//TODO /

		if (mapElementNoeud.containsKey(element))
			return false;

		Noeud noeudTemp = new Noeud(element);

		noeudTemp.suivant = tete.suivant;
		noeudTemp.precedent = tete;

		tete.suivant.precedent = noeudTemp;
		tete.suivant = noeudTemp;

		mapElementNoeud.put(element, noeudTemp);

		return true;

	}

	public boolean insererEnQueue (E element) {
		//TODO /

		if (mapElementNoeud.containsKey(element))
			return false;

		Noeud noeudTemp = new Noeud(element);

		noeudTemp.precedent = queue.precedent;
		noeudTemp.suivant = queue;

		queue.precedent.suivant = noeudTemp;
		queue.precedent = noeudTemp;

		mapElementNoeud.put(element, noeudTemp);

		return true;

	}

	public boolean insererApres (E element, E elementAInserer) {
		//TODO /

		if (!mapElementNoeud.containsKey(element))
			return false;

		if (mapElementNoeud.containsKey(elementAInserer))
			return false;

		Noeud noeudTemp = new Noeud(elementAInserer);

		Noeud noeudAvant = mapElementNoeud.get(element);
		Noeud noeudApres = noeudAvant.suivant;

		noeudTemp.precedent = noeudAvant;
		noeudTemp.suivant = noeudApres;

		noeudAvant.suivant = noeudTemp;
		noeudApres.precedent = noeudTemp;

		mapElementNoeud.put(elementAInserer, noeudTemp);

		return true;

	}

	public boolean insererAvant (E element, E elementAInserer) {
		//TODO /

		if (!mapElementNoeud.containsKey(element))
			return false;

		if (mapElementNoeud.containsKey(elementAInserer))
			return false;

		Noeud noeudTemp = new Noeud(elementAInserer);

		Noeud noeudApres = mapElementNoeud.get(element);
		Noeud noeudAvant = noeudApres.precedent;

		noeudTemp.precedent = noeudAvant;
		noeudTemp.suivant = noeudApres;

		noeudAvant.suivant = noeudTemp;
		noeudApres.precedent = noeudTemp;

		mapElementNoeud.put(elementAInserer, noeudTemp);

		return true;

	}


	public boolean supprimer (E element) {
		//TODO /

		if (!mapElementNoeud.containsKey(element))
			return false;

		Noeud noeudTemp = mapElementNoeud.get(element);
		Noeud noeudAvant = noeudTemp.precedent;
		Noeud noeudApres = noeudTemp.suivant;

		noeudAvant.suivant = noeudApres;
		noeudApres.precedent = noeudAvant;

		mapElementNoeud.remove(element);

		return true;

	}

	
	public boolean permuter (E element1, E element2) {
		//TODO /

		if (!mapElementNoeud.containsKey(element1) || !mapElementNoeud.containsKey(element2))
			return false;

		Noeud noeudTemp1 = mapElementNoeud.get(element1);
		Noeud noeudTemp2 = mapElementNoeud.get(element2);

		// REMARQUE : CE SONT LES VALEURS QUI SONT PERMUTEES, PAS LES NOEUDS!!!
        noeudTemp1.element = element2;
		noeudTemp2.element = element1;

		// N'oubliez pas de modifier les noeuds associes dans le map
		mapElementNoeud.replace(element1, noeudTemp1, noeudTemp2);
		mapElementNoeud.replace(element2, noeudTemp2, noeudTemp1);

		return true;

	}

	public Iterator<E> iterator() {
		//TODO



		return new IterateurImpl();
		// il faut renvoyer un objet de type Iterator :
		//return new IterateurImpl();
		// completez la classe interne IterateurImpl !
	}

	public String toString () {
		String aRenvoyer = "";
		int num = 1;
		Noeud baladeur = tete.suivant;
		while (baladeur != queue) {
			aRenvoyer += num + " - " + baladeur.element + "\n";
			baladeur = baladeur.suivant;
			num++;
		}
		return aRenvoyer;   
	}



	// Classe interne Noeud
	private class Noeud{
		private E element;
		private Noeud suivant;
		private Noeud precedent;

		private Noeud() {
			this(null, null, null);
		}

		private Noeud(E element) {
			this(null, element, null);
		}

		private Noeud(Noeud precedent, E element, Noeud suivant) {
			this.element = element;
			this.suivant = suivant;
			this.precedent = precedent;
		}
	}

	

	// Classe interne IterateurImpl
	private class IterateurImpl implements Iterator{

		private Noeud noeudCourant;

		private IterateurImpl() {
			//TODO
			noeudCourant = tete.suivant;
		}

		public boolean hasNext() {
			//TODO

			return noeudCourant!=queue;

		}

		// renvoie l element qui se trouve dans le noeud courant
		// le noeud courant passe au noeud suivant
		public E next() {
			//TODO /

			Noeud noeudTemp = this.noeudCourant;
			this.noeudCourant = this.noeudCourant.suivant;

			return noeudTemp.element;

		}

		// A NE PAS COMPLETER : Les suppressions sont interdites
		public void remove() {
			throw new UnsupportedOperationException();			
		}
	}

	// pour les tests
	public ListeSDImpl(E[] tableACopier) {
		mapElementNoeud = new HashMap<E, Noeud>();
		tete = new Noeud();   // sentinelle de tete
		queue = new Noeud();  // sentinelle de queue
		Noeud prec = tete;
		for (int i = 0; i < tableACopier.length; i++) {
			Noeud nouveauNoeud = new Noeud(tableACopier[i]);
			mapElementNoeud.put(tableACopier[i], nouveauNoeud);
			nouveauNoeud.precedent = prec;
			prec.suivant = nouveauNoeud;
			prec = nouveauNoeud;
		}
		prec.suivant = queue;
		queue.precedent = prec;
	}

	// pour les tests
	public String teteQueue(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = tete.suivant;
			int cpt=0;
			while (baladeur != queue) {
				if(cpt==0)
					aRenvoyer += baladeur.element;
				else
					aRenvoyer += ","+baladeur.element;
				baladeur = baladeur.suivant;
				cpt++;
				if(cpt==100){
					return "boucle infinie";
				}
			}
			return aRenvoyer+")";
		}catch (NullPointerException e){
			return "nullPointerException";
		}
	}

	// pour les tests
	public String queueTete(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = queue.precedent;
			int cpt=0;
			while (baladeur != tete) {
				if(cpt==0)
					aRenvoyer += baladeur.element;
				else
					aRenvoyer += ","+baladeur.element;
				baladeur = baladeur.precedent;
				cpt++;
				if(cpt==100){
					return "boucle infinie";
				}
			}
			return aRenvoyer+")";
		}catch (NullPointerException e){
			return "nullPointerException";
		}
	}

}
