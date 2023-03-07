package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.entities.Specialite;
import tn.spring.springboot.repository.ContratRepository;
import tn.spring.springboot.repository.EtudiantRepository;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;


@Service
@AllArgsConstructor
public class ContratServiceImpl implements IContratService {

    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat getContratById(Long id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public int countContratBySpecialite(Specialite specialite) {
        return contratRepository.countContratBySpecialite(specialite);
    }

    @Override
    public int countContractBySpeciality(Specialite specialite) {
        List<Contrat> liste = contratRepository.findAll();
        int a = 0;
        for (Contrat i : liste) {
            if (i.getSpecialite() == Specialite.IA) {
                a++;
            }
        }
        return a;
    }


    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void deleteContrat(Long id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant etudiant = etudiantRepository.findEtudiantByNomEAndPrenomE(nomE, prenomE);
        int CountContratValides = contratRepository.countByEtudiantIdEtudiantAndArchiveFalse(etudiant.getIdEtudiant());
        if (CountContratValides < 5) {
            ce.setEtudiant(etudiant);
            contratRepository.save(ce);
            etudiant.getContrats().add(ce);
            etudiantRepository.save(etudiant);
        }
        return ce;
    }

    @Override
    public int nbContratsValides(Date startDate, Date endDate) {
        return contratRepository.countByDateDebutContratAndDateFinContratAndArchiveFalse(startDate, endDate);
    }

    //1ere
    @Override
    public boolean EndDateIsNear(Long idContrat) {
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Date date = new Date();
        @Deprecated int md = date.getMonth();
        @Deprecated int mc = contrat.getDateFinContrat().getMonth();
        int dif = abs(md - mc);
        if ((mc - md == 0)) {
            return true;
        }
        return false;
    }


    //2eme
    //every day
    /*@Scheduled(fixedRate = 86400000)
    public void dateExpirationContrat() {
        List<Contrat> listOfContracts = contratRepository.findAll();
        for (Contrat i : listOfContracts) {
            Date dateFin = i.getDateFinContrat();
            Date dateOfToday = new Date();
            float year = 1;
            float month = 1;
            float day = 1;
            @Deprecated int yf = dateFin.getYear();
            @Deprecated int mf = dateFin.getMonth();
            @Deprecated int df = dateFin.getDay();
            @Deprecated int yt = dateOfToday.getYear();
            @Deprecated int mt = dateOfToday.getMonth();
            @Deprecated int dt = dateOfToday.getDay();
            if (yf > yt) {
                year = (yf - yt);
                System.out.println("Le contrat expire dans" + year + " ans");

            } else if ((yf == yt) && (mf > mt)) {
                month = (mf - mt);
                System.out.println("Le contrat expire dans" + month + " mois");
            } else if ((yf == yt) && (mf == mt) && (df > dt)) {
                day = (df - dt);
                System.out.println("Le contrat expire dans" + day + " jours");
            } else {
                System.out.println("Le contrat a expiré");
            }
        }
    }
*/
    //3eme
    @Override
    public List<Contrat> RechercheByDescription(String description) {
        return contratRepository.findContratByDescriptionContratContainingIgnoreCase(description);
    }

    //4eme
    @Override
    public List<Contrat> findContratByOrderByMontantContratDesc() {
        return contratRepository.findContratByOrderByMontantContratDesc();
    }

    //SORT ASC AND DESC
    @Override
    public List<Contrat> findContratByOrderByMontantContratAsc() {
        return contratRepository.findContratByOrderByMontantContratAsc();
    }

    @Override
    public List<Contrat> searchContract(String query) {
        return contratRepository.searchContract(query);
    }

    @Override
    public List<Contrat> findAllContractsWhichHaveSupAmount(int amount) {
        return contratRepository.findAllContractsWhichHaveSupAmount(amount);
    }

    @Override
    public Optional<Contrat> ViewContractMaxAmount() {
        List<Contrat> empList = contratRepository.findAll();
        Optional<Contrat> ContractMaxAmount= empList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Contrat::getMontantContrat)));
        return ContractMaxAmount;
    }

    @Override
    public Contrat addAndAffectContratToEtudiant(Contrat c, Long idEtud) {
        Etudiant e=etudiantRepository.findById(idEtud).orElse(null);
        c.setEtudiant(e);
        contratRepository.save(c);
        return c;
    }

}

