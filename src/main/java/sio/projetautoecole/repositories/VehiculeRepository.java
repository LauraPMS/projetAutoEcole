package sio.projetautoecole.repositories;

import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;

public class VehiculeRepository {
    private Connection connection;
    public VehiculeRepository() {
        connection = ConnexionBDD.getCnx();
    }
}
