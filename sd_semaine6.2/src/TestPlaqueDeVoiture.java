import java.util.Arrays;

public class TestPlaqueDeVoiture {

	public final static int NBRE_LISTES =500;
	
	public static void main (String args[]) {

		String plaque = "";
		int[] compteur = new int[NBRE_LISTES];

		for (char c1 = 'A' ; c1 <= 'Z' ; c1++) {
			for (char c2 = 'A' ; c2 <= 'Z' ; c2++) {
				for (char c3 = 'A' ; c3 <= 'Z' ; c3++) {
					for (int i1 = 0; i1 <= 9; i1++) {
						for (int i2 = 0; i2 <= 9; i2++) {
							for (int i3 = 0; i3 <= 9; i3++) {

								plaque = "1" + c1 + c2 + c3 + i1 + i2 + i3;
								Voiture voiture = new Voiture(plaque, "");
								int index = Math.abs(voiture.hashCode() % NBRE_LISTES);
								compteur[index]++;

							}

						}
						
					}

				}

			}
		}
		// Attention, la methode hashCode() renvoie un entier
		// Cet entier pourrait etre negatif --> Math.abs()		
		// Cet entier doit correspondre a une liste --> %NBRE_LISTES
		for (int i = 0; i < NBRE_LISTES; i++) {
			System.out.println(compteur[i]);
		}
	}
}
