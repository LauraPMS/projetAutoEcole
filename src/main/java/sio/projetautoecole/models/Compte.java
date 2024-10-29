package sio.projetautoecole.models;

public class Compte {

    private int numCompte;
    private int login;
    private int mdp;
    private int statut;

    public Compte(int numCompte, int login, int mdp, int statut) {
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

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public int getMdp() {
        return mdp;
    }

    public void setMdp(int mdp) {
        this.mdp = mdp;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

}
