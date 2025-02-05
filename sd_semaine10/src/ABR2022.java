import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ABR2022 implements Iterable<Integer> {

	private NoeudEntier racine;

	public ABR2022() {
		racine = null;
	}

	public boolean estVide() {
		return racine == null;
	}


	public int nombreNegatifsVI() {
		//TODO
		//CONTRAINTE : cette methode doit etre iterative
		if (racine == null) {
			return 0;
		}

		int count = 0;

        for (Integer entier : this) {
            if (entier < 0) {
                count++;
            }
        }

		return count;
	}

	public int nombreNegatifsVR(){
		//TODO
		//CONTRAINTE : cette methode doit etre recursive
		return nombreNegatifsVR(racine);
	}

	private int nombreNegatifsVR(NoeudEntier n){

		if (n == null)
			return 0;

		if (n.entier >= 0)
			return nombreNegatifsVR(n.gauche); // WARNING FEU ORANGE

		return 1 + nombreNegatifsVR(n.gauche) + nombreNegatifsVR(n.droit);

	}

	public boolean tousPositifsVI() {
		//TODO
		//CONTRAINTE : cette methode doit etre iterative
		//N'utilisez pas une methode nombrePositifs()!

		if (racine == null) {
			return true;
		}

		Iterator<Integer> it = iterator();

		Integer entier = it.next();

		return (entier > 0);

	}


	public boolean tousPositifsVR() {
		//TODO
		//CONTRAINTE : cette methode doit etre recursive
		//N'utilisez pas une methode nombrePositifs()!
		return tousPositifsVR(racine);
	}

	private boolean tousPositifsVR(NoeudEntier n) {

		if (n == null)
			return true;


		if (n.entier <= 0)
			return false;

		return tousPositifsVR(n.gauche);
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterateur();
	}

	private class Iterateur implements Iterator<Integer> {
		private ArrayDeque<Integer> fileDEntiers;

		public Iterateur () {
			fileDEntiers = new ArrayDeque<Integer>();
			remplirFile(racine);
		}

		private void remplirFile (NoeudEntier n) {
			if (n == null) return;
			remplirFile(n.gauche);
			fileDEntiers.addLast(n.entier);
			remplirFile(n.droit);
		}

		public boolean hasNext () {
			return !fileDEntiers.isEmpty();
		}

		public Integer next () {
			if(!hasNext())
				throw new NoSuchElementException();
			return fileDEntiers.removeFirst();
		}
	}

	public class NoeudEntier {

		private int entier;
		private NoeudEntier gauche;
		private NoeudEntier droit;

		private NoeudEntier (int entier) {
			this.entier = entier;
			this.gauche = null;
			this.droit = null;
		}

		private NoeudEntier (NoeudEntier g, int entier, NoeudEntier d) {
			this.entier = entier;
			this.gauche = g;
			this.droit = d;
		}
	}

	// pour les tests

	public ABR2022 (int entier) {
		this.racine = new NoeudEntier(entier) ;
	}

	// pour les tests - attention ne verifie pas si tri ABR respecte!
	public ABR2022 (ABR2022 filsGauche, int entier, ABR2022 filsDroit) {
		this.racine = new NoeudEntier(filsGauche.racine, entier, filsDroit.racine);

	}
}
