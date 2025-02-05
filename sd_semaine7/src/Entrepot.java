import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author 													-------> METTEZ ICI VOS NOM ET PRENOM
 *
 *
 */

public class Entrepot {

	//TODO /

	Hangar[] tableHangar;
	int nombreHangarsLibres;
	HashMap<Integer, Societe> mapSociete;


	/**
	 * construit un entrepot contenant nombreHangars
	 * @param nombreHangars le nombre d'hangars
	 * @throws IllegalArgumentException si le nombre d'hangars est negatif ou nul
	 */
	public Entrepot(int nombreHangars) {
		// TODO /

		if(nombreHangars<=0)
			throw new IllegalArgumentException();

		tableHangar = new Hangar[nombreHangars];
		nombreHangarsLibres = nombreHangars;

		for (int i = 0; i < nombreHangars; i++) {
			tableHangar[i] = new Hangar(i);
		}

		mapSociete = new HashMap<>();
	}

	/**
	 * renvoie le nombre d'hangars libres
	 * @return le nombre d'hangars libres
	 */
	public int nombreHangarsLibres(){
		//TODO /
		return nombreHangarsLibres;
	}


	/**
	 * renvoie le nombre de societes presentes
	 * @return le nombre de societes presentes
	 */
	public int nombreSocietesPresentes(){
		//TODO /
		return mapSociete.size();
	}

	/**
	 * renvoie la societe dont le numero est passe en parametre
	 * @param numeroSociete le numero de la societe
	 * @return la societe recherchee ou null si aucune societe presente ne possede ce numero
	 */
	public Societe getSociete(int numeroSociete){
		//TODO /

		return mapSociete.get(numeroSociete);

	}

	/**
	 * attribue un hangar a la societe passee en parametre
	 * Si l'attribution a pu se faire :
	 * la societe est enregistree comme presente (si pas encore presente)
	 * le hangar lui est ajoute
	 * @param numeroSociete le numero de la societe
	 * @param nomSociete le nom de la societe
	 * @return le numero du hangar attribue ou -1 s'il n'y en a plus de libre
	 */
	public int attribuerHangar(int numeroSociete, String nomSociete) {
		// TODO


		if (nombreHangarsLibres != 0) {

			Societe societeTemp = mapSociete.get(numeroSociete);

			if (societeTemp == null) {
				societeTemp = new Societe(numeroSociete, nomSociete);
				mapSociete.put(numeroSociete, societeTemp);
			}

			int numeroHangarTemp = numeroSociete % tableHangar.length;
			for (int i = numeroHangarTemp ; i < tableHangar.length; i++) {

				if (tableHangar[i].getSociete() == null) {
					societeTemp.ajouterHangar(i);
					tableHangar[i].setSociete(societeTemp);
					nombreHangarsLibres --;
					return i;
				}

				//if(i==tableHangar.length-1) i=0;
			}

			for (int i = 0 ; i < numeroHangarTemp; i++) {
				if (tableHangar[i].getSociete() == null) {
					societeTemp.ajouterHangar(i);
					tableHangar[i].setSociete(societeTemp);
					nombreHangarsLibres --;
					return i;
				}
			}
		}
		return -1;
	}
		// Pour une meilleure repartition des hangars occupes dans l'entrepot,
		// veuillez suivre les indications donnees dans l'enonce!

}
