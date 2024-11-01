package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.services.EleveService;

import java.sql.SQLException;

public class EleveController {

    private EleveService eleveService;

    public EleveController() {
        eleveService = new EleveService();
    }

    public Eleve getEleveById(int id) throws SQLException{
        return eleveService.getEleveById(id);
    }
}
