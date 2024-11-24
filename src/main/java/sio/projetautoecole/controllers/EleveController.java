package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.services.EleveService;

import java.sql.SQLException;

public class EleveController {

    private EleveService eleveService;

    public EleveController() {
        eleveService = new EleveService();
    }

    public Eleve getEleveByNumCompte(int numCompte) throws SQLException {
        return eleveService.getEleveByNumCompte(numCompte);
    }

    public void inscription(Eleve eleve) throws SQLException {
        eleveService.inscription(eleve);
    }
}
