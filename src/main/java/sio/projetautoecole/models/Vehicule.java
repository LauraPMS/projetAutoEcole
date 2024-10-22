package sio.projetautoecole.models;

public class Vehicule {
    private String immatriculation;
    private String marque;
    private String modele;
    private Categorie categorie;
    private String annee;

    public Vehicule(String immatriculation, String marque, String modele, Categorie categorie, String annee) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.categorie = categorie;
        this.annee = annee;
    }
}
