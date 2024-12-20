package sio.projetautoecole.repositories;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> branche-laura

public class LicenceRepository {

    private Connection connection;

    public LicenceRepository() {
        connection = ConnexionBDD.getCnx();
    }

<<<<<<< HEAD
    public ArrayList<Integer> getMoniteurLicence(Moniteur moniteur) throws SQLException {
        ArrayList<Integer> categorie = new ArrayList<>();
        PreparedStatement ps;
        ps = connection.prepareStatement("Select distinct(licence.codeCategorie) From licence Where CodeMoniteur = ?;");
        ps.setInt(1, moniteur.getIdMoniteur());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            categorie.add(rs.getInt("CodeCategorie"));
        }

        return categorie;
    }
=======
    public boolean get(int idMoniteur, int codeCateg) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "SELECT codeLicence FROM licence WHERE codeMoniteur = ? AND codeCategorie = ?"
        );
        ps.setInt(1, idMoniteur);
        ps.setInt(2, codeCateg);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

            return true;
        }
        return false;
    }


    public void add(int idMoniteur, int codeCateg) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO licence (codeMoniteur, codeCategorie) VALUES (?, ?)");
        ps.setInt(1, idMoniteur);
        ps.setInt(2, codeCateg);
        ps.executeUpdate();
    }

>>>>>>> branche-laura
}
