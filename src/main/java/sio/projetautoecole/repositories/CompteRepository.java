package sio.projetautoecole.repositories;

import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;

public class CompteRepository {

    private Connection connection;
    public CompteRepository() {connection = ConnexionBDD.getCnx();}
}
