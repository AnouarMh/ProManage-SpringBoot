package tn.spring.springboot.service;


import tn.spring.springboot.entities.Projet;

import java.util.List;
import java.util.stream.DoubleStream;

public interface ProjetService {
    List<Projet> getallProjet();
    List<Projet> getProjetByNom(String Nom);
    List<Projet> getallProjetOrderbyName();
    Projet addProjet(Projet p);
    Projet updateProjet(Projet p);
    void deleteProjet(Long id);
    Projet getProjet(Long id);
    Boolean assignTachetoProjet(Long idTache,Long idProjet);
    float calculprixProjet(String NomProjet);


}
