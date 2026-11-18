import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatalogueStreamTest {

    @Test
    void filtreEtCompteAvecStream() {
        Catalogue<Document> c = new Catalogue<>();
        c.ajouter(new Livre.Builder("Clean Code", 2008, "R. Martin", 464).build());
        c.ajouter(new Dvd("Matrix", 1999, 136));
        c.ajouter(new Dvd("Inception", 2010, 148));

        long nbDvd = c.stream().filter(d -> d instanceof Dvd).count();

        assertEquals(2, nbDvd);
    }

    @Test
    void trieParTitreAvecStream() {
        Catalogue<Document> c = new Catalogue<>();
        c.ajouter(new Dvd("Matrix", 1999, 136));
        c.ajouter(new Dvd("Inception", 2010, 148));

        List<String> titres = c.stream().sorted().map(Document::getTitre).toList();

        assertEquals(List.of("Inception", "Matrix"), titres);
    }
}