package sio.projetautoecole.repositories;

import sio.projetautoecole.controllers.CategorieController;
import sio.projetautoecole.controllers.VehiculeController;
import sio.projetautoecole.models.Lecon;
import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LeconRepository {
    private Connection connection;
    public VehiculeController vehiculeController;
    private CategorieController categorieController;

    
    public LeconRepository() {
        connection = ConnexionBDD.getCnx();

        vehiculeController = new VehiculeController();
        categorieController = new CategorieController();
    }

    public ArrayList<Lecon> getAllLeconForEleve(int idEleve) throws SQLException {
        ArrayList<Lecon> lecons = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT codeLecon, date, heure, codeMoniteur, CodeEleve, Immatriculation, Reglee FROM Lecon WHERE codeEleve = ?");
        ps.setInt(1, idEleve);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String immat = rs.getString("Immatriculation");
            String codeCategorie = String.valueOf(vehiculeController.getCategorieByImmatriculation(immat));
            System.out.println(codeCategorie);
            String nomCategorie = categorieController.getNomCategorieById(codeCategorie);
            Lecon l = new Lecon(rs.getInt("codeLecon"), rs.getDate("date"), rs.getString("heure"), rs.getInt("codeMoniteur"), rs.getInt("codeEleve"), rs.getString("Immatriculation"), rs.getInt("Reglee"), nomCategorie);
            lecons.add(l);
        }
        return lecons;
    }

    public ArrayList<Lecon> getAllLeconForMoniteur(int idMoniteur) throws SQLException {
        ArrayList<Lecon> lecons = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT codeLecon, date, heure, codeMoniteur, CodeEleve, Immatriculation, Reglee FROM Lecon WHERE codeMoniteur = ?");
        ps.setInt(1, idMoniteur);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String immat = rs.getString("Immatriculation");
            String codeCategorie = String.valueOf(vehiculeController.getCategorieByImmatriculation(immat));
            String nomCategorie = categorieController.getNomCategorieById(codeCategorie);
            Lecon l = new Lecon(rs.getInt("codeLecon"), rs.getDate("date"), rs.getString("heure"), rs.getInt("codeMoniteur"), rs.getInt("codeEleve"), rs.getString("Immatriculation"), rs.getInt("Reglee"), nomCategorie );
            lecons.add(l);
        }
        return lecons;
    }

    public ArrayList<Lecon> getAllLeconForVehicule(String immat) throws SQLException {
        ArrayList<Lecon> lecons = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT codeLecon, date, heure, codeMoniteur, CodeEleve, Immatriculation, Reglee FROM Lecon WHERE immatriculation = ?");
        ps.setString(1, immat);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String immatriculation = rs.getString("Immatriculation");
            String codeCategorie = String.valueOf(vehiculeController.getCategorieByImmatriculation(immatriculation));
            System.out.println(codeCategorie);
            String nomCategorie = categorieController.getNomCategorieById(codeCategorie);
            Lecon l = new Lecon(rs.getInt("codeLecon"), rs.getDate("date"), rs.getString("heure"), rs.getInt("codeMoniteur"), rs.getInt("codeEleve"), rs.getString("Immatriculation"), rs.getInt("Reglee"), nomCategorie);
            lecons.add(l);
        }
        return lecons;
    }
}
