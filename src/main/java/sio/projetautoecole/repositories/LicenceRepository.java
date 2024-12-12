package sio.projetautoecole.repositories;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LicenceRepository {

    private Connection connection;

    public LicenceRepository() {
        connection = ConnexionBDD.getCnx();
    }

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
}
