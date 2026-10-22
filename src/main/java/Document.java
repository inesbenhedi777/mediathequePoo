public abstract class Document implements Comparable<Document> {

    private static int compteur = 0;

    private final int id;
    protected final String titre;
    protected final int annee;

    protected Document(String titre, int annee) {
        this.id = ++compteur;
        this.titre = titre;
        this.annee = annee;
    }

    public abstract String descriptionCourte();

    public String getTitre() {
        return titre;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Document autre) {
        return this.titre.compareToIgnoreCase(autre.titre);
    }
}