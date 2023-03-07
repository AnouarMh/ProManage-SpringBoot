package tn.spring.springboot.service;

import tn.spring.springboot.entities.Departement;
import tn.spring.springboot.entities.Option;


import java.util.List;
import java.util.Set;

public interface IDepartementService {
    List<Departement> retrieveAllDepartement();
    Departement getdepbyid(long id);

    Departement addDepartement(Departement departement);

    Departement updateDepartement(Departement D);


    void deleteDepartement(Long id);

    Departement retrieveDepartement(Long id);

    Departement addAndAssignDepartToUniv(Departement d, Long idUniversite);
    Departement addAndAssignDepartToUniversite(Departement dep, Long idUniversite);

    List<Departement> retrieveDepartementByOptionEtudiant(Option op);

    List<String> getNomsdepartbyidUniv(String  nomUniv);
    List<Departement> saveDepartement(List<Departement> departement);

}
