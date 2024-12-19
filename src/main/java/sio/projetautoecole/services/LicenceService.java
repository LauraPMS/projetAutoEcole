package sio.projetautoecole.services;

import sio.projetautoecole.repositories.LicenceRepository;

import java.sql.SQLException;

public class LicenceService {

    LicenceRepository repo;

    public LicenceService() {
        repo = new LicenceRepository();
    }

    public boolean get(int idMoniteur, int codeCateg) throws SQLException {
        return repo.get(idMoniteur, codeCateg);
    }
    public void add(int idMoniteur, int codeCateg) throws SQLException {
        repo.add(idMoniteur, codeCateg);
    }
}
