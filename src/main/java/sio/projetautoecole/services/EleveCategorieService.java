package sio.projetautoecole.services;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
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
<<<<<<< HEAD
=======
import sio.projetautoecole.repositories.EleveCategorieRepository;

import java.sql.SQLException;

public class EleveCategorieService {

>>>>>>> branche-laura
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
    private EleveCategorieRepository eleveCategorieRepository;

    public EleveCategorieService() {
        eleveCategorieRepository = new EleveCategorieRepository();
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71

    public ArrayList<String> getEleveCategorie(Eleve e) throws SQLException {
        return eleveCategorieRepository.getEleveCategorie(e);
    }

    public ArrayList<String> getTotalHeureByPermisEleve(Eleve e, int codeCategorie) throws SQLException {
        return eleveCategorieRepository.getTotalHeureByPermisEleve(e, codeCategorie);
    }
    public ArrayList<String> getVehiculPermisEleve(Eleve e, int codeCategorie) throws SQLException {
        return eleveCategorieRepository.getVehiculesByPermis(e, codeCategorie);
=======
<<<<<<< HEAD
=======
>>>>>>> branche-laura
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
    public boolean get(int idEleve, int codeCateg) throws SQLException {
        return eleveCategorieRepository.get(idEleve, codeCateg);
    }

    public void add(int idEleve, int codeCateg) throws SQLException {
        eleveCategorieRepository.add(idEleve,codeCateg);
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> branche-laura
=======
=======
>>>>>>> b554254c2c9edbd75db32f5ca492d4148db88d71
>>>>>>> branche-laura
    }
}
