import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExportCatalogueTest {

    private Catalogue<Document> catalogue() {
        Catalogue<Document> c = new Catalogue<>();
        c.ajouter(new Livre.Builder("Clean Code", 2008, "R. Martin", 464).build());
        c.ajouter(new Dvd("Matrix", 1999, 136));
        return c;
    }

    @Test
    void exportCsv() {
        String resultat = new ExportCatalogue(new FabriqueCsv()).exporter(catalogue());

        assertEquals("titre;annee\nClean Code;2008\nMatrix;1999\n", resultat);
    }

    @Test
    void exportHtml() {
        String resultat = new ExportCatalogue(new FabriqueHtml()).exporter(catalogue());

        assertEquals("<table>\n"
                + "<tr><td>Clean Code</td><td>2008</td></tr>\n"
                + "<tr><td>Matrix</td><td>1999</td></tr>\n"
                + "</table>\n", resultat);
    }
}