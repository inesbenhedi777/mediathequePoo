public class Bibliothecaire {
    private final Catalogue catalogue; // COMPOSITION, pas heritage
    private final String nom;

    public Bibliothecaire(String nom, Catalogue catalogue) {
        this.nom = nom;
        this.catalogue = catalogue;
    }

    public void accueillir() {
        System.out.println("Bonjour, je suis " + nom);
    }

    // Delegation DELIBEREE : seulement ce qu'un bibliothecaire fait vraiment
    // (pas un simple pass-through de toutes les methodes de Catalogue --
    // "bibliothecaire.ajouter(livre)" n'a de sens que si on l'expose expres)
    public void ajouterDocument(Document d) {
        catalogue.ajouter(d);
    }

    public void afficherCatalogue() {
        catalogue.afficherTout();
    }

    // Reponse aux questions du brief :
    // - Un bibliothecaire n'est PAS un catalogue (ce n'est pas "is-a", c'est "has-a")
    // - Avec heritage, si Catalogue change (suppression de methode, signature changee),
    //   Bibliothecaire casse. Avec composition, on controle l'API exposee.
    // - Exposer ajouter() directement signifie que le client code peut manipuler
    //   le catalogue a travers le bibliothecaire, ce qui est coherent si le
    //   bibliothecaire est le point d'entree autorise pour les operations.
}