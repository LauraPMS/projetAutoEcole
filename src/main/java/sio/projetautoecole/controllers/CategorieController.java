package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Categorie;
import sio.projetautoecole.services.CategorieService;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategorieController {

    CategorieService categorieService = new CategorieService();

    public CategorieController()
    {
        categorieService = new CategorieService();
    }

    public ArrayList<Categorie> getAllCategories() throws SQLException {
        return categorieService.getAllCategories();
    }

}
