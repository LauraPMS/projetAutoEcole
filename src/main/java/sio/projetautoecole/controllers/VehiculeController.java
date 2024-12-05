package sio.projetautoecole.controllers;

import sio.projetautoecole.services.VehiculeService;

import java.sql.SQLException;

public class VehiculeController {
    private VehiculeService vehiculeService;
    public VehiculeController() {
        vehiculeService = new VehiculeService();
    }

    public int getCategorieByImmatriculation(String immatriculation) throws SQLException {
        return vehiculeService.getCategorieByImmatriculation(immatriculation);
    }
}
