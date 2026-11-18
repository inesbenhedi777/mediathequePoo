import java.time.LocalDate;

public class EmpruntManager {
    private final Catalogue<Document> catalogue;
    private final ConfigurationMediatheque config;

    public EmpruntManager(Catalogue<Document> catalogue, ConfigurationMediatheque config) {
        this.catalogue = catalogue;
        this.config = config;
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

    public LocalDate dateRetourPrevue() {
        return LocalDate.now().plusDays(config.getDureeEmprunt());
    }
}