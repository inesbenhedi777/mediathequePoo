public interface Empruntable {
    void emprunter () throws DocumentIndisponibleException; // emprunter peux provoqué l exception d indisponibilité
    void rendre ();
    boolean estDisponible();
}
