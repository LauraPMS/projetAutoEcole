package sio.projetautoecole.repositories;

import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;

public class LeconRepository {
    private Connection connection;
    public LeconRepository() {
        connection = ConnexionBDD.getCnx();
    }
}
