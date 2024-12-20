package sio.projetautoecole.controllers;

<<<<<<< HEAD
<<<<<<< HEAD
import sio.projetautoecole.models.Eleve;
=======
>>>>>>> branche-laura
=======
>>>>>>> branche-laura
import sio.projetautoecole.services.EleveCategorieService;
import sio.projetautoecole.services.EleveService;

import java.sql.SQLException;
<<<<<<< HEAD
<<<<<<< HEAD
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
=======

public class EleveCategorieController {

=======

public class EleveCategorieController {

>>>>>>> branche-laura
    private EleveCategorieService service;

    public EleveCategorieController() {
        service = new EleveCategorieService();
    }

    public boolean get(int idEleve, int codeCateg) throws SQLException {
        return service.get(idEleve, codeCateg);
    }

    public void add(int idEleve, int codeCateg) throws SQLException {
        service.add(idEleve, codeCateg);
<<<<<<< HEAD
>>>>>>> branche-laura
=======
>>>>>>> branche-laura
    }
}
