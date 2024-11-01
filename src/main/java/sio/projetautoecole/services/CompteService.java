package sio.projetautoecole.services;

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

    public int getNumComptes(String login) throws SQLException {
        return compteRepository.getNumCompteVerifie(login);
    }
    public int getUserByCompte(int numCompte) throws SQLException {
        return compteRepository.getUserByCompte(numCompte);
    }

    public int getStatutBynumCompte(int numCompte) throws SQLException {
        return compteRepository.getStatutBynumCompte(numCompte);
    }
}
