public class RapportEmprunts implements AutoCloseable {
    private int nbEmprunts = 0;

    public void enregistrer() { nbEmprunts++; }

    @Override
    public void close() {
        System.out.println("Rapport : " + nbEmprunts + " emprunt(s) effectue(s).");
    }
}