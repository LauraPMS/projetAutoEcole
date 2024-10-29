package sio.projetautoecole.repositories;

import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;

public class MoniteurRepository {
    private Connection connection;
    public MoniteurRepository() {
        connection = ConnexionBDD.getCnx();
    }
}
