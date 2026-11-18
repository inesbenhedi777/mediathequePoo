public class Livre extends Document implements Empruntable {

    private final String auteur;
    private final int nbPages;
    private final String isbn;
    private final String editeur;
    private final String langue;
    private boolean disponible = true;


    public Livre(String titre, int annee, String auteur, int nbPages) {
        this(new Builder(titre, annee, auteur, nbPages));
    }


    protected Livre(Builder b) {
        super(b.titre, b.annee);
        this.auteur = b.auteur;
        this.nbPages = b.nbPages;
        this.isbn = b.isbn;
        this.editeur = b.editeur;
        this.langue = b.langue;
    }

    public String getIsbn() { return isbn; }
    public String getEditeur() { return editeur; }
    public String getLangue() { return langue; }

    @Override
    public String descriptionCourte() {
        return "[Livre] " + titre + " (" + annee + "), "
                + auteur + ", " + nbPages + " p.";
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

    public static class Builder {
        private final String titre;
        private final int annee;
        private final String auteur;
        private final int nbPages;
        private String isbn;
        private String editeur;
        private String langue;

        public Builder(String titre, int annee, String auteur, int nbPages) {
            this.titre = titre;
            this.annee = annee;
            this.auteur = auteur;
            this.nbPages = nbPages;
        }

        public Builder isbn(String isbn) { this.isbn = isbn; return this; }
        public Builder editeur(String editeur) { this.editeur = editeur; return this; }
        public Builder langue(String langue) { this.langue = langue; return this; }

        Builder valider() {
            if (annee < 1450) {
                throw new IllegalArgumentException("Annee invalide (>= 1450) : " + annee);
            }
            if (nbPages <= 0) {
                throw new IllegalArgumentException("Nombre de pages invalide (> 0) : " + nbPages);
            }
            return this;
        }

        public Livre build() {
            return new Livre(valider());
        }
    }
}