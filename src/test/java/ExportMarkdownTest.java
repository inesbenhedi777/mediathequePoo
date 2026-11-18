import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExportMarkdownTest {

    @Test
    void exportMarkdown() {
        Catalogue<Document> c = new Catalogue<>();
        c.ajouter(new Livre.Builder("Clean Code", 2008, "R. Martin", 464).build());
        c.ajouter(new Dvd("Matrix", 1999, 136));

        String resultat = new ExportCatalogue(new FabriqueMarkdown()).exporter(c);

        assertEquals("| titre | annee |\n|---|---|\n"
                + "| Clean Code | 2008 |\n"
                + "| Matrix | 1999 |\n", resultat);
    }
}