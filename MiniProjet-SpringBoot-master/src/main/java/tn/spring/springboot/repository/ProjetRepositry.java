package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import tn.spring.springboot.entities.Projet;
import tn.spring.springboot.entities.Tache;

import java.util.List;

public interface ProjetRepositry extends JpaRepository<Projet,Long> {
    @Query("SELECT tache FROM Tache tache,Projet p inner join p.taches t on t.idTache=tache.idTache and p.nomProjet=:nomProjet")
    List<Tache>retrieveTachebyNomProjet(@Param("nomProjet")String nomProjet);
    Projet findProjetByNomProjet(String NomProjet);

}
