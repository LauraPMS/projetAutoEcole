package sio.projetautoecole.repositories;

import sio.projetautoecole.models.Categorie;
import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
<<<<<<< HEAD
import java.time.LocalDate;
import java.util.ArrayList;
=======
>>>>>>> branche-laura
=======
>>>>>>> branche-laura

public class EleveCategorieRepository {

    private Connection connection;

    public EleveCategorieRepository() {connection = ConnexionBDD.getCnx();}

<<<<<<< HEAD
<<<<<<< HEAD
    public ArrayList<String> getEleveCategorie(Eleve e) throws SQLException {
        ArrayList<String> libelleCategorie = new ArrayList<>();
        PreparedStatement ps;
        ps = connection.prepareStatement("Select categorie.libelle from categorie where codeCategorie in (Select distinct(eleve_categorie.codeCategorie) From eleve_categorie Where CodeEleve = ?);");
        ps.setInt(1, e.getIdEleve());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            libelleCategorie.add(rs.getString("libelle"));
        }

        return libelleCategorie;
    }

    public ArrayList<String> getTotalHeureByPermisEleve(Eleve e, int codeCategorie) throws SQLException {
        ArrayList<String> totalHeure = new ArrayList<>();
        PreparedStatement ps;
        ps = connection.prepareStatement("Select heure from lecon where Immatriculation in (Select Immatriculation From vehicule Where CodeCategorie = ?) AND codeELeve = ?;");
        ps.setInt(1, codeCategorie);
        ps.setInt(2, e.getIdEleve());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            totalHeure.add(rs.getString("heure"));
        }
        return totalHeure;
    }

    public ArrayList<String> getVehiculesByPermis(Eleve e, int codeCategorie) throws SQLException {
        ArrayList<String> vehiculesPermisEleve = new ArrayList<>();
        PreparedStatement ps;
        ps = connection.prepareStatement("Select DISTINCT(Modele) from vehicule JOIN lecon on lecon.Immatriculation = vehicule.Immatriculation where vehicule.Immatriculation in (Select Immatriculation From vehicule Where CodeCategorie = ?) AND codeEleve = ?;");
        ps.setInt(1, codeCategorie);
        ps.setInt(2, e.getIdEleve());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            vehiculesPermisEleve.add(rs.getString("Modele"));
        }
        return vehiculesPermisEleve;
    }

=======
=======
>>>>>>> branche-laura
    public boolean get(int idEleve, int codeCateg) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "SELECT id FROM eleve_categorie WHERE codeEleve = ? AND codeCategorie = ?"
        );
        ps.setInt(1, idEleve);
        ps.setInt(2, codeCateg);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) { // Vérifie si un résultat existe
            System.out.println("c'est ok");
            return true;
        }
        return false;
    }


    public void add(int idEleve, int codeCateg) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO eleve_categorie (codeEleve, codeCategorie) VALUES (?, ?)");
        ps.setInt(1, idEleve);
        ps.setInt(2, codeCateg);
        ps.executeUpdate();
    }
<<<<<<< HEAD
>>>>>>> branche-laura
=======
>>>>>>> branche-laura
}
