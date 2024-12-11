package sio.projetautoecole.repositories;


import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.*;
import java.time.LocalDate;
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
            LocalDate date = rs.getDate("DateDeNaissance").toLocalDate();
            String adresse1 = rs.getString("Adresse1");
            String codePostal = rs.getString("CodePostal");
            String ville = rs.getString("Ville");
            String telephone = rs.getString("Telephone");
            int numCompte2 = rs.getInt("numCompte");
            String imgPdp = rs.getString("imgPdp");
            eleve = new Eleve(codeEleve, nom, prenom,adresse1,telephone, sexe,date, codePostal, ville, numCompte2, imgPdp );
        }

        return eleve;

    }

    public void inscription(Eleve eleve) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("Insert into eleve(codeEleve, nom,prenom, sexe, DateDeNaissance, adresse1, CodePostal, Ville, Telephone, numCompte, imgpdp) values(?,?,?,?,?,?,?,?,?,?,' ')");
        ps.setInt(1, eleve.getIdEleve());
        ps.setString(2, eleve.getNomEleve());
        ps.setString(3, eleve.getPrenomEleve());
        ps.setInt(4, eleve.getSexeEleve());
        ps.setDate(5, Date.valueOf(eleve.getDateNaisseEleve()));
        ps.setString(6, eleve.getAdresseEleve());
        ps.setString(7, eleve.getCodePostalEleve());
        ps.setString(8, eleve.getVilleEleve());
        ps.setString(9, eleve.getTelephoneEleve());
        ps.setInt(10, eleve.getNumCompte());
        ps.executeUpdate();
    }

    public void updateEleve(Eleve e) throws SQLException {
        PreparedStatement ps;
        ps = connection.prepareStatement("Update eleve SET eleve.Ville = ?, eleve.CodePostal = ?, eleve.Telephone = ? " +
                "WHERE numCompte = ?");
        ps.setString(1, e.getVilleEleve());
        ps.setString(2, e.getCodePostalEleve());
        ps.setString(3, e.getTelephoneEleve());
        ps.setInt(4, e.getNumCompte());
        ps.executeUpdate();

    }

}
