import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImporteurLignesLivresAudioTest {

    @Test
    void importeDesLivresAudio() {
        List<String> lignes = List.of(
                "Dune;1965;F. Herbert;800;1260",
                "",
                "Sapiens;2011;Y. Harari;512;900"
        );

        List<Document> docs = new ImporteurLignesLivresAudio().importer(lignes);

        assertEquals(2, docs.size());
        assertInstanceOf(LivreAudio.class, docs.get(0));
        assertTrue(docs.get(0).descriptionCourte().contains("1260 min"));
    }

    @Test
    void livreAudioInvalideRefuse() {
        assertThrows(IllegalArgumentException.class,
                () -> new ImporteurLignesLivresAudio()
                        .importer(List.of("Vieux;1400;X;100;60")));
    }
}