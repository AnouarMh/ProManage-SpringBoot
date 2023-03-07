package tn.spring.springboot.service;

import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.entities.Specialite;


import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IContratService {
    List<Contrat> getAllContrat();
    Contrat addContrat(Contrat contrat);
    Contrat updateContrat(Contrat contrat);
    void deleteContrat (Long id);
    Contrat affectContratToEtudiant (Contrat ce,String nomE, String prenomE);
    int nbContratsValides(Date startDate, Date endDate);
    Contrat getContratById(Long id);

    int countContratBySpecialite(Specialite specialite);
    public int countContractBySpeciality(Specialite specialite);
    public boolean EndDateIsNear(Long idContrat);

    List<Contrat> RechercheByDescription(String description);
    List<Contrat> findContratByOrderByMontantContratDesc();

    List<Contrat> findContratByOrderByMontantContratAsc();

    List<Contrat> searchContract(String query);

    List<Contrat> findAllContractsWhichHaveSupAmount(int amount);

    public Optional<Contrat> ViewContractMaxAmount();

    public Contrat addAndAffectContratToEtudiant(Contrat c, Long idEtud);

}
