import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class EquipeGuerriers {

	private ArrayList<Guerrier> vecteurGuerriers;
	private LinkedList<Guerrier> listeGuerriersEnJeu;
	private int pointsDeVieDeDepart;

	/**
	 * construit l'equipe 
	 * @param nombreGuerriers nombre de guerriers en vie au debut du jeu
	 * @param pointsDeVieDeDepart nombre de points de vie attribue a chaque guerrier au debut du jeu
	 * @throws IllegalArgumentException il faut au moins 1 guerrier vivant pour combattre la creature du mal
	 */
	public EquipeGuerriers(int nombreGuerriers, int pointsDeVieDeDepart){
		// TODO //

		this.pointsDeVieDeDepart = pointsDeVieDeDepart;

		if (nombreGuerriers < 1)
			throw new IllegalArgumentException();

		vecteurGuerriers = new ArrayList<>(nombreGuerriers);
		listeGuerriersEnJeu = new LinkedList<>();

		for (int i = 0; i < nombreGuerriers; i++) {

			Guerrier guerrierTemp = new Guerrier(i + 1, pointsDeVieDeDepart);
			vecteurGuerriers.add(guerrierTemp);
			listeGuerriersEnJeu.add(guerrierTemp);
		}
	} 

	/**
	 * renvoie le nombre de guerriers encore en vie
	 * @return le nombre de guerriers encore en vie
	 */
	public int nombreGuerriersEnVie(){
		// TODO //

		return listeGuerriersEnJeu.size();

	}
	
	/**
	 * selectionne un guerrier, lui diminue son nombre de points de vie et le remet en jeu s'il n'est pas mort
	 * @param pointsDeViePerdus le nombre perdu par le guerrier au combat
	 * @return le guerrier qui a combattu
	 * @throws NoSuchElementException si tous les guerriers sont morts
	 * @throws IllegalArgumentException le nombre de points de vie perdus est un nombre <= 0
	 */
	public Guerrier jouer(int pointsDeViePerdus){
		// TODO //

		if (nombreGuerriersEnVie() == 0)
			throw new NoSuchElementException();

		if (pointsDeViePerdus <= 0)
			throw new IllegalArgumentException();

		Guerrier guerrierTemp = listeGuerriersEnJeu.remove();

		guerrierTemp.setPointsDeVie(Math.max(guerrierTemp.getPointsDeVie() - pointsDeViePerdus, 0));
		if (guerrierTemp.getPointsDeVie() > 0)
			listeGuerriersEnJeu.add(guerrierTemp);
		
		return guerrierTemp;
	}
	
	/**
	 * renvoie le guerrier dont le numero est passe en parametre, meme s'il est mort
	 * @param numero le numero du guerrier demande
	 * @return le guerrier qui a comme numero le numero passe en parametre
	 * @throws IllegalArgumentException le numero n'a pas ete attribue
	 */
	public Guerrier getGuerrier(int numero){
		// TODO //

		if (numero > vecteurGuerriers.size() || numero < 1)
			throw new IllegalArgumentException();

		return vecteurGuerriers.get(numero - 1);

	}
	
	
	/**
	 * ajoute un nouveau guerrier dans l'equipe
	 * ce guerrier recoit un numero non attribue et le nombre de points de vie de depart
	 * ce guerrier va prendre place au combat en se placant apres le guerrier vivant qui porte le numero juste plus petit que lui
	 * Par exemple : g4 est mort et ordre des combats : g3 g1 g2 , le nouveau guerrier va se placer entre g3 et g1
	 * @return le numero du guerrier ajoute
	 */
	public int ajouterNouveauGuerrier() {
		// TODO //

		Guerrier nouveauGuerrierTemp = new Guerrier(vecteurGuerriers.size() + 1, pointsDeVieDeDepart);
		vecteurGuerriers.add(nouveauGuerrierTemp);

		int numTemp = -1;
		int indexDansLaListe = -1;
		int indexDuPlusGrandNum = -1;

		for (Guerrier guerrierEnJeu : listeGuerriersEnJeu) {
			indexDansLaListe++;

			int numGuerrier = guerrierEnJeu.getNumero();

			if (numGuerrier > numTemp) {
				numTemp = numGuerrier;
				indexDuPlusGrandNum = indexDansLaListe;
			}
		}

		listeGuerriersEnJeu.add(indexDuPlusGrandNum + 1, nouveauGuerrierTemp);
		return nouveauGuerrierTemp.getNumero();
	}
	
	// Attention : seul interet de ce toString() : les tests!!!
	// A NE PAS MODIFIER
	public String toString(){
		return "vecteur :\n"+vecteurGuerriers.toString()+"\nliste :\n"+listeGuerriersEnJeu.toString();
	}

	// Attention : seul interet de ce constructeur : les tests!!!
	// A NE PAS MODIFIER
	public EquipeGuerriers(ArrayList<Guerrier> vecteurGuerriers,
						   LinkedList<Guerrier> listeGuerriersEnJeu, int pointsDeVieDeDepart) {
		super();
		this.vecteurGuerriers = vecteurGuerriers;
		this.listeGuerriersEnJeu = listeGuerriersEnJeu;
		this.pointsDeVieDeDepart = pointsDeVieDeDepart;
	}
	
	
}
