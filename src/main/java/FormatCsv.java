import java.util.List;

public class FormatCsv implements FormatRapport {
    @Override
    public String formatter(List<Document> docs) {
        String contenu = "";
        for (Document d : docs)
            contenu += d.getTitre() + ";" + d.getId() + "\n";
        return contenu;
    }
}
