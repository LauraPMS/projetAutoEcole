package sio.projetautoecole.services;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.repositories.EleveCategorieRepository;
import sio.projetautoecole.repositories.LicenceRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class LicenceService {

    private LicenceRepository licenceRepository;

    public LicenceService() {
        licenceRepository = new LicenceRepository();
    }

    public ArrayList<Integer> getMoniteurLicence(Moniteur moniteur) throws SQLException {
        return licenceRepository.getMoniteurLicence(moniteur);
    }
}
