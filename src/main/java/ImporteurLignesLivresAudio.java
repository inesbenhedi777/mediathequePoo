import static java.lang.Integer.parseInt;

public class ImporteurLignesLivresAudio extends Importeur {

    @Override
    protected Document creerDocument(String ligne) {
        String[] c = ligne.split(";");
        return new LivreAudio(c[0], parseInt(c[1]), c[2], parseInt(c[3]), parseInt(c[4]));
    }
}