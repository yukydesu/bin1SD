import java.util.LinkedList;

public class DocumentsLRU {

	private LinkedList<String> listeLRU;
	
	
	/**
	 * construit une liste de nombreDocuments documents : doc1 doc2 ...
	 * @param nombreDocuments
	 * @throws IllegalArgumentException il faut au moins 1 document
	 */
	public DocumentsLRU(int nombreDocuments){
		// TODO /

		if (nombreDocuments < 1)
			throw new IllegalArgumentException();

		listeLRU = new LinkedList<>();

		for (int i = 0; i < nombreDocuments; i++) {
			String docTemp = "doc"+(i + 1);
			listeLRU.addLast(docTemp);
		}
	}
	

	/**
	 * place le document passe en parametre dans la liste selon le mecanisme LRU
	 * @param document qui est ouvert
	 * @throws IllegalArgumentException si le document est null ou ""
	 */
	public void ouvrirDocument(String document){
		//TODO//

		if (document ==null)
			throw new IllegalArgumentException();


		if (!listeLRU.remove(document))
			listeLRU.removeLast();

		listeLRU.addFirst(document);
	}
	
	
	public String toString(){
		return listeLRU.toString();
	}
	
}
