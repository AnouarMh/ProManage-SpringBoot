package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.spring.springboot.entities.Departement;
import tn.spring.springboot.entities.Option;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Long> {



    @Query("SELECT  departement FROM Departement  departement  , Etudiant e where departement.idDepartement=e.departement.idDepartement and e.options = :op")
    List<Departement> retrieveDepartementByOptionEtudiant(@Param("op") Option op);


}
