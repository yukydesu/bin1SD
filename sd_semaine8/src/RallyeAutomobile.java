import java.util.ArrayDeque;
import java.util.Iterator;

public class RallyeAutomobile {


    private ListeSDImpl<String> listePilotes;

    private ListeSDImpl<String> listePiloteArrive;
    private ListeSDImpl<String> listePiloteDisqualifie;

    public RallyeAutomobile (String[] lesPilotes) {

        this.listePilotes = new ListeSDImpl<>(lesPilotes);
        this.listePiloteArrive = new ListeSDImpl<String>();
        this.listePiloteDisqualifie = new ListeSDImpl<String>();
    }


    public String donnerPiloteEnTete() {

        return listePilotes.premier();
    }

    public void enregistrerDepassement(String piloteQuiDepasse) {

        if (this.donnerPiloteEnTete().equals(piloteQuiDepasse))
            throw new IllegalArgumentException("Ce pilote ne peut être avancé car il est en tête");

        if (!listePilotes.permuter(piloteQuiDepasse, listePilotes.donnerPrecedent(piloteQuiDepasse))) {

            if (listePiloteArrive.contient(piloteQuiDepasse))
                throw new IllegalArgumentException("Ce pilote ne peut être avancé car il a déjà franchi la ligne d'arrivée");

            if (listePiloteDisqualifie.contient(piloteQuiDepasse))
                throw new IllegalArgumentException("Ce pilote ne peut être avancé car il est disqualifié");

            else {
                throw new IllegalArgumentException("Ce pilote ne peut être avancé car il ne fait pas partie des pilotes inscrits");
            }
            }
          }


    public void supprimer(String piloteASupprimer) {// try catch

        if (!listePilotes.supprimer(piloteASupprimer))
            if (listePiloteDisqualifie.contient(piloteASupprimer))
                throw new IllegalArgumentException("Ce pilote ne peut pas être disqualifié, car il l'est déjà !");

        listePiloteDisqualifie.insererEnQueue(piloteASupprimer);
    }

    public int donnerPosition(String piloteATrouver) {

        // ---------ITERATOR EXPLIQUER DIFFEREMENT------------- //
        //Iterator<String> it = listePilotes.iterator();
        //int pos = 1;
        //while(it.hasNext()) {
        //    String pilot = it.next();
        //    if(pilot.equals(piloteATrouver)) return pos;
        //    pos ++;
        //}

        int positionPilote = 1;

        for (String piloteDansLaListe : listePilotes) {
            if (piloteDansLaListe.equals(piloteATrouver))
                return positionPilote;
            positionPilote++;
        }
        if (listePiloteArrive.contient(piloteATrouver))
            throw new IllegalArgumentException("Ce pilote n'est plus en course car il a déjà franchi la ligne d'arrivée !");
        if (listePiloteDisqualifie.contient(piloteATrouver))
            throw new IllegalArgumentException("Ce pilote n'est plus en course car il a été disqualifié");
        throw new IllegalArgumentException("Ce pilote n'est plus en course car il n'est pas dans la course");
    }

    public String piloteDeTeteFinirLaCourse() {

        String premierPilote = donnerPiloteEnTete();
        listePilotes.supprimer(listePilotes.premier());
        listePiloteArrive.insererEnQueue(premierPilote);
        return premierPilote;
    }

    public String afficherLeClassementFinal() {

        String classementString = "";

        int classementPilote = 1;

        for (String piloteArrive : listePiloteArrive) {

            classementString += (classementPilote + " : " + piloteArrive + "\n");
            classementPilote ++;

        }
        return classementString;
    }

    @Override
    public String toString() {
        String toutLesPilotes = "";

        for (String pilote : listePilotes) {
            toutLesPilotes += (pilote + "       ");
        }
        return toutLesPilotes;
    }
}
