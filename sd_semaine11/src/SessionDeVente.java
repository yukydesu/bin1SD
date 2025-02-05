import java.util.*;

public class SessionDeVente {
	
	private ArrayDeque<String> fileAttente;
	private HashSet<String> ensembleClientsActuellementDansFile;
	private HashMap<String, Commande> mapClientCommande;	
	private ArrayList<Commande> listeCommandes;
	private int nombreCasiersRestants;
	public final static int MAX_CASIERS_CLIENT = 3;

	
	/**
	 * debute une session de vente
	 * @param nombreCasiersMisEnVente le nombre de casiers mis en vente
	 * @throws IllegalArgumentException s'il n'y a pas au moins un casier a vendre 
	 */
	public SessionDeVente(int nombreCasiersMisEnVente) {
		if(nombreCasiersMisEnVente<=0)
			throw new IllegalArgumentException();
		this.nombreCasiersRestants = nombreCasiersMisEnVente;
		fileAttente = new ArrayDeque<String>();
		ensembleClientsActuellementDansFile = new HashSet<String>();
		mapClientCommande = new HashMap<String, Commande>();
		listeCommandes = new ArrayList<Commande>();
	}

	
	public int getNombreCasiersRestants() {
		return nombreCasiersRestants;
	}
	
	/**
	 * ajoute, si possible, le client dans la file d'attente
	 * le client ne peut pas deja y etre
	 * si client a deja une commande lors de cette session de vente, le max de casiers autorise n'est pas deja atteint
	 * s'il reste encore des casiers a vendre
	 * @param client le client a ajouter
	 * @return true si l'ajout a pu se faire, false sinon
	 * @throws IllegalArgumentException si le client est null ou vide
	 */
	public boolean placerDansFileAttente(String client){
		//TODO

		// d'abord traiter les cas particuliers, ensuite traiter les cas généraux

		if (client == null || client.isEmpty() )
			throw new IllegalArgumentException();

		// si le client est deja dans la file
		if (ensembleClientsActuellementDansFile.contains(client))
			return false;

		// si out of stock
		if (nombreCasiersRestants == 0)
			return false;

		// si le client a déjà une commande
		if (mapClientCommande.containsKey(client)) {
			// si le client a deja commandé son max de casier
			if (mapClientCommande.get(client).getNombreCasiersDemandes() == MAX_CASIERS_CLIENT) {
				return false;
			}
		}
		// sinon
		ensembleClientsActuellementDansFile.add(client); // ajoute le client à l'ensemble s'il n'y est pas
		fileAttente.add(client); // ajoute le client dans la liste
		return true;
	}
		
	/**
	 * retire de la file d'attente le client de tete
	 * @return le client de tete ou null si la file est vide
	 */
	public String selectionnerClientSuivant(){
		//TODO

		// si la file est vide
		if (ensembleClientsActuellementDansFile.isEmpty())
			return null;

		// retire le client premier de la file
		String clientTemp = fileAttente.removeFirst();
		// retire le client de l'ensemble
		ensembleClientsActuellementDansFile.remove(clientTemp);

		return clientTemp;

	}
	
	/**
	 * ajoute, si possible, une nouvelle commande  
	 * le nombre de casiers restants doit etre suffisant pour satisfaire completement la commande
	 * (il n'y a pas de commande partielle)
	 * le nombre de casiers demandes ne peut depasser le max autorise
	 * @param client le client qui fait la demande
	 * @param nombreCasiersDemandes le nombre de casiers demandes
	 * @return true si la commande a pu etre faite, false sinon
	 * @throws IllegalArgumentException si le client est null ou vide
	 *  	ou si le nombre de casiers demand�s est <=0
	 * @throws IllegalStateException si le client a deja fait une commande  
	 */
	public boolean passerNouvelleCommande(String client, int nombreCasiersDemandes){
		//TODO

		// paramètre invalide
		if (client == null || client.isEmpty() || nombreCasiersDemandes <= 0)
			throw new IllegalArgumentException();

		// si le nombre de casiers demandé dépasse la limite
		if (nombreCasiersDemandes > MAX_CASIERS_CLIENT)
			return false;

		// s'il n'y a pas assez de casier en stock
		if (nombreCasiersRestants < nombreCasiersDemandes)
			return false;

		// si le client a déjà une commande
		if (mapClientCommande.containsKey(client)) {
			throw new IllegalStateException();
		}

		// création de la commande
		Commande nouvelleCommande = new Commande(client, nombreCasiersDemandes);

		// mettre la commande dans le Map et dans la liste
		mapClientCommande.put(client, nouvelleCommande);
		listeCommandes.add(nouvelleCommande);
		// retirer les casiers demandés du stock
		nombreCasiersRestants -= nombreCasiersDemandes;

		return true;

	}	
		
	
	/**
	 * modifie, si possible, une commande existante
	 * le nombre de casiers restants doit etre suffisant
	 * (il n'y a pas de commande partielle)
	 * le nombre total de casiers apres ajout de ce nombre de casiers supplementaires ne peut depasser le max autorise
	 * @param client le client qui veut modifier sa commande
	 * @param nombreCasiersDemandesEnPlus le nombre de casiers a ajouter au nombre de casiers deja commande
	 * @return true si la commande a pu etre modifiee, false sinon
	 * @throws IllegalArgumentException si le client est null ou vide
	 *  	ou si le nombre de casiers demandes est <= 0
	 * @throws IllegalStateException si le client n'a pas encore fait de commande lors de cette session de commande
	 */
	public boolean modifierCommande(String client,int nombreCasiersDemandesEnPlus){
		//TODO

		// arguments invalide
		if (client == null || client.isEmpty())
			throw new IllegalArgumentException();

		// si out of stock
		if (nombreCasiersDemandesEnPlus <= 0)
			throw new IllegalArgumentException();

		// si casier demandé > casier restant
		if (nombreCasiersRestants < nombreCasiersDemandesEnPlus)
			return false;

		// la commande du client
		Commande commandeTemp = mapClientCommande.get(client);

		// s'il n'a pas de commande
		if (commandeTemp == null)
			throw new IllegalStateException();

		// si le nombre total de casiers dépasse la limite
		if (commandeTemp.getNombreCasiersDemandes() + nombreCasiersDemandesEnPlus > MAX_CASIERS_CLIENT)
			return false;

		// modifie le nombre de casiers demandé
		commandeTemp.setNombreCasiersDemandes(commandeTemp.getNombreCasiersDemandes() + nombreCasiersDemandesEnPlus);

		// retire les casiers demandés du stock
		nombreCasiersRestants -= nombreCasiersDemandesEnPlus;

		return true;
	}	
	
	
	public String toString(){
		// cette methode ne sera pas evaluee
		// elle peut-etre interessante a appeler en cas de bug
		// n'hesitez pas a la completer
		return "le nombre de casiers restants : "+ nombreCasiersRestants 
				+ "\nla file d'attente : "+ fileAttente +  "\nles commandes " + listeCommandes;
	}

}

		
	
	
	
	
	

