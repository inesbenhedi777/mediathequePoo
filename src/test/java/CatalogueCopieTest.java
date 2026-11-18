import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogueCopieTest {

    @Test
    void ajouterALaCopieNeTouchePasLOriginal() {
        Catalogue<Document> original = new Catalogue<>();
        original.ajouter(new Dvd("Matrix", 1999, 136));

        Catalogue<Document> copie = new Catalogue<>(original);
        copie.ajouter(new Dvd("Inception", 2010, 148));

        assertTrue(copie.rechercherParTitre("Inception").isPresent());
        assertTrue(original.rechercherParTitre("Inception").isEmpty());
    }

    @Test
    void lesDocumentsSontPartagesEntreOriginalEtCopie() {
        Livre livre = new Livre.Builder("Clean Code", 2008, "R. Martin", 464).build();
        Catalogue<Document> original = new Catalogue<>();
        original.ajouter(livre);

        Catalogue<Document> copie = new Catalogue<>(original);

        // copie superficielle : c'est le MEME objet, pas un double
        assertSame(livre, copie.rechercherParTitre("Clean Code").get());
    }
}