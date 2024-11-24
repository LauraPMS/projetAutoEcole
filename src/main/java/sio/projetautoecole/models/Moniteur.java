package sio.projetautoecole.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public class Moniteur {
    private int idMoniteur;
    private String nomMoniteur;
    private String prenomMoniteur;
    private String adresseMoniteur;
    private int sexeMoniteur;
    private LocalDate dateMoniteur;
    private String codePostal;
    private String villeMoniteur;
    private String telephoneMoniteur;
    private int numCompte;
    private String imgPdp;

    public Moniteur(int idMoniteur, String nomMoniteur, String prenomMoniteur, String adresseMoniteur, int sexeMoniteur, LocalDate dateMoniteur, String codePostal, String villeMoniteur, String telephoneMoniteur, String imgPdp, int numCompte) {
        this.idMoniteur = idMoniteur;
        this.nomMoniteur = nomMoniteur;
        this.prenomMoniteur = prenomMoniteur;
        this.adresseMoniteur = adresseMoniteur;
        this.sexeMoniteur = sexeMoniteur;
        this.dateMoniteur = dateMoniteur;
        this.codePostal = codePostal;
        this.villeMoniteur = villeMoniteur;
        this.telephoneMoniteur = telephoneMoniteur;
        this.imgPdp = imgPdp;
        this.numCompte = numCompte;
    }

    public int getIdMoniteur() {
        return idMoniteur;
    }

    public void setIdMoniteur(int idMoniteur) {
        this.idMoniteur = idMoniteur;
    }

    public String getNomMoniteur() {
        return nomMoniteur;
    }

    public void setNomMoniteur(String nomMoniteur) {
        this.nomMoniteur = nomMoniteur;
    }

    public String getPrenomMoniteur() {
        return prenomMoniteur;
    }

    public void setPrenomMoniteur(String prenomMoniteur) {
        this.prenomMoniteur = prenomMoniteur;
    }

    public String getAdresseMoniteur() {
        return adresseMoniteur;
    }

    public void setAdresseMoniteur(String adresseMoniteur) {
        this.adresseMoniteur = adresseMoniteur;
    }

    public int getSexeMoniteur() {
        return sexeMoniteur;
    }

    public void setSexeMoniteur(int sexeMoniteur) {
        this.sexeMoniteur = sexeMoniteur;
    }

    public LocalDate getDateMoniteur() {
        return dateMoniteur;
    }

    public void setDateMoniteur(LocalDate dateMoniteur) {
        this.dateMoniteur = dateMoniteur;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVilleMoniteur() {
        return villeMoniteur;
    }

    public void setVilleMoniteur(String villeMoniteur) {
        this.villeMoniteur = villeMoniteur;
    }

    public String getTelephoneMoniteur() {
        return telephoneMoniteur;
    }

    public void setTelephoneMoniteur(String telephoneMoniteur) {
        this.telephoneMoniteur = telephoneMoniteur;
    }

    public String getImgPdp() {
        return imgPdp;
    }

    public void setImgPdp(String imgPdp) {
        this.imgPdp = imgPdp;
    }

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public HashMap<String, String> getAllInfoMoniteur(){
        HashMap<String, String> infoEleve = new HashMap<>();
        infoEleve.put("idEleve", String.valueOf(this.idMoniteur));
        infoEleve.put("nomEleve", this.nomMoniteur);
        infoEleve.put("prenomEleve", this.prenomMoniteur);
        infoEleve.put("adresseEleve", this.adresseMoniteur);
        infoEleve.put("telephoneEleve", this.telephoneMoniteur);
        infoEleve.put("sexeEleve", String.valueOf(this.sexeMoniteur));
        infoEleve.put("dateNaisseEleve", String.valueOf(this.dateMoniteur));
        infoEleve.put("codePostalEleve", this.codePostal);
        infoEleve.put("villeEleve", this.villeMoniteur);
        infoEleve.put("numCompte", String.valueOf(this.numCompte));
        infoEleve.put("imgPdp", this.imgPdp);
        return infoEleve;
    }
}
