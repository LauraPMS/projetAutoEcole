package sio.projetautoecole.repositories;

import sio.projetautoecole.models.Categorie;
import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategorieRepository {
    private Connection connection;
    public CategorieRepository() {connection = ConnexionBDD.getCnx();}

    // Toutes les méthodes ou l'on utilise catégories seulement

    public ArrayList<Categorie> getAllCategories() throws SQLException {

        ArrayList<Categorie> categories = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("Select codeCategorie, libelle, prix from categorie;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            categories.add(new Categorie(resultSet.getInt("codeCategorie"), resultSet.getString("libelle"), resultSet.getFloat("prix") ));
        }

        return categories;
    }

    public ArrayList<String> getAllLibelles() throws SQLException {
        ArrayList<String> libelles = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("Select libelle from libelle;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            libelles.add(resultSet.getString("libelle"));
        }
        return libelles;
    }

    public ArrayList<String> getAllPrixCategories() throws SQLException {
        ArrayList<String> prixCategories = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("Select prix from categorie where libelle = ?;");
        preparedStatement.setString(1, getAllLibelles().get(0));
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            prixCategories.add(resultSet.getString("prix"));
        }
        return prixCategories;
    }

}
