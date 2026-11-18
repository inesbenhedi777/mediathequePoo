public class EmpruntManager {
    private final Catalogue<Document> catalogue;

    public EmpruntManager(Catalogue<Document> catalogue) {
        this.catalogue = catalogue;
    }

    public void emprunter(String titre) throws DocumentIntrouvableException,
                                                DocumentIndisponibleException {
        Document doc = catalogue.rechercherParTitre(titre)
            .orElseThrow(() -> new DocumentIntrouvableException("Document introuvable : " + titre));

        if (doc instanceof Empruntable empruntable) {
            empruntable.emprunter();
        } else {
            throw new DocumentIndisponibleException("Non empruntable : " + titre);
        }
    }
}