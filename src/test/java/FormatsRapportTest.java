import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatsRapportTest {
    @Test
    void txtListeLesDescriptions() {
        Dvd dvd = new Dvd("Matrix", 1999, 136);
        Revue revue = new Revue("Science", 2026, 412);

        String resultat = new FormatTxt().formatter(List.of(dvd, revue));

        assertEquals("-" + dvd.descriptionCourte() + "\n"
                + "-" + revue.descriptionCourte() + "\n", resultat);
    }

    @Test
    void txtListeVide() {
        assertEquals("", new FormatTxt().formatter(List.of()));
    }

    @Test
    void jsonDeuxDocumentsSeparesParUneVirgule() {
        Dvd dvd = new Dvd("Matrix", 1999, 136);
        Revue revue = new Revue("Science", 2026, 412);

        String resultat = new FormatJson().formatter(List.of(dvd, revue));

        assertEquals("[\n"
                + "  {\"titre\": \"Matrix\", \"id\": " + dvd.getId() + "},\n"
                + "  {\"titre\": \"Science\", \"id\": " + revue.getId() + "}\n"
                + "]", resultat);
    }

    @Test
    void jsonUnSeulDocumentSansVirgule() {
        Dvd dvd = new Dvd("Matrix", 1999, 136);

        String resultat = new FormatJson().formatter(List.of(dvd));

        assertEquals("[\n"
                + "  {\"titre\": \"Matrix\", \"id\": " + dvd.getId() + "}\n"
                + "]", resultat);
    }

    @Test
    void jsonListeVide() {
        assertEquals("[\n]", new FormatJson().formatter(List.of()));
    }
}