package sio.projetautoecole.repositories;

import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoniteurRepository {
    private Connection connection;

    public MoniteurRepository() {
        connection = ConnexionBDD.getCnx();
    }

    public Moniteur getMoniteurByNumCompte(int numCompte) throws SQLException {
        Moniteur moniteur = null;
        PreparedStatement ps = connection.prepareStatement("Select CodeMoniteur, Nom, prenom, sexe, DateDeNaissance, Adresse1, CodePostal, Ville, Telephone, numCompte, imgPdp FROM moniteur WHERE numCompte = ?");
        ps.setInt(1, numCompte);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int codeMoniteur = rs.getInt("codeMoniteur");
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
            moniteur = new Moniteur(codeMoniteur, nom, prenom,addresse1, sexe, dateDeNaissance.toLocalDate(), codePostal, ville, telephone, imgPdp, numCompte2);
        }

        return moniteur;

    }

    public void updateMoniteur(Moniteur m) throws SQLException {
        PreparedStatement ps;
        ps = connection.prepareStatement("Update moniteur SET moniteur.Ville = ?, moniteur.CodePostal = ?, moniteur.Telephone = ? " +
                "WHERE numCompte = ?");
        ps.setString(1, m.getVilleMoniteur());
        ps.setString(2, m.getCodePostal());
        ps.setString(3, m.getTelephoneMoniteur());
        ps.setInt(4, m.getNumCompte());
        ps.executeUpdate();

    }


    public void inscription(Moniteur m) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("Insert into moniteur(codeMoniteur, nom,prenom, sexe, DateDeNaissance, adresse1, CodePostal, Ville, Telephone, numCompte, imgPdp) values(?,?,?,?,?,?,?,?,?,?,' ');");
        ps.setInt(1, m.getIdMoniteur());
        ps.setString(2, m.getNomMoniteur());
        ps.setString(3, m.getPrenomMoniteur());
        ps.setInt(4, m.getSexeMoniteur());
        ps.setDate(5, Date.valueOf(m.getDateMoniteur()));
        ps.setString(6, m.getAdresseMoniteur());
        ps.setString(7, m.getCodePostal());
        ps.setString(8, m.getVilleMoniteur());
        ps.setString(9, m.getTelephoneMoniteur());
        ps.setInt(10, m.getNumCompte());
        ps.executeUpdate();
    }

    public Moniteur getMoniteurByName(String selectedMoniteur) throws SQLException {
        Moniteur m = null;
        PreparedStatement ps = connection.prepareStatement("SELECT codeMoniteur, nom, prenom, sexe, DateDeNaissance, adresse1, CodePostal, Ville, Telephone, numCompte, imgPdp FROM Moniteur WHERE nom = ?");
        ps.setString(1, selectedMoniteur);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

            int codeMoniteur = rs.getInt("codeMoniteur");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            int sexe = rs.getInt("sexe");
            Date dateDeNaissance = rs.getDate("DateDeNaissance");
            String addresse1 = rs.getString("Adresse1");
            String codePostal = rs.getString("CodePostal");
            String ville = rs.getString("Ville");
            String telephone = rs.getString("Telephone");
            int numCompte = rs.getInt("numCompte");
            String imgPdp = rs.getString("imgPdp");
            m = new Moniteur(codeMoniteur,nom ,prenom ,addresse1 , sexe, dateDeNaissance.toLocalDate(),codePostal ,ville , telephone, imgPdp, numCompte );
        }
        return m;

    }


    public List<Moniteur> getAvailableMoniteurs(String date, String heure, int idCateg) throws SQLException {
        List<Moniteur> moniteurs = new ArrayList<>();
        String query = "SELECT DISTINCT m.codeMoniteur, m.nom, m.prenom, m.sexe, m.DateDeNaissance, m.adresse1, m.CodePostal, m.Ville, m.Telephone, m.numCompte, m.imgPdp " +
                "FROM moniteur m " +
                "WHERE m.codeMoniteur NOT IN ( " +
                "    SELECT l.codeMoniteur " +
                "    FROM lecon l " +
                "    JOIN vehicule v ON l.immatriculation = v.immatriculation " +
                "    WHERE l.date = ? AND l.heure = ? AND v.codeCategorie = ? " +
                ") " +
                "AND m.codeMoniteur IN ( " +
                "    SELECT l.codeMoniteur " +
                "    FROM vehicule v " +
                "    JOIN lecon l ON v.immatriculation = l.immatriculation " +
                "    WHERE v.codeCategorie = ? " +
                ");";
        try (PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, date);
            ps.setString(2, heure);
            ps.setInt(3, idCateg);
            ps.setInt(4, idCateg);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Moniteur moniteur = new Moniteur(
                        rs.getInt("codeMoniteur"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("Adresse1"),
                        rs.getInt("sexe"),
                        rs.getDate("DateDeNaissance").toLocalDate(),
                        rs.getString("CodePostal"),
                        rs.getString("Ville"),
                        rs.getString("Telephone"),
                        rs.getString("imgPdp"),
                        rs.getInt("numCompte")
                );
                moniteurs.add(moniteur);
            }
        }
        return moniteurs;
    }

}
