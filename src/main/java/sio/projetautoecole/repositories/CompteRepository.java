package sio.projetautoecole.repositories;

import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompteRepository {

    private Connection connection;
    public CompteRepository() {connection = ConnexionBDD.getCnx();}

    public boolean verifCompte(String login, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT numCompte from compte where login =? and motDePasse = ?;");
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return true;
        }
        return false;
    }

    public int getNumCompteVerifie(String login) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT numCompte from compte where login =?");
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }



    public int getStatutBynumCompte(int numCompte) throws SQLException {
        int statut = 0;
        PreparedStatement preparedStatement = connection.prepareStatement("Select statut from compte where numCompte = ?");
        preparedStatement.setInt(1, numCompte);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            statut = resultSet.getInt(1);
        }
        return statut;
    }


    // fonction permettant de récupérer le codeEleve ou codeMoniteur compte associé en fonction du statut;
    public int getUserByCompte(int numCompte) throws SQLException {

        int code = 0;
        // on récupère le statut a partir du compte ayant pour id numCompte
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT statut FROM compte Where numCompte = ?;");
        preparedStatement.setInt(1, numCompte);
        ResultSet resultSet = preparedStatement.executeQuery();
        // si le compte existe (normalement on vérifie dans le HelloController avant mais mesure de sécurité)
        if (resultSet.next()) {

            if (resultSet.getString("statut").equals(0)) {
                // si le statut est = a 0 alors cela signifie que c'est un Eleve
                PreparedStatement recupereCompteEleve = connection.prepareStatement("SELECT CodeEleve FROM eleve WHERE numCompte = ?;");
                recupereCompteEleve.setInt(1, numCompte);
                ResultSet resultSetEleve = recupereCompteEleve.executeQuery();
                if (resultSetEleve.next()) {
                    code = resultSetEleve.getInt("CodeEleve");
                }
            }
            else {
                // sinon c'est un compte moniteur
                PreparedStatement recupereCompteMoniteur = connection.prepareStatement("SELECT codeMoniteur FROM moniteur WHERE numCompte = ?;");
                recupereCompteMoniteur.setInt(1, numCompte);
                ResultSet resultSetMoniteur = recupereCompteMoniteur.executeQuery();
                if (resultSetMoniteur.next()) {
                    code = resultSetMoniteur.getInt("CodeMoniteur");
                }
            }
        }
        return code ;
    }

}
