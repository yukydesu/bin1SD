public class Connexion {
   
	Ensemble<Login> ensembleDesConnectes;
 	// N'AJOUTEZ PAS D'AUTRES ATTRIBUTS!!!
	// N'OUBLIEZ PAS DE COMPLETER LA METHODE HASHCODE() DE LA CLASSE LOGIN
	
	public Connexion(){

		ensembleDesConnectes = new EnsembleTableBooleens<>(256);
		// A COMPLETER
	}

	public int nombreDeConnectes(){
		// TODO /
		return ensembleDesConnectes.taille();
	}
	
	// ajoute le login s'il n'est pas encore connecte
	public boolean connecter(Login login){
		// TODO /
		return ensembleDesConnectes.ajouter(login);

	}
	
	// retire le login s'il est connecte
	public boolean deconnecter(Login login){
		// TODO /
		return ensembleDesConnectes.enlever(login);
	}

	public boolean estConnecte(Login login){
		// TODO /
		return ensembleDesConnectes.contient(login);
	}
	
	

	
}

