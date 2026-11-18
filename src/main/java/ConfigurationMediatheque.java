public class ConfigurationMediatheque {

    private final int dureeEmprunt;
    private final int maxEmprunts;

    public ConfigurationMediatheque(int dureeEmprunt, int maxEmprunts) {
        this.dureeEmprunt = dureeEmprunt;
        this.maxEmprunts = maxEmprunts;
    }

    public int getDureeEmprunt() { return dureeEmprunt; }
    public int getMaxEmprunts() { return maxEmprunts; }
}