package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.services.EleveCategorieService;
import sio.projetautoecole.services.EleveService;

import java.sql.SQLException;
import java.util.ArrayList;

public class EleveCategorieController {

    private EleveCategorieService eleveCategorieService;

    public EleveCategorieController() {
        eleveCategorieService = new EleveCategorieService();
    }

    public ArrayList<Integer> getEleveCategorie(Eleve e) throws SQLException {
        return eleveCategorieService.getEleveCategorie(e);
    }
}
