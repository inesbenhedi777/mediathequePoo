import java.util.List;

public class FormatTxt implements FormatRapport {
    @Override
    public String formatter(List<Document> docs) {
        String contenu = "";
        for (Document d : docs)
            contenu += "-" + d.descriptionCourte() + "\n";
        return contenu;
    }
}
