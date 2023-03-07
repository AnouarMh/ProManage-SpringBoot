package tn.spring.springboot.service;

import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Niveau;


import java.util.List;

public interface IEquipeService {
    List<Equipe> getAllEquipe();
    Equipe addEquipe(Equipe e);
    Equipe updateEquipe(Equipe e);
    void deleteEquipe (Long id);
    List<Equipe> findByEtudiantsIdEtudiant(Long idEtudiant);
    List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idetdudiant,Long idDepart);
    List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau , String thematique);
    void deleteEquipeByNiveau( Niveau niveau);
}
