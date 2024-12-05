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

    public ArrayList<String> getAllLibelles() throws SQLException {
        return categorieRepository.getAllLibelles();
    }
    public ArrayList<String> getAllPrixCategories() throws SQLException {
        return categorieRepository.getAllPrixCategories();
    }
    public String getNomCategorieById(String id) throws SQLException {
        return categorieRepository.getNomCategorieById(id);
    }
    public Categorie getCategorieFromLibelle (String libelle) throws SQLException {
        return categorieRepository.getCategorieFromLibelle(libelle);
    }

    public ArrayList<String> getAllMoniteursFromCategorie(Categorie c) throws SQLException {
        return categorieRepository.getAllMoniteursFromCategorie(c);
    }

    }
