package sio.projetautoecole.services;

import sio.projetautoecole.models.Lecon;
import sio.projetautoecole.repositories.LeconRepository;
import sio.projetautoecole.repositories.VehiculeRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class LeconService {
    LeconRepository repo;
    public LeconService() {
        repo = new LeconRepository();
    }

    public ArrayList<Lecon> getAllLeconForEleve(int idEleve) throws SQLException {
        return repo.getAllLeconForEleve(idEleve);
    }

    public ArrayList<Lecon> getAllLeconForMoniteur(int idMoniteur) throws SQLException {
        return repo.getAllLeconForMoniteur(idMoniteur);
    }

    public ArrayList<Lecon> getAllLeconForVehicule(String immat) throws SQLException {
        return repo.getAllLeconForVehicule(immat);
    }
}
