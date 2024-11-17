package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Compte;
import sio.projetautoecole.services.CompteService;

import java.sql.SQLException;

public class CompteController {
    private CompteService compteService;

    public CompteController() {
        compteService = new CompteService();
    }

    // Permet de vérifier s'il existe un compte associé au couple login mot de passe
    public boolean verifCompte(String login, String password) throws SQLException {
        return compteService.verifCompte(login, password);
    }

    // Donne le statut du compte
    public int getStatutBynumCompte() throws SQLException {
        return compteService.getStatutBynumCompte();
    }

    public int getNumCompteActif() throws SQLException {
        return compteService.getNumCompteActif();
    }

    public void setNumCompteActif(int numCompteActif) throws SQLException {
        compteService.setNumCompteActif(numCompteActif);
    }

    public Compte getCompteByNumCompte(int numCompte) throws SQLException{
        return compteService.getCompteByNumCompte(numCompte);
    }
}
