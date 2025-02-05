import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class DicoSD {
	
	//TODO /
	// suivez l'implementation proposee dans l'enonce!

	HashMap<String, LinkedList<String>>mapDicoSD;
	// Au depart le dico est vide
	public DicoSD() {
		//TODO /

		mapDicoSD = new HashMap<>();
	}

	/**
	 * ajout dans le dico une association sd-url si cette association n'est pas encore presente 
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si cette association n'etait pas encore presente dans le dico, false sinon
	 */
	public boolean ajouter(String sd, String url){
			//TODO /

		if (!mapDicoSD.containsKey(sd)) {
			LinkedList<String> listeUrl = new LinkedList<String>();
			listeUrl.add(url);
			mapDicoSD.put(sd, listeUrl);
			return true;
		}
		else{
			LinkedList<String> valueListe = mapDicoSD.get(sd);
			if (!valueListe.contains(url)) {
				valueListe.add(url);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * verifie si la structure de donnees se trouve dans le dico
	 * cette structure de donnees doit posseder au moins une url!
	 * @param sd
	 * @return true si sd est present, false sinon
	 */
	public boolean contient(String sd){
		//TODO /

		if (!mapDicoSD.containsKey(sd)) {
			return false;
        }
		return mapDicoSD.get(sd) != null;
	}

	/**
	 * renvoie tous les urls associes a la structure de donnees passee en parametre
	 * @param sd
	 * @return une chaine de caracteres avec les urls selon le format : [urlPile1, urlPile2] ou [] si la structure de donnees n'existe pas
	 */
	public String lesURLs(String sd){
		//TODO


		// LINKEDLIST.TOSTRING
		return null;
	}
	
	/**
	 * supprime dans le dico l'association sd-url si celle-ci est presente 
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si l'association etait presente dans le dico, false sinon
	 */
	public boolean supprimer(String sd, String url){
		return false;
		//TODO
	}
		
}
