package sio.projetautoecole.services;

import sio.projetautoecole.models.Categorie;
import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.EleveCategorie;
import sio.projetautoecole.repositories.EleveCategorieRepository;
import sio.projetautoecole.repositories.EleveRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class EleveCategorieService {
    private EleveCategorieRepository eleveCategorieRepository;

    public EleveCategorieService() {
        eleveCategorieRepository = new EleveCategorieRepository();
    }

    public ArrayList<Integer> getEleveCategorie(Eleve e) throws SQLException {
        return eleveCategorieRepository.getEleveCategorie(e);
    }
}
