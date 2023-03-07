package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Niveau;

import javax.transaction.Transactional;
import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {
    List<Equipe> findByEtudiantsIdEtudiant(Long idEtudiant);
    List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepartement(Long idetdudiant,Long idDepart);
    @Query("select e from Equipe e inner join DetailEquipe d on d.equipe= e.idEquipe where d.thematique=:thematique " +
            "and e.niveau=:niveau")
    List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau , String thematique);
    @Modifying
    @Transactional
    @Query("delete FROM Equipe e where e.niveau=:niveau")
    void deleteEquipeByNiveau( Niveau niveau);
}
