package sio.projetautoecole.repositories;

import sio.projetautoecole.Session;
import sio.projetautoecole.models.Compte;
import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompteRepository {

    private Connection connection;

    public int numCompteActif ;

    public CompteRepository() {connection = ConnexionBDD.getCnx();}


    // fonction utilisé au moment de la connexion pour vérifier si le login et le mot de passe correspondent bien.
    public boolean verifCompte(String login, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT numCompte from compte where login =? and motDePasse = ?;");
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            // On met a jour le numéro du compte actif
            setNumCompteActif(resultSet.getInt("numCompte"));
            return true;
        }
        return false;
    }



    public int getStatutBynumCompte() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT statut from compte where numCompte = ?;");
        preparedStatement.setInt(1, numCompteActif);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("statut");
        }
        return 0;
    }



    public int getNumCompteActif() throws SQLException {
        return numCompteActif;
    }

    public void setNumCompteActif(int numCompte) throws SQLException {
        numCompteActif = numCompte;
    }

    public Compte getCompteByNumCompte(int numCompte) throws SQLException {
        Compte compte = null;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT numCompte, login, motDePasse, statut from compte where numCompte = ?;");
        preparedStatement.setInt(1, numCompte);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            compte = new Compte(rs.getInt("numCompte"), rs.getString("login"), rs.getString("motDePasse"), rs.getInt("statut"));
            return compte;
        }
        return null;
    }

    public void inscription(String login, String mdp, int statut) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO compte(login, motDePasse, statut) VALUES (?, ?, ?);");
        ps.setString(1, login);
        ps.setString(2, mdp);
        ps.setInt(3, statut);
        ps.executeUpdate();
    }

    public int getNumCompte(String login, String mdp) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT numCompte FROM compte where login = ? and motdepasse = ?;");
        ps.setString(1, login);
        ps.setString(2, mdp);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("numCompte");
        }
        return 0;

    }

    public boolean loginAlreadyExist(String login) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT login FROM compte WHERE login = ?;");
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return true;
        }
        return false;
    }
}
