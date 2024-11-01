package sio.projetautoecole.repositories;


import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EleveRepository {
    private Connection connection;
    public EleveRepository() {connection = ConnexionBDD.getCnx();}

    public Eleve getEleveById(int id) throws SQLException {
        Eleve eleve = new Eleve();
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from eleve where codeEleve = ?;");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            eleve.setIdEleve(resultSet.getInt(1));
            eleve.setNomEleve(resultSet.getString(2));
            eleve.setPrenomEleve(resultSet.getString(3));
            eleve.setSexeEleve(resultSet.getInt(4));
            eleve.setDateNaisseEleve(resultSet.getDate(5));
            eleve.setAdresseEleve(resultSet.getString(6));
            eleve.setCodePostalEleve(resultSet.getString(7));
            eleve.setVilleEleve(resultSet.getString(8));
            eleve.setTelephoneEleve(resultSet.getString(9));
            eleve.setNumCompte(resultSet.getInt(10));
        }
        return eleve;
    }
}
