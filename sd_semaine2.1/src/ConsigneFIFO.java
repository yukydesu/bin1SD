import java.util.ArrayList;


public class ConsigneFIFO {
	
	private ArrayList<Casier> casiersLibres;
	private Casier[] tousLesCasiers;

	/**
	 * construit une consigne de gare avec tous les casiers libres au depart
	 * @param nombreCasiers le nombre de casier de la consigne
	 * @throws IllegalArgumentException si le nombre de casiers est negatif ou nul
	 */
	public ConsigneFIFO(int nombreCasiers){
		// TODO //

		if (nombreCasiers <= 0)
			throw new IllegalArgumentException();

		casiersLibres = new ArrayList<Casier>(nombreCasiers);
		tousLesCasiers = new Casier[nombreCasiers];
		for (int i = 0; i < nombreCasiers; i++) {
			Casier casierTemp = new Casier(i);
			tousLesCasiers[i] = casierTemp;
			casiersLibres.add(casierTemp);
		}
	}

	/**
	 * verifie la presence d'un casier libre
	 * @return true s'il reste au moins un casier de libre, false sinon
	 */
	public boolean resteUnCasierLibre() {
		// TODO //
		return !casiersLibres.isEmpty();
	}

	
	/**
	 * attribue un casier libre selon le principe FIFO
	 * @param motDePasse le mot de passe qui permettra de liberer le casier
	 * @return le numero du casier attribue ou -1 s'il n'y en a plus de libre
	 * @throws IllegalArgumentException si le mot de passe est vide ou null
	 */
	public int attribuerCasierLibre(String motDePasse) {
		// TODO //
		if (motDePasse == null || motDePasse.equals(""))
			throw new IllegalArgumentException();

		if (!resteUnCasierLibre()) {
			return -1;}

		Casier casierTemp = casiersLibres.remove(0);
		casierTemp.setMotDePasse(motDePasse);

		return casierTemp.getNumero();
	}

	/**
	 * libere un casier
	 * @param numeroCasier le numero de casier qui doit etre libere
	 * @param motDePasse le mot de passe a comparer avec le mot de passe du casier
	 * @return true si le mot de passe est le bon, false sinon
	 * @throws IllegalArgumentException si le numero de casier n'existe pas
	 *                                  et/ou si le mot de passe est vide ou null
	 */
	public boolean libererCasier(int numeroCasier, String motDePasse) {
		// TODO //

		if (numeroCasier < 0 || numeroCasier > tousLesCasiers.length -1)
			throw new IllegalArgumentException();

		if (motDePasse == null || motDePasse.equals(""))
			throw new IllegalArgumentException();

		Casier casierTemp = tousLesCasiers[numeroCasier];

		if (!casierTemp.getMotDePasse().equals(motDePasse))
			return false;

		casierTemp.setMotDePasse("");
		casiersLibres.add(casierTemp);

		return true;
	}
}
