import java.util.Iterator;


public interface Deque<E>{
	
	/**
	 * verifie si le deque est vide
	 * @return true si le deque est vide, false sinon
	 */
	public boolean estVide();

	
	/**
	 * renvoie le nombre d'elements qui se trouvent dans le deque
	 * @return nombre d'elements
	 */
	public int taille();
	
	
	/**
	 * ajoute un element au debut du deque
	 * @param element l'element a ajouter
	 */	
	public void ajouterEnPremier(E element);


	/**
	 * ajoute un element a la fin du deque
	 * @param element l'element a ajouter
	 */	
	public void ajouterEnDernier(E element);


	/**
	 * renvoie l'element qui se trouve au debut du deque sans l'enlever
	 * @return le premier element
	 * @throws DequeVideException si le deque est vide
	 */	
	public E premier() throws DequeVideException;


	/**
	 * renvoie l'element qui se trouve a la fin du deque sans l'enlever
	 * @return le dernier element
	 * @throws DequeVideException si le deque est vide
	 */
	public E dernier() throws DequeVideException;


	/**
	 * renvoie l'element qui se trouve au debut du deque et l'enleve
	 * @return l'element supprime
	 * @throws DequeVideException si le deque est vide
	 */	
	public E supprimerPremier() throws DequeVideException;


	/**
	 * renvoie l'element qui se trouve a la fin du deque et l'enleve
	 * @return l'element supprime
	 * @throws DequeVideException si le deque est vide
	 */
	public E supprimerDernier() throws DequeVideException;

	/**
	 * l'iterateur va permettre de parcourir de tous les elements du deque en commen�ant par le premier
	 * @return un objet de la classe Iterator
	 */
	public Iterator<E> iterator();
}
