package tn.spring.springboot.service;

import tn.spring.springboot.entities.Tache;

import java.util.List;

public interface TacheService {
    List<Tache> getallTache();
    Tache addTache(Tache t);
    Tache updateTache(Tache t);
    void deleteTache(Long id);
    Tache getTache(Long id);
    void affectTachetoProjet(String nomT,String nomP);
    List<Tache> getNomstachebyNomProjet(String NomProjet);
    List<Tache> TrieTacheASC() ;
    List<Tache> TrieTacheDESC();
}
