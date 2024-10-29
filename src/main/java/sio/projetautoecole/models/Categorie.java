package sio.projetautoecole.models;

public class Categorie {
    private int idCategorie;
    private String libelle;
    private float prix;
    public Categorie(int idCategorie, String nomCategorie, float prixCategorie) {
        this.idCategorie = idCategorie;
        this.libelle = nomCategorie;
        this.prix = prixCategorie;
    }

    public int getIdPermis() {
        return idCategorie;
    }

    public void setIdPermis(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
