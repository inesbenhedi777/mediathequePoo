public class FabriqueHtml implements FabriqueExport {

    @Override
    public String enTete() {
        return "<table>\n";
    }

    @Override
    public String ligne(Document d) {
        return "<tr><td>" + d.getTitre() + "</td><td>" + d.getAnnee() + "</td></tr>\n";
    }

    @Override
    public String pied() {
        return "</table>\n";
    }
}