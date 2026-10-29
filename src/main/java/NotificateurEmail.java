public class NotificateurEmail implements Notificateur {
    private final ServeurSmtp serveur;

    public NotificateurEmail(ServeurSmtp serveur) {
        this.serveur = serveur;
    }

    @Override
    public void notifier(String message) {
        serveur.envoyer("direction@itbs.tn", message);
    }
}
