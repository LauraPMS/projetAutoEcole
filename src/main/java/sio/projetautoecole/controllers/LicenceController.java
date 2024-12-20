package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Lecon;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.services.EleveCategorieService;
=======
import sio.projetautoecole.repositories.LicenceRepository;
>>>>>>> branche-laura
<<<<<<< HEAD
=======
import sio.projetautoecole.repositories.LicenceRepository;
>>>>>>> branche-laura
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
import sio.projetautoecole.services.LeconService;
import sio.projetautoecole.services.LicenceService;

import java.sql.SQLException;
import java.util.ArrayList;

public class LicenceController {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
    private LicenceService licenceService;

    public LicenceController() {
        licenceService = new LicenceService();
    }

    public ArrayList<Integer> getMoniteurLicence(Moniteur moniteur) throws SQLException {
        return licenceService.getMoniteurLicence(moniteur);
    }

=======
<<<<<<< HEAD
=======
>>>>>>> branche-laura
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
    LicenceService service;

    public LicenceController() {
        service = new LicenceService();
    }

    public boolean get(int idMoniteur, int codeCateg) throws SQLException {
        return service.get(idMoniteur, codeCateg);
    }
    public void add(int idMoniteur, int codeCateg) throws SQLException {
        service.add(idMoniteur, codeCateg);
    }
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> branche-laura
=======
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
>>>>>>> branche-laura
}
