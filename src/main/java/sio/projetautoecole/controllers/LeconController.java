package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Lecon;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.services.LeconService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

    public List<LocalTime> getHorairesReserves(Moniteur moniteur, LocalDate selectedDate) throws SQLException {
        return service.getHorairesReserves(moniteur, selectedDate);
    }

    public List<String> getAvailableVehicles(String date, String heure, int idCateg) throws SQLException {
        return service.getAvailableVehicles(date, heure, idCateg);
    }

    public void add(Lecon l) throws SQLException {
        service.add(l);
    }
}
