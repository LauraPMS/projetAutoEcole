package sio.projetautoecole.repositories;

import sio.projetautoecole.models.Categorie;
import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EleveCategorieRepository {

    private Connection connection;

    public EleveCategorieRepository() {connection = ConnexionBDD.getCnx();}

    public ArrayList<Integer> getEleveCategorie(Eleve e) throws SQLException {
        ArrayList<Integer> categorie = new ArrayList<>();
        PreparedStatement ps;
        ps = connection.prepareStatement("Select distinct(eleve_categorie.codeCategorie) From eleve_categorie Where CodeEleve = ?;");
        ps.setInt(1, e.getIdEleve());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            categorie.add(rs.getInt("CodeCategorie"));
        }

        return categorie;
    }

}
