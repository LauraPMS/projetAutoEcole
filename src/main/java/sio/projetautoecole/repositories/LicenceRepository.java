package sio.projetautoecole.repositories;

import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;

public class LicenceRepository {
    private Connection connection;
    public LicenceRepository() {
        connection = ConnexionBDD.getCnx();
    }
}
