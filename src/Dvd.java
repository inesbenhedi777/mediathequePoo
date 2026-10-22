public class Dvd extends Document implements Empruntable {
    private final int dureeMin;
    private boolean disponible = true;

    public Dvd(String titre, int annee, int dureeMin) {
        super(titre, annee);
        this.dureeMin = dureeMin;
    }

    @Override
    public String descriptionCourte() {
        return "[Dvd] " + titre + " (" + annee + "), " + dureeMin + " min.";
    }

    @Override
    public void emprunter() throws DocumentIndisponibleException {
        if (!disponible) {
            throw new DocumentIndisponibleException("Document indisponible : " + titre);
        }
        disponible = false;
    }

    @Override
    public void rendre() {
        disponible = true;
    }

    @Override
    public boolean estDisponible() {
        return disponible;
    }
}