package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.entities.Specialite;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Long> {
    int countByEtudiantIdEtudiantAndArchiveFalse(Long id);
    int countByDateDebutContratAndDateFinContratAndArchiveFalse(Date startDate, Date endDate);
    int countContratBySpecialite(Specialite specialite);

    //added
    List<Contrat> findContratByDescriptionContratContainingIgnoreCase(String description);

    List<Contrat> findContratByOrderByMontantContratDesc();

    List<Contrat> findContratByOrderByMontantContratAsc();


    @Query("SELECT p FROM Contrat p WHERE " +
            "p.descriptionContrat LIKE CONCAT('%',:query, '%')")
    List<Contrat> searchContract(String query);


    @Query("SELECT u FROM Contrat u WHERE u.montantContrat > :amount")
    List<Contrat> findAllContractsWhichHaveSupAmount(int amount);
}
