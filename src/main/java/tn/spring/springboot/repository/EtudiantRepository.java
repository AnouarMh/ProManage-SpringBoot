package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.entities.Option;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findEtudiantByPrenomE(String prenom);
    Etudiant findEtudiantByNomEAndPrenomE(String nomE,String prenomE);
    @Query("SELECT etudiant from Etudiant etudiant inner join etudiant.equipes equipe inner join " +
            "DetailEquipe detail on detail.equipe=equipe.idEquipe where detail.thematique=:thematique")
    List<Etudiant> retrieveEtudiantByEquipeThematique ( String thematique);
    @Modifying
    @Transactional
    @Query("update Etudiant e set e.options=:op where e.idEtudiant=:idEtudiant ")
    void updateEtudiantByOption(Option op , Long idEtudiant);

    List<Etudiant> findEtudiantByDepartementIdDepartement(Long idDepartement);



}
