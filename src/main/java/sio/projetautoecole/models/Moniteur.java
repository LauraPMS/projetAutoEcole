package sio.projetautoecole.models;

import java.util.Date;

public class Moniteur {
    private int idMoniteur;
    private String nomMoniteur;
    private String prenomMoniteur;
    private String adresseMoniteur;
    private int sexeMoniteur;
    private Date dateMoniteur;
    private String codePostal;
    private String villeMoniteur;
    private String telephoneMoniteur;

    public Moniteur(int idMoniteur, String nomMoniteur, String prenomMoniteur, String adresseMoniteur, int sexeMoniteur, Date dateMoniteur, String codePostal, String villeMoniteur, String telephoneMoniteur) {
        this.idMoniteur = idMoniteur;
        this.nomMoniteur = nomMoniteur;
        this.prenomMoniteur = prenomMoniteur;
        this.adresseMoniteur = adresseMoniteur;
        this.sexeMoniteur = sexeMoniteur;
        this.dateMoniteur = dateMoniteur;
        this.codePostal = codePostal;
        this.villeMoniteur = villeMoniteur;
        this.telephoneMoniteur = telephoneMoniteur;
    }
}
