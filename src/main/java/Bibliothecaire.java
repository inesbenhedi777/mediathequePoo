public class Bibliothecaire {
    private final Catalogue<Document> catalogue; // COMPOSITION, pas heritage
    private final String nom;

    public Bibliothecaire(String nom, Catalogue<Document> catalogue) {
        this.nom = nom;
        this.catalogue = catalogue;
    }

    public void accueillir() {
        System.out.println("Bonjour, je suis " + nom);
    }


    public void ajouterDocument(Document d) {
        catalogue.ajouter(d);
    }

    public void afficherCatalogue() {
        for (Document d : catalogue) {
            System.out.println(d.descriptionCourte());
        }
    }


}