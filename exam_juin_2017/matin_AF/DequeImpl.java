import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class DequeImpl<E> implements Deque<E>{

	private Object[] table;
	private int indicePremier; 
	private int indiceDernier;
	private int taille;
	private int numVersion = 0; // pour l'iterateur

	public DequeImpl(){
		table = new Object[5];
		indicePremier = -1;
		indiceDernier = -1;
		taille = 0;
	}

	// Va servir pour les tests 
	// A ne pas modifier!!!
	public DequeImpl(Object[] tableARecopier){
		if(tableARecopier==null)
			throw new IllegalArgumentException();
		table = new Object[tableARecopier.length+4];
		for (int i = 0; i < tableARecopier.length; i++) {
			table[i+2]=tableARecopier[i];
		}
		indicePremier = 2;
		indiceDernier = indicePremier+tableARecopier.length-1;
		taille = tableARecopier.length;
	}

	// Va servir pour les tests 
	// A ne pas modifier!!!
	public String toString(){
		String aRenvoyer = "";
		for (int i = indicePremier; i <= indiceDernier; i++) {
			aRenvoyer += " "+table[i];
		}
		return aRenvoyer;
	}


	public boolean estVide() {
		return taille==0;
	}

	public int taille() {
		return taille;
	}

	private void agrandirTable() {
		// TODO
	}

	
	public void ajouterEnPremier(E element) {
		numVersion++;
		// TODO Auto-generated method stub
	}


	@Override
	public void ajouterEnDernier(E element) {
		numVersion++;
		// TODO Auto-generated method stub		
	}

	@Override
	public E premier() throws DequeVideException {
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public E dernier() throws DequeVideException {
		return null;
		// TODO Auto-generated method stub	
	}

	@Override
	public E supprimerPremier() throws DequeVideException {
		numVersion++;
		return null;
		// TODO Auto-generated method stub
	}

	@Override
	public E supprimerDernier() throws DequeVideException {
		numVersion++;
		return null;		
		// TODO Auto-generated method stub
	}

	@Override
	public Iterator<E> iterator() {
		return new IterateurImpl<E>();
	}

	private class IterateurImpl<E> implements Iterator<E>{

		private int indiceCourant;
		private int version;

		private IterateurImpl() {
			indiceCourant = indicePremier;
			version = numVersion;
		}

		@Override
		public boolean hasNext() {
			return false;
			// TODO
		}

		@Override
		public E next() {
			return null;
			// TODO
		}

		@Override
		// A NE PAS COMPLETER : Les suppressions sont interdites
		public void remove() {
			throw new UnsupportedOperationException();			
		}

	}
}
