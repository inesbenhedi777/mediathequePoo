public class FabriqueCsv implements FabriqueExport {

    @Override
    public String enTete() {
        return "titre;annee\n";
    }

    @Override
    public String ligne(Document d) {
        return d.getTitre() + ";" + d.getAnnee() + "\n";
    }

    @Override
    public String pied() {
        return "";
    }
}