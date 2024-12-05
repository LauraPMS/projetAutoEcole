package sio.projetautoecole.repositories;

import sio.projetautoecole.models.Categorie;
import sio.projetautoecole.models.Moniteur;
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
        PreparedStatement preparedStatement = connection.prepareStatement("Select libelle from categorie;");
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

    public String getNomCategorieById(String id) throws SQLException {
        String nomCategorie = "";
        switch (id) {
            case "1":
                nomCategorie = "Automobile";
                break;
            case "2":
                nomCategorie = "Poids Lourd";
                break;
            case "3":
                nomCategorie = "Bateau";
                break;
            case "4" :
                nomCategorie = "Moto";
                break;
            case "5":
                nomCategorie = "Transport en Commun";
        }
        return nomCategorie;
    }

    public Categorie getCategorieFromLibelle (String libelle) throws SQLException {
        Categorie categorie = null;
        PreparedStatement preparedStatement = connection.prepareStatement("Select codeCategorie, Libelle, Prix from categorie where libelle = ?;");
        preparedStatement.setString(1, libelle);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            categorie = new Categorie(resultSet.getInt("codeCategorie"), resultSet.getString("Libelle"), resultSet.getFloat("Prix"));
            return categorie;
        }
        return categorie;
    }

    public ArrayList<String> getAllMoniteursFromCategorie(Categorie c) throws SQLException {
        ArrayList<String> moniteurs = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("Select moniteur.nom from moniteur where codeMoniteur in (Select codeMoniteur from licence where codeCategorie = ?);");
        ps.setInt(1, c.getIdCategorie());
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            moniteurs.add(resultSet.getString("nom"));
        }
        return moniteurs;
    }

}
