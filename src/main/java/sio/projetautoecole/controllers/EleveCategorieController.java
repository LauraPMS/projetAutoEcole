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

    public ArrayList<String> getEleveCategorie(Eleve e) throws SQLException {
        return eleveCategorieService.getEleveCategorie(e);
    }

    public ArrayList<String> getTotalHeureByPermisEleve(Eleve e, int codeCategorie) throws SQLException {
        return eleveCategorieService.getTotalHeureByPermisEleve(e, codeCategorie);
    }

    public ArrayList<String> getVehiculePermisEleve(Eleve e, int codeCategorie) throws SQLException {
        return eleveCategorieService.getVehiculPermisEleve(e, codeCategorie);
    }
}
