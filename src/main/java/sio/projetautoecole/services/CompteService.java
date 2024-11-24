package sio.projetautoecole.services;

import sio.projetautoecole.models.Compte;
import sio.projetautoecole.repositories.CompteRepository;

import java.sql.SQLException;

public class CompteService {

    private CompteRepository compteRepository;
    public CompteService() {
        compteRepository = new CompteRepository();
    }

    public boolean verifCompte(String login, String password) throws SQLException {
        return compteRepository.verifCompte(login, password);
    }

    public int getStatutBynumCompte() throws SQLException {
        return compteRepository.getStatutBynumCompte();
    }

    public int getNumCompteActif() throws SQLException {
        return compteRepository.getNumCompteActif();
    }

    public void setNumCompteActif(int numCompteActif) throws SQLException {
        compteRepository.setNumCompteActif(numCompteActif);
    }
    public Compte getCompteByNumCompte(int numCompte) throws SQLException{
        return compteRepository.getCompteByNumCompte(numCompte);
    }

    public void inscription(String login, String mdp, int statut) throws SQLException {
        compteRepository.inscription(login, mdp, statut);
    }

    public int getNumeroCompte(String login, String mdp) throws SQLException {
        return compteRepository.getNumCompte(login, mdp);
    }

    public boolean loginAlreadyExist(String login) throws SQLException {
        return compteRepository.loginAlreadyExist(login);
    }
}
