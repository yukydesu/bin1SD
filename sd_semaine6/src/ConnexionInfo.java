
public class ConnexionInfo {
   
 	Ensemble<LoginInfo> ensembleDesConnectes;
 	// N'AJOUTEZ PAS D'AUTRES ATTRIBUTS!!!
 	// N'OUBLIEZ PAS DE COMPLETER LA METHODE HASHCODE() DE LA CLASSE LOGININFO
 	
 	public ConnexionInfo(){
		// TODO /

		ensembleDesConnectes = new EnsembleTableBooleens<>(137);

	}
 	
 	public	int nombreDeConnectes(){
		// TODO /

 		return ensembleDesConnectes.taille();

	}

 	// ajoute le loginInfo s'il n'est pas encore connecte
	public boolean connecter(LoginInfo loginInfo){
		// TODO /

		return ensembleDesConnectes.ajouter(loginInfo);
	}

	// retire le loginInfo s'il est connecte
	public boolean deconnecter(LoginInfo loginInfo){
		// TODO /

		return ensembleDesConnectes.enlever(loginInfo);
	}

	public boolean estConnecte(LoginInfo loginInfo){
		// TODO /

		return ensembleDesConnectes.contient(loginInfo);
	}
	

}