public class EmpruntManager {
    private final Catalogue<Document> catalogue;

    public EmpruntManager(Catalogue<Document> catalogue) {
        this.catalogue = catalogue;
    }

    public void emprunter(String titre) throws DocumentIntrouvableException,
                                                DocumentIndisponibleException {
        Document doc = catalogue.rechercherParTitre(titre)
            .orElseThrow(() -> new DocumentIntrouvableException("Document introuvable : " + titre));

        // Verification d'une CAPACITE (pas une cascade de type) -- usage
        // legitime d'instanceof avec pattern matching, different de
        // l'interdit "cascade instanceof" de la seance 1.
        if (doc instanceof Empruntable empruntable) {
            empruntable.emprunter();
        } else {
            throw new DocumentIndisponibleException("Non empruntable : " + titre);
        }
    }
}