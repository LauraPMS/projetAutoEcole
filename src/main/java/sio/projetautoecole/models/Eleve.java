package sio.projetautoecole.models;

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

    public Eleve(int idEleve, String nomEleve, String prenomEleve, String adresseEleve, String telephoneEleve, int sexeEleve, Date dateNaisseEleve, String codePostalEleve, String villeEleve) {
        this.idEleve = idEleve;
        this.nomEleve = nomEleve;
        this.prenomEleve = prenomEleve;
        this.adresseEleve = adresseEleve;
        this.telephoneEleve = telephoneEleve;
        this.sexeEleve = sexeEleve;
        this.dateNaisseEleve = dateNaisseEleve;
        this.codePostalEleve = codePostalEleve;
        this.villeEleve = villeEleve;
    }
}
