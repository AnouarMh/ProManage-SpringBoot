package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.spring.springboot.entities.Tache;

import java.util.List;

public interface TacheRepositry extends JpaRepository<Tache,Long> {
    Tache findByLibelle(String libelle);
    @Query("SELECT tache FROM Tache tache,Projet projet inner JOIN projet.taches d ON d.idTache=tache.idTache and projet.nomProjet=:nomProjet  ")
    List retrievenomTacheBynomProjet(@Param("nomProjet") String nomProjet);

    @Query("SELECT t FROM Tache t ORDER BY t.prixTache ASC ")

    List<Tache> TrieTachesASC();



    @Query("SELECT t FROM Tache t ORDER BY t.prixTache DESC ")

    List<Tache> TrieTachesDESC();
}
