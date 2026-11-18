public class LivreAudio extends Livre {

    private final int dureeMin;

    public LivreAudio(Livre.Builder b, int dureeMin) {
        super(b.valider());
        this.dureeMin = dureeMin;
    }

    @Override
    public String descriptionCourte() {
        return super.descriptionCourte() + ", audio " + dureeMin + " min";
    }
}