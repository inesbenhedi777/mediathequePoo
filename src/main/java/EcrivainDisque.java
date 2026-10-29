import java.io.FileWriter;
import java.io.IOException;

public class EcrivainDisque implements DestinationRapport {
    private final String chemin;

    public EcrivainDisque(String chemin) {
        this.chemin = chemin;
    }

    @Override
    public void ecrire(String contenu) throws IOException {
        try (var w = new FileWriter(chemin)) {
            w.write(contenu);
        }
    }
}
