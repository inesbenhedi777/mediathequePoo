public class Main {
    public static void main(String[] args) {
        var config = new ConfigurationMediatheque(21, 5);
        var catalogue = new Catalogue<Document>();
        var manager = new EmpruntManager(catalogue, config);
    }
}