package sio.projetautoecole.services;

import sio.projetautoecole.models.Categorie;
import sio.projetautoecole.repositories.CategorieRepository;
import sio.projetautoecole.tools.ConnexionBDD;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategorieService {

    private CategorieRepository categorieRepository;

    public CategorieService()
    {
        categorieRepository = new CategorieRepository();
    }

    public ArrayList<Categorie> getAllCategories() throws SQLException {
        return categorieRepository.getAllCategories();
    }
}
