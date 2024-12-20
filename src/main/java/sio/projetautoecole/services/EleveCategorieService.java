package sio.projetautoecole.services;

<<<<<<< HEAD
import sio.projetautoecole.models.Categorie;
import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.EleveCategorie;
import sio.projetautoecole.repositories.EleveCategorieRepository;
import sio.projetautoecole.repositories.EleveRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EleveCategorieService {
=======
import sio.projetautoecole.repositories.EleveCategorieRepository;

import java.sql.SQLException;

public class EleveCategorieService {

>>>>>>> branche-laura
    private EleveCategorieRepository eleveCategorieRepository;

    public EleveCategorieService() {
        eleveCategorieRepository = new EleveCategorieRepository();
    }
<<<<<<< HEAD

    public ArrayList<String> getEleveCategorie(Eleve e) throws SQLException {
        return eleveCategorieRepository.getEleveCategorie(e);
    }

    public ArrayList<String> getTotalHeureByPermisEleve(Eleve e, int codeCategorie) throws SQLException {
        return eleveCategorieRepository.getTotalHeureByPermisEleve(e, codeCategorie);
    }
    public ArrayList<String> getVehiculPermisEleve(Eleve e, int codeCategorie) throws SQLException {
        return eleveCategorieRepository.getVehiculesByPermis(e, codeCategorie);
=======
    public boolean get(int idEleve, int codeCateg) throws SQLException {
        return eleveCategorieRepository.get(idEleve, codeCateg);
    }

    public void add(int idEleve, int codeCateg) throws SQLException {
        eleveCategorieRepository.add(idEleve,codeCateg);
>>>>>>> branche-laura
    }
}
