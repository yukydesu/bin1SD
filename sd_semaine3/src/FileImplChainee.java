public class FileImplChainee<E> implements File<E>{

	private Noeud tete;
	private Noeud queue;
	private int taille;

	public FileImplChainee(){
		tete=null;
		queue=null;
		taille=0;
	}

	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	// tete 'a' 'b' 'c' queue : ['a','b','c']
	public FileImplChainee(Object[] table) {
		if(table == null)
			throw new IllegalArgumentException();
		this.taille = table.length;

		if(taille==0)
			return;
		queue = new Noeud((E)table[table.length-1],null);
		Noeud noeud = queue;
		for (int i = table.length-2; i>=0;i--) {
			noeud = new Noeud((E)table[i],noeud);
		}
		this.tete=noeud;
	}

	// A ne pas modifier ! Methode utilisee pour les tests
	public String toString(){
		String aRenvoyer="";
		Noeud baladeur=tete;
		int cpt = 0;
		while(baladeur!=null) {
			cpt++;
			if(cpt>taille){
				return "boucle infinie dans toString(), chainage a verifier";
			}
			aRenvoyer+=" "+baladeur.element;
			baladeur=baladeur.suivant;
		}
		return aRenvoyer;
	}


	public boolean estVide(){
		return taille==0;
	}


	public int taille(){
		return taille;
	}

	
	public void enfile(E element){
		//TODO//

		Noeud noeudTemp = new Noeud(element);

		if (taille == 0) {
			tete = noeudTemp;
			queue = noeudTemp;
			taille ++;
		}

		queue.suivant = noeudTemp;
		queue = noeudTemp;
		taille ++;
	}

	
	public E defile() throws FileVideException{
		//TODO//

		if (taille == 0)
			throw new FileVideException();

		Noeud noeudTemp = tete;

		tete = tete.suivant;
		taille --;

		return noeudTemp.element;
	}

	public E premier()throws FileVideException{
		//TODO//

		if (taille == 0)
			throw new FileVideException();

		return tete.element;
	}

	// classe interne
	private class Noeud{
		private E element;
		private Noeud suivant;

		private Noeud(E element, Noeud suivant){
			this.element = element;
			this.suivant = suivant;
		}
		
		private Noeud(E element){
			this.element = element;
			this.suivant = null;
		}

	}

} 



