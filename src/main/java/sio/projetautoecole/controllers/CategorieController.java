package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Categorie;
import sio.projetautoecole.services.CategorieService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategorieController {

    CategorieService categorieService = new CategorieService();

    public CategorieController()
    {
        categorieService = new CategorieService();
    }

    public ArrayList<Categorie> getAllCategories() throws SQLException {
        return categorieService.getAllCategories();
    }

    public ArrayList<String> getAllLibelles() throws SQLException {
        return categorieService.getAllLibelles();
    }
    public ArrayList<String> getAllPrixCategories() throws SQLException {
        return categorieService.getAllPrixCategories();
    }
    public String getNomCategorieById(String id) throws SQLException {
        return categorieService.getNomCategorieById(id);
    }

    public Categorie getCategorieFromLibelle (String libelle) throws SQLException {
        return categorieService.getCategorieFromLibelle(libelle);
    }

    public ArrayList<String> getAllMoniteursFromCategorie(Categorie c) throws SQLException {
        return categorieService.getAllMoniteursFromCategorie(c);
    }
    public List<String> getVehiclesForCategory(String categoryName) throws SQLException {
        return categorieService.getVehiclesForCategory(categoryName);
    }
    }
