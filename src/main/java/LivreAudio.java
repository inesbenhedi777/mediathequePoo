public class LivreAudio extends Livre {

    private final int dureeMin;

    public LivreAudio(String titre, int annee, String auteur, int nbPages, int dureeMin) {
        super(titre, annee, auteur, nbPages);
        this.dureeMin = dureeMin;
    }

    @Override
    public String descriptionCourte() {
        return super.descriptionCourte() + ", audio " + dureeMin + " min";
    }
}