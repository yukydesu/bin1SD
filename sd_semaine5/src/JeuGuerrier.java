
public class JeuGuerrier {
	
	public static void main(String[] args) {
		EquipeGuerriers equipe = new EquipeGuerriers(3, 10);
		int pointsDeVieDuMal = 30;
		int deTemp = 0;

		// TODO //

		while (pointsDeVieDuMal > 0 && equipe.nombreGuerriersEnVie() > 0) {

			System.out.println("L'équipe compte " + equipe.nombreGuerriersEnVie() + " guerriers en vie");

			deTemp = lancerDe();
			Guerrier guerrierEnCombat = equipe.jouer(deTemp);
			System.out.println("Suite au combat entre la creature du mal et le guerrier n°" + guerrierEnCombat.getNumero());
			System.out.println("Le guerrier vient de perdre "  + deTemp + " points de vie");
			System.out.println("Guerrier n°" + guerrierEnCombat.getNumero() + " : " + guerrierEnCombat.getPointsDeVie() + " points de vie ---------------------");

			deTemp = lancerDe();
			pointsDeVieDuMal -= lancerDe();

			System.out.println("La creature du mal vient de perdre " + deTemp + " points de vie");

			if (pointsDeVieDuMal <= 0)
				System.out.println("La creature du mal est morte");
			else {
				System.out.println("Il lui reste " + pointsDeVieDuMal + " points de vie");

				if (guerrierEnCombat.getPointsDeVie() <= 0)
					System.out.println("Le guerrier est mort \n \n");

				if (equipe.nombreGuerriersEnVie() < 2) {
					int numNouveauGuerrier = equipe.ajouterNouveauGuerrier();
					System.out.println("Le guerrier num" + numNouveauGuerrier + " est arrivé en renfort ! &&&&&&&&&&&&&&&&&&&&&&");

				if (equipe.nombreGuerriersEnVie() == 0)
					System.out.println("Tous les guerriers sont morts" );
				}
			}
		}
	}
	
	public static int lancerDe (){
		double nombreReel;
		nombreReel = Math.random();
		return (int) (nombreReel * 6) + 1;
	}
	
}
