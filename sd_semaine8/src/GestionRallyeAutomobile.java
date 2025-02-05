import java.util.Arrays;

public class GestionRallyeAutomobile {

    public static void main(String[] args) {

        MonScanner scanner = new MonScanner("pilotes.txt");

        System.out.println(
                "************************************************\n" +
                "Programme de gestion d'un Rallye Automobile\n" +
                "*******************************************");

        System.out.print("Entrez le nombre de pilotes : ");
        int nbPilotes = scanner.nextInt();

        String[] listeDesPilotes = new String[nbPilotes];

        for (int i = 0; i < nbPilotes ; i++) {

            System.out.print("\nEntrez le nom du pilote numéro " + (i + 1) + " : ");
            String nomPilote = scanner.next();
            listeDesPilotes[i] = nomPilote;
        }

        RallyeAutomobile rallyeAutomobileActif = new RallyeAutomobile(listeDesPilotes);

        while (rallyeAutomobileActif.donnerPiloteEnTete() != null) {

            System.out.println(
                    "\n\n1 -> Afficher toute la course\n" +
                    "2 -> Afficher le pilote en tête\n" +
                    "3 -> Enregistrer un dépassement\n" +
                    "4 -> Retirer un pilote de la course\n" +
                    "5 -> Donner la position d’un pilote\n" +
                    "6 -> Faire franchir la ligne d’arrivée au pilote de tête");


            int userChoice = scanner.nextInt();

            System.out.print("\nVotre choix : " + userChoice + " ");

            if (userChoice == 1) { // Afficher toute la course

                System.out.println("(Afficher toute la course)");
                System.out.println(rallyeAutomobileActif.toString());

            }
            if (userChoice == 2) { // Afficher le pilote en tête

                System.out.println("(Afficher le pilote en tête)");
                System.out.println("Le pilote en premiere position est " +
                        rallyeAutomobileActif.donnerPiloteEnTete() + ".");

            }
            if (userChoice == 3) { // Enregistrer un dépassement

                System.out.println("(Enregistrer un dépassement)");
                System.out.print("Entrez le nom du pilote qui dépasse : ");
                String piloteQuiDep = scanner.next();

                try {
                    rallyeAutomobileActif.enregistrerDepassement(piloteQuiDep);
                    System.out.println("\nCe pilote a été avancé.");
                } catch (Exception e) {
                    System.out.println("\n" + e.getMessage());
                }

            }
            if (userChoice == 4) { // Retirer un pilote de la course

                System.out.println("(Disqualifié un pilote)");
                System.out.print("Entrez le nom du pilote a disqualifier : ");
                String piloteADisqu = scanner.next();

                try {
                    rallyeAutomobileActif.supprimer(piloteADisqu);
                    System.out.println("\nCe pilote à été disqualifié.");
                }catch (Exception e) {
                    System.out.println("\n" + e.getMessage());
                }

            }
            if (userChoice == 5) { // Donner la position d’un pilote

                System.out.println("(Donner la position d’un pilote)");
                System.out.print("Entrez le nom du pilote dont vous voulez connaitre la position : ");
                String pilotePosition = scanner.next();

                try {
                    int position = rallyeAutomobileActif.donnerPosition(pilotePosition);
                    System.out.println("\nCe pilote se trouve en position " + position);
                }catch (Exception e) {
                    System.out.println("\n" + e.getMessage());
                }

            }
            if (userChoice == 6) { // Faire franchir la ligne d’arrivée au pilote de tête

                System.out.println("(Faire franchir la ligne d’arrivée au pilote de tête)");
                String piloteEnTete = rallyeAutomobileActif.piloteDeTeteFinirLaCourse();
                System.out.println("(" + piloteEnTete + ")" + " vient de franchir la ligne d'arrivée");

            }
        }

        System.out.println("\nLa course est terminée !");
        System.out.println("Voici le classement :");
        System.out.println(rallyeAutomobileActif.afficherLeClassementFinal());
    }
}
