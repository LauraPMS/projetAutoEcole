package sio.projetautoecole.models;

import java.sql.Date;

public class Lecon {
    private String lecon;
    private String couleur;
    private Date date;
    private String heure;
    private Moniteur moniteur;
    private Eleve eleve;
    private Vehicule vehicule;
    private boolean reglee;

    public Lecon(String lecon, String couleur, Date date, String heure, Moniteur moniteur, Eleve eleve, Vehicule vehicule, boolean reglee) {
        this.lecon = lecon;
        this.couleur = couleur;
        this.date = date;
        this.heure = heure;
        this.moniteur = moniteur;
        this.eleve = eleve;
        this.vehicule = vehicule;
        this.reglee = reglee;
    }
}
