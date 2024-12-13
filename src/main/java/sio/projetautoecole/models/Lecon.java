package sio.projetautoecole.models;

import java.sql.Date;

public class Lecon {
    private int codeLecon;
    private String date;
    private String heure;
    private int codeMoniteur;
    private int codeEleve;
    private String immatriculation;
    private int reglee;
    private String categorie;

    public Lecon(int codeLecon, String date, String heure, int codeMoniteur, int codeEleve, String immatriculation, int reglee, String categorie) {
        this.codeLecon = codeLecon;
        this.date = date;
        this.heure = heure;
        this.codeMoniteur = codeMoniteur;
        this.codeEleve = codeEleve;
        this.immatriculation = immatriculation;
        this.reglee = reglee;
        this.categorie = categorie;
    }

    public Lecon(int codeLecon, String date, String heure, int codeMoniteur, int codeEleve, String immatriculation, int reglee) {
        this.codeLecon = codeLecon;
        this.date = date;
        this.heure = heure;
        this.codeMoniteur = codeMoniteur;
        this.codeEleve = codeEleve;
        this.immatriculation = immatriculation;
        this.reglee = reglee;

    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getCodeLecon() {
        return codeLecon;
    }

    public void setCodeLecon(int codeLecon) {
        this.codeLecon = codeLecon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public int getCodeMoniteur() {
        return codeMoniteur;
    }

    public void setCodeMoniteur(int codeMoniteur) {
        this.codeMoniteur = codeMoniteur;
    }

    public int getCodeEleve() {
        return codeEleve;
    }

    public void setCodeEleve(int codeEleve) {
        this.codeEleve = codeEleve;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getReglee() {
        return reglee;
    }

    public void setReglee(int reglee) {
        this.reglee = reglee;
    }
}
