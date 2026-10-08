public class Livre extends Document implements Empruntable {

    private final String auteur;
    private final int nbPages;
    private boolean disponible = true;

    public Livre(String titre, int annee, String auteur, int nbPages) {
        super(titre, annee);
        this.auteur = auteur;
        this.nbPages = nbPages;
    }

    @Override
    public String descriptionCourte() {
        return "[Livre] " + titre + " (" + annee + "), "
                + auteur + ", " + nbPages + " p.";
    }

    @Override
    public void emprunter() throws DocumentIndisponibleException{
        if (!disponible) {
            throw new DocumentIndisponibleException(
                    "Document indisponible : " + titre // si le document est indisponible ca provoque l exception DocumentIndisponibleException
            );
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