package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Lecon;
import sio.projetautoecole.services.LeconService;

import java.sql.SQLException;
import java.util.ArrayList;

public class LeconController {

    LeconService service;
    public LeconController() {
        service = new LeconService();
    }

    public ArrayList<Lecon> getAllLeconForEleve(int idEleve) throws SQLException {
        return service.getAllLeconForEleve(idEleve);
    }

    public ArrayList<Lecon> getAllLeconForMoniteur(int idMoniteur) throws SQLException {
        return service.getAllLeconForMoniteur(idMoniteur);
    }

    public ArrayList<Lecon> getAllLeconForVehicule(String immat) throws SQLException {
        return service.getAllLeconForVehicule(immat);
    }
}
