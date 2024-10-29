package sio.projetautoecole.repositories;

import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;

public class EleveCategorieRepository {

    private Connection connection;
    public EleveCategorieRepository() {connection = ConnexionBDD.getCnx();}

}
