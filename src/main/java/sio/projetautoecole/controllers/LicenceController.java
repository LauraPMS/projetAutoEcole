package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Lecon;
import sio.projetautoecole.repositories.LicenceRepository;
import sio.projetautoecole.services.LeconService;
import sio.projetautoecole.services.LicenceService;

import java.sql.SQLException;
import java.util.ArrayList;

public class LicenceController {

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
}
