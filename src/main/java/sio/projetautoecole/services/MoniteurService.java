package sio.projetautoecole.services;

import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.repositories.MoniteurRepository;

import java.sql.SQLException;
import java.util.List;

public class MoniteurService {

    MoniteurRepository repo ;
    public MoniteurService() {
        repo = new MoniteurRepository();
    }

    public Moniteur getMoniteurByNumCompte(int numCompte) throws SQLException{
        return repo.getMoniteurByNumCompte(numCompte);
    }

    public void updateMoniteur(Moniteur m) throws SQLException{
        repo.updateMoniteur(m);
    }

    public void inscription(Moniteur m) throws SQLException{
        repo.inscription(m);
    }

    public Moniteur getMoniteurByName(String selectedMoniteur) throws SQLException {
        return repo.getMoniteurByName(selectedMoniteur);
    }

    public List<Moniteur> getAvailableMoniteurs(String date, String heure, int idCateg) throws SQLException {
        return repo.getAvailableMoniteurs(date, heure, idCateg);
    }
}
