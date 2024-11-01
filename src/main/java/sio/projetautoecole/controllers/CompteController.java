package sio.projetautoecole.controllers;

import sio.projetautoecole.services.CompteService;

import java.sql.SQLException;

public class CompteController {
    private CompteService compteService = new CompteService();

    public CompteController() {
        compteService = new CompteService();
    }

    // Permet de vérifier s'il existe un compte associé au couple login mot de passe
    public boolean verifCompte(String login, String password) throws SQLException {
        return compteService.verifCompte(login, password);
    }


    // Donne le numCompte associé au login
    public int getnumCompte(String login) throws SQLException {
        return compteService.getNumComptes(login);
    }


    // Donne le code Eleve ou Moniteur associé au numCompte
    public int getUserByCompte(int numCompte) throws SQLException {
        return compteService.getUserByCompte(numCompte);
    }

    // Donne le statut du compte
    public int getStatutBynumCompte(int numCompte) throws SQLException {
        return compteService.getStatutBynumCompte(numCompte);
    }
}
