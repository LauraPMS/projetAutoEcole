package sio.projetautoecole.services;

import sio.projetautoecole.repositories.EleveCategorieRepository;

import java.sql.SQLException;

public class EleveCategorieService {

    private EleveCategorieRepository eleveCategorieRepository;

    public EleveCategorieService() {
        eleveCategorieRepository = new EleveCategorieRepository();
    }
    public boolean get(int idEleve, int codeCateg) throws SQLException {
        return eleveCategorieRepository.get(idEleve, codeCateg);
    }

    public void add(int idEleve, int codeCateg) throws SQLException {
        eleveCategorieRepository.add(idEleve,codeCateg);
    }
}
