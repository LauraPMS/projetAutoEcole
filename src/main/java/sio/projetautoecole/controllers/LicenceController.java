package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Lecon;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.services.EleveCategorieService;
import sio.projetautoecole.services.LeconService;
import sio.projetautoecole.services.LicenceService;

import java.sql.SQLException;
import java.util.ArrayList;

public class LicenceController {

    private LicenceService licenceService;

    public LicenceController() {
        licenceService = new LicenceService();
    }

    public ArrayList<Integer> getMoniteurLicence(Moniteur moniteur) throws SQLException {
        return licenceService.getMoniteurLicence(moniteur);
    }

}
