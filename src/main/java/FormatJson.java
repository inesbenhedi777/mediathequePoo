import java.util.List;

public class FormatJson implements FormatRapport {
    @Override
    public String formatter(List<Document> docs) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < docs.size(); i++) {
            Document d = docs.get(i);
            sb.append("  {\"titre\": \"").append(d.getTitre()).append("\", \"id\": ").append(d.getId()).append("}");
            if (i < docs.size() - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
