package sio.projetautoecole.models;

public class Categorie {
    private int idCategorie;
    private String nomCategorie;
    private float prixCategorie;
    public Categorie(int idCategorie, String nomCategorie, float prixCategorie) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
        this.prixCategorie = prixCategorie;
    }

    public int getIdPermis() {
        return idCategorie;
    }

    public void setIdPermis(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomPermis() {
        return nomCategorie;
    }

    public void setNomPermis(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public float getPrixPermis() {
        return prixCategorie;
    }

    public void setPrixPermis(float prixCategorie) {
        this.prixCategorie = prixCategorie;
    }
}
