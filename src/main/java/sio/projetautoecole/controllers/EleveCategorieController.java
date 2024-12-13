package sio.projetautoecole.controllers;

import sio.projetautoecole.services.EleveCategorieService;
import sio.projetautoecole.services.EleveService;

import java.sql.SQLException;

public class EleveCategorieController {

    private EleveCategorieService service;

    public EleveCategorieController() {
        service = new EleveCategorieService();
    }

    public boolean get(int idEleve, int codeCateg) throws SQLException {
        return service.get(idEleve, codeCateg);
    }

    public void add(int idEleve, int codeCateg) throws SQLException {
        service.add(idEleve, codeCateg);
    }
}
