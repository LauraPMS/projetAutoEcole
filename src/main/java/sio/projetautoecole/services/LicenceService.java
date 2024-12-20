package sio.projetautoecole.services;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
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
=======
import sio.projetautoecole.repositories.LicenceRepository;

import java.sql.SQLException;

public class LicenceService {

<<<<<<< HEAD
=======
import sio.projetautoecole.repositories.LicenceRepository;

import java.sql.SQLException;

public class LicenceService {

>>>>>>> branche-laura
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
    LicenceRepository repo;

    public LicenceService() {
        repo = new LicenceRepository();
    }

    public boolean get(int idMoniteur, int codeCateg) throws SQLException {
        return repo.get(idMoniteur, codeCateg);
    }
    public void add(int idMoniteur, int codeCateg) throws SQLException {
        repo.add(idMoniteur, codeCateg);
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> branche-laura
=======
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
>>>>>>> branche-laura
    }
}
