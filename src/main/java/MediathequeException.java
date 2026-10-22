public abstract class MediathequeException extends Exception {
    //notre choix de d exception est checked puisque les errors sont des erreurs metier previsible que notre app DOIS tenir compte
    public MediathequeException(String message) {
        super(message);
    }
}
