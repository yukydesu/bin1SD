import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Concours {

    private Candidat[] tableCandidats;
    private HashMap<String, Candidat> mapCandidats; //nom --> candidat
    private HashMap<String, Integer> mapVotants; //numero de telephone --> nombre de votes
    private int nombreMaxVotes;

    /**
     * debute un concours
     *
     * @param tableNomsCandidats la table avec les noms des candidats
     * @param nombreMaxVotes     le nombre maximal de votes qu'un spectateur peut faire
     * @throws IllegalArgumentException s'il n'y a pas au moins un vote possible par spectateur
     *                                  si la table des noms des candidats est null ou est vide
     *                                  s'il y a des homonymes
     */
    public Concours(String[] tableNomsCandidats, int nombreMaxVotes) {
        //TODO
        tableCandidats = new Candidat[tableNomsCandidats.length];
        mapCandidats = new HashMap<>();
        mapVotants = new HashMap<>();
        this.nombreMaxVotes = nombreMaxVotes;

        for (int i = 0; i < tableNomsCandidats.length; i++) {

            Candidat candidatTemp = new Candidat("c" + (i+1), i +1);

            if (mapCandidats.containsKey(tableNomsCandidats[i]))
                throw new IllegalArgumentException();

            mapCandidats.put(tableNomsCandidats[i], candidatTemp);
            tableCandidats[i] = candidatTemp;
        }
    }

    public int getNombreMaxVotes() {
        return nombreMaxVotes;
    }

    /**
     * ajoute 1 vote au candidat dont le nom est passe en parametre
     * a condition que le candidat existe
     * et a condition que le nombre max de votes n'est pas atteint pour le numero de telephone passe en parametre
     *
     * @param numeroTelephone le numero de telephone qui fait le vote
     * @param nomCandidat     le nom du candidat qui fait l'objet du vote
     * @return true si le vote a ete fait, false sinon
     * @throws IllegalArgumentException si le numero de telephone est null
     *                                  si le nom du candidat est null
     */
    public boolean voterViaNom(String numeroTelephone, String nomCandidat) {
        //TODO

        if (numeroTelephone == null || nomCandidat == null)
            throw new IllegalArgumentException();

        if (!mapCandidats.containsKey(nomCandidat))
            return false;

        if(!mapVotants.containsKey(numeroTelephone)) {
            mapVotants.put(numeroTelephone, 0);
        }

        int nbVotesVotant = mapVotants.get(numeroTelephone);

        if (nbVotesVotant >= getNombreMaxVotes())
            return false;

        nbVotesVotant++;

        mapVotants.put(numeroTelephone, nbVotesVotant);

        mapCandidats.get(nomCandidat).ajouter1Vote();
        return true;
    }

    /**
     * ajoute 1 vote au candidat dont le numero est passe en parametre
     * a condition que le candidat existe
     * et a condition que le nombre max de votes n'est pas atteint pour le numero de telephone passe en parametre
     *
     * @param numeroTelephone le numero de telephone qui fait le vote
     * @param numeroCandidat  le numero du candidat qui fait l'objet du vote
     * @return true si le vote a ete fait, false sinon
     * @throws IllegalArgumentException si le numero de telephone est null
     */
    public boolean voterViaNumero(String numeroTelephone, int numeroCandidat) {
        //TODO

        if (numeroTelephone == null)
            throw new IllegalArgumentException();

        if (numeroCandidat < 0 || numeroCandidat > tableCandidats.length)
            return false;

        if (tableCandidats[numeroCandidat-1] == null)
            return false;

        if (!mapVotants.containsKey(numeroTelephone)) {
            mapVotants.put(numeroTelephone, 0);
        }

        int nombreVotesVotants = mapVotants.get(numeroTelephone);
        nombreVotesVotants ++;
        mapVotants.put(numeroTelephone, nombreVotesVotants);

        tableCandidats[numeroCandidat-1].ajouter1Vote();

        return false;
    }

    /**
     * construit une table dans laquelle les candidats apparaissent tries selon l'ordre decroissant des nombres de vote
     *
     * @return la table dans laquelle les candidats apparaissent tries selon l'ordre decroissant des nombres de vote
     */
    public Candidat[] classement() {
        // Utilisez les methodes copyOf() et sort() de la classe Arrays !
        // cfr enonce
        //TODO

        Candidat[] tableTemp = Arrays.copyOf(tableCandidats, tableCandidats.length);
        Arrays.sort(tableTemp);
        return tableTemp;
    }

    @Override
    // A NE PAS MODIFIER
    public String toString() {
        return "maxVotes=" + nombreMaxVotes +
                "\ntableCandidats=" + Arrays.toString(tableCandidats) +
                "\nmapCandidats=" + mapCandidats +
                "\nmapVotants=" + mapVotants;
    }

}

