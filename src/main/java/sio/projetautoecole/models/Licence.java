package sio.projetautoecole.models;

import java.sql.Date;

public class Licence {
    private int idLicence;
    private Moniteur moniteur;
    private Categorie categorie;
    private Date dateObtention;

    public Licence(int idLicence, Moniteur moniteur, Categorie categorie, Date dateObtention) {
        this.idLicence = idLicence;
        this.moniteur = moniteur;
        this.categorie = categorie;
        this.dateObtention = dateObtention;
    }
}
