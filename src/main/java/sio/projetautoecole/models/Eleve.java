package sio.projetautoecole.models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;

public class Eleve {
    private int idEleve;
    private String nomEleve;
    private String prenomEleve;
    private String adresseEleve;
    private String telephoneEleve;
    private int sexeEleve;
    private LocalDate dateNaisseEleve;
    private String codePostalEleve;
    private String villeEleve;
    private int numCompte;
    private String imgPdp;


    public Eleve() {}
    public Eleve(int idEleve, String nomEleve, String prenomEleve, String adresseEleve, String telephoneEleve, int sexeEleve, LocalDate dateNaisseEleve, String codePostalEleve, String villeEleve, int numCompte, String imgPdp) {
        this.idEleve = idEleve;
        this.nomEleve = nomEleve;
        this.prenomEleve = prenomEleve;
        this.adresseEleve = adresseEleve;
        this.telephoneEleve = telephoneEleve;
        this.sexeEleve = sexeEleve;
        this.dateNaisseEleve = dateNaisseEleve;
        this.codePostalEleve = codePostalEleve;
        this.villeEleve = villeEleve;
        this.numCompte = numCompte;
        this.imgPdp = imgPdp;
    }


    public String getImgPdp() {
        return imgPdp;
    }

    public void setImgPdp(String imgPdp) {
        this.imgPdp = imgPdp;
    }

    public int getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }

    public String getNomEleve() {
        return nomEleve;
    }

    public void setNomEleve(String nomEleve) {
        this.nomEleve = nomEleve;
    }

    public String getPrenomEleve() {
        return prenomEleve;
    }

    public void setPrenomEleve(String prenomEleve) {
        this.prenomEleve = prenomEleve;
    }

    public String getAdresseEleve() {
        return adresseEleve;
    }

    public void setAdresseEleve(String adresseEleve) {
        this.adresseEleve = adresseEleve;
    }

    public String getTelephoneEleve() {
        return telephoneEleve;
    }

    public void setTelephoneEleve(String telephoneEleve) {
        this.telephoneEleve = telephoneEleve;
    }

    public int getSexeEleve() {
        return sexeEleve;
    }

    public void setSexeEleve(int sexeEleve) {
        this.sexeEleve = sexeEleve;
    }

    public LocalDate getDateNaisseEleve() {
        return dateNaisseEleve;
    }

    public void setDateNaisseEleve(LocalDate dateNaisseEleve) {
        this.dateNaisseEleve = dateNaisseEleve;
    }

    public String getCodePostalEleve() {
        return codePostalEleve;
    }

    public void setCodePostalEleve(String codePostalEleve) {
        this.codePostalEleve = codePostalEleve;
    }

    public String getVilleEleve() {
        return villeEleve;
    }

    public void setVilleEleve(String villeEleve) {
        this.villeEleve = villeEleve;
    }

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public HashMap<String, String> getAllInfoEleve(){
        HashMap<String, String> infoEleve = new HashMap<>();
        infoEleve.put("idEleve", String.valueOf(this.idEleve));
        infoEleve.put("nomEleve", this.nomEleve);
        infoEleve.put("prenomEleve", this.prenomEleve);
        infoEleve.put("adresseEleve", this.adresseEleve);
        infoEleve.put("telephoneEleve", this.telephoneEleve);
        infoEleve.put("sexeEleve", String.valueOf(this.sexeEleve));
        infoEleve.put("dateNaisseEleve", String.valueOf(this.dateNaisseEleve));
        infoEleve.put("codePostalEleve", this.codePostalEleve);
        infoEleve.put("villeEleve", this.villeEleve);
        infoEleve.put("numCompte", String.valueOf(this.numCompte));
        infoEleve.put("imgPdp", this.imgPdp);
        return infoEleve;
    }
}
