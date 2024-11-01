package sio.projetautoecole.models;

import java.util.ArrayList;
import java.util.Date;

public class Eleve {
    private int idEleve;
    private String nomEleve;
    private String prenomEleve;
    private String adresseEleve;
    private String telephoneEleve;
    private int sexeEleve;
    private Date dateNaisseEleve;
    private String codePostalEleve;
    private String villeEleve;
    private int numCompte;


    public Eleve() {

    }
    public Eleve(int idEleve, String nomEleve, String prenomEleve, String adresseEleve, String telephoneEleve, int sexeEleve, Date dateNaisseEleve, String codePostalEleve, String villeEleve, int numCompte) {
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

    public Date getDateNaisseEleve() {
        return dateNaisseEleve;
    }

    public void setDateNaisseEleve(Date dateNaisseEleve) {
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

    public ArrayList<String> ElevetoString(){
        ArrayList<String> ElevetoString = new ArrayList<>();
        ElevetoString.add(Integer.toString(this.idEleve));
        ElevetoString.add(this.nomEleve);
        ElevetoString.add(this.prenomEleve);
        ElevetoString.add(Integer.toString(this.sexeEleve));

        return ElevetoString;
    }
}
