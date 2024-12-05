package sio.projetautoecole.repositories;

import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehiculeRepository {

    private Connection connection;
    public VehiculeRepository() {
        connection = ConnexionBDD.getCnx();
    }

    // récupérer la catégorie du véhicule a partir de son immatriculation (sert pour les lecçons)
    public int getCategorieByImmatriculation(String immatriculation) throws SQLException {

        PreparedStatement ps = connection.prepareStatement("Select codeCategorie from vehicule where immatriculation = ?");
        ps.setString(1,immatriculation);
        ResultSet rs = ps.executeQuery();

        if(rs.next()){

            int codeCat =  rs.getInt("codeCategorie");
            return codeCat;

        }
        return 0;
    }

}
