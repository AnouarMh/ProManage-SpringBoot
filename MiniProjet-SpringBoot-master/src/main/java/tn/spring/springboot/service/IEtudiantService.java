package tn.spring.springboot.service;

import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.entities.Option;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> getAllEtudiant();
    Etudiant addEtudiant(Etudiant e);
    Etudiant updateEtudiant(Etudiant e);
    void deleteEtudiant (Long id);
    Etudiant getEtudiantById(Long id);
    Etudiant findEtudiantByPrenomE(String prenom);
    public void assignEtudianttoDepartement(Long idEtudiant,Long idDepartement);
    List<Etudiant> retrieveEtudiantByEquipeThematique ( String thematique);
    void updateEtudiantByOption(Option op , Long idEtudiant);
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat,
                                                     Long idEquipe);
    List<Etudiant> getEtudiantsByDepartement(Long idDepartement);
    public Etudiant addEtudiantAnsAssignToAccount(Etudiant e,String userName);


}
