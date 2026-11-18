import static java.lang.Integer.parseInt;

public class ImporteurCsv extends Importeur {

    @Override
    protected Document creerDocument(String ligne) {
        String[] c = ligne.split(";");
        return switch (c[0]) {
            case "livre" -> new Livre(c[1], parseInt(c[2]), c[3], parseInt(c[4]));
            case "dvd"   -> new Dvd(c[1], parseInt(c[2]), parseInt(c[3]));
            case "revue" -> new Revue(c[1], parseInt(c[2]), parseInt(c[3]));
            default -> throw new IllegalArgumentException("Type inconnu : " + c[0]);
        };
    }
}