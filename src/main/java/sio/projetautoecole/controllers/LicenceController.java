package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Lecon;
<<<<<<< HEAD
<<<<<<< HEAD
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.services.EleveCategorieService;
=======
import sio.projetautoecole.repositories.LicenceRepository;
>>>>>>> branche-laura
=======
import sio.projetautoecole.repositories.LicenceRepository;
>>>>>>> branche-laura
import sio.projetautoecole.services.LeconService;
import sio.projetautoecole.services.LicenceService;

import java.sql.SQLException;
import java.util.ArrayList;

public class LicenceController {

<<<<<<< HEAD
<<<<<<< HEAD
    private LicenceService licenceService;

    public LicenceController() {
        licenceService = new LicenceService();
    }

    public ArrayList<Integer> getMoniteurLicence(Moniteur moniteur) throws SQLException {
        return licenceService.getMoniteurLicence(moniteur);
    }

=======
=======
>>>>>>> branche-laura
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
>>>>>>> branche-laura
=======
>>>>>>> branche-laura
}
