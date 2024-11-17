package sio.projetautoecole.repositories;


import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.*;
import java.util.ArrayList;

public class EleveRepository {
    private Connection connection;
    public EleveRepository() {connection = ConnexionBDD.getCnx();}

    public Eleve getEleveByNumCompte(int numCompte) throws SQLException {
        Eleve eleve = null;
        PreparedStatement ps = connection.prepareStatement("Select CodeEleve, Nom, prenom, sexe, DateDeNaissance, Adresse1, CodePostal, Ville, Telephone, numCompte, imgPdp FROM eleve WHERE numCompte = ?");
        ps.setInt(1, numCompte);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int codeEleve = rs.getInt("codeEleve");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            int sexe = rs.getInt("sexe");
            Date dateDeNaissance = rs.getDate("DateDeNaissance");
            String addresse1 = rs.getString("Adresse1");
            String codePostal = rs.getString("CodePostal");
            String ville = rs.getString("Ville");
            String telephone = rs.getString("Telephone");
            int numCompte2 = rs.getInt("numCompte");
            String imgPdp = rs.getString("imgPdp");
            eleve = new Eleve(codeEleve, nom, prenom,addresse1,telephone, sexe,dateDeNaissance, codePostal, ville, numCompte2, imgPdp );
        }

        return eleve;

    }
}
