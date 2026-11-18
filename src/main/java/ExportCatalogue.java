public class ExportCatalogue {

    private final FabriqueExport fabrique;

    public ExportCatalogue(FabriqueExport fabrique) {
        this.fabrique = fabrique;
    }

    public String exporter(Iterable<Document> docs) {
        StringBuilder sb = new StringBuilder(fabrique.enTete());
        for (Document d : docs) {
            sb.append(fabrique.ligne(d));
        }
        return sb.append(fabrique.pied()).toString();
    }
}