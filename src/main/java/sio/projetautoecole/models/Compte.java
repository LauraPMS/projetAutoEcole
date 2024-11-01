package sio.projetautoecole.models;

public class Compte {

    private int numCompte;
    private String login;
    private String mdp;
    private int statut;

    public Compte(int numCompte, String login, String mdp, int statut) {
        this.numCompte = numCompte;
        this.login = login;
        this.mdp = mdp;
        this.statut = statut;
    }


    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

}
