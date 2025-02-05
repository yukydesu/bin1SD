import java.util.Arrays;

// implementation de l'interface File via une table circulaire

/**
 * @author 
 *
 */

public class FileImplViaTable<E> implements File<E>{

	private Object[] table;  // ne modifiez pas cet identifiant, la classe test l'utilise					
	private int indiceTete;  // ne modifiez pas cet identifiant, la classe test l'utilise			
	private int taille;		// ne modifiez pas cet identifiant, la classe test l'utilise	
	// N'ajoutez pas d'autres attributs, la classe test risquerait de ne pas fonctionner
	

	public FileImplViaTable(){
		table = new Object[4];
		taille = 0;
		indiceTete = 0;
	}
	

	public boolean estVide(){
		return taille == 0;
	}


	public int taille(){
		return taille;
	}

	public E premier()throws FileVideException{
		//TODO //

		if (taille == 0)
			throw new FileVideException();

		return (E) table[indiceTete];
	}


	public E defile() throws FileVideException{
		//TODO //

		if (taille == 0)
			throw new FileVideException();

		E eTemp = (E) table[indiceTete];

		indiceTete ++;

		if (indiceTete == table.length)
			indiceTete = 0;

		taille --;

		return eTemp;
	}


	public void enfile(E element){
		//TODO

		if (taille == table.length) {

			int indexTableTemp = 0;

			Object[] tableTemp = new Object[table.length * 2];
			for (int i = indiceTete ; i < table.length; i++) {
				tableTemp[indexTableTemp] = table[i];
				indexTableTemp ++;
			}
			for (int i = 0; i < indiceTete ; i++) {
				tableTemp[indexTableTemp] = table[i];
				indexTableTemp ++;
			}

			indiceTete = 0;
			table = tableTemp;
		}

		table[(indiceTete + taille) % table.length] = element;
		taille ++;

    }

} 
