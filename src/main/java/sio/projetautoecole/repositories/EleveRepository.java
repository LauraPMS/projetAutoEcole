package sio.projetautoecole.repositories;

import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;

public class EleveRepository {
    private Connection connection;
    public EleveRepository() {connection = ConnexionBDD.getCnx();}
}
