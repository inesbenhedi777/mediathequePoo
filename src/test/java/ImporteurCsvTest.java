import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImporteurCsvTest {

    @Test
    void importeLesTroisTypes() {
        List<String> lignes = List.of(
                "livre;Clean Code;2008;R. Martin;464",
                "",
                "dvd;Matrix;1999;136",
                "revue;Science;2026;412"
        );

        List<Document> docs = new ImporteurCsv().importer(lignes);

        assertEquals(3, docs.size());               // la ligne vide est ignorée
        assertInstanceOf(Livre.class, docs.get(0));
        assertInstanceOf(Dvd.class, docs.get(1));
        assertInstanceOf(Revue.class, docs.get(2));
        assertEquals("Clean Code", docs.get(0).getTitre());
    }

    @Test
    void typeInconnuLeveException() {
        assertThrows(IllegalArgumentException.class,
                () -> new ImporteurCsv().importer(List.of("cd;Truc;2000;10")));
    }
}