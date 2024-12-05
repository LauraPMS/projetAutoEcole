package sio.projetautoecole.services;

import sio.projetautoecole.repositories.CategorieRepository;
import sio.projetautoecole.repositories.VehiculeRepository;

import java.sql.SQLException;

public class VehiculeService {
    private VehiculeRepository vehiculeRepository;

    public VehiculeService ()
    {
        vehiculeRepository = new VehiculeRepository();
    }

    public int getCategorieByImmatriculation(String immatriculation) throws SQLException {
        return vehiculeRepository.getCategorieByImmatriculation(immatriculation);
    }
}
