package sio.projetautoecole.repositories;

import sio.projetautoecole.controllers.CategorieController;
import sio.projetautoecole.controllers.VehiculeController;
import sio.projetautoecole.models.Lecon;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


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

    public List<LocalTime> getHorairesReserves(Moniteur moniteur, LocalDate date) throws SQLException {
        String query = "SELECT heure FROM Lecon WHERE idMoniteur = ? AND date = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, moniteur.getIdMoniteur());
            stmt.setDate(2, Date.valueOf(date));
            ResultSet rs = stmt.executeQuery();

            List<LocalTime> horaires = new ArrayList<>();
            while (rs.next()) {
                horaires.add(rs.getTime("heure").toLocalTime());
            }
            return horaires;
        }
    }

}
