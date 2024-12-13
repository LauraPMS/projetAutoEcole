package sio.projetautoecole.repositories;

import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EleveCategorieRepository {

    private Connection connection;
    public EleveCategorieRepository() {connection = ConnexionBDD.getCnx();}

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
}
