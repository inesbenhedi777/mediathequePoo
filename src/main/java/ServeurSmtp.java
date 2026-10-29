public class ServeurSmtp {
    private final String serveur;

    public ServeurSmtp(String serveur) {
        this.serveur = serveur;
    }

    public void envoyer(String destinataire, String sujet) {
        System.out.println("[SMTP] Envoi à " + destinataire + " via " + serveur + " - Sujet: " + sujet);
    }
}
