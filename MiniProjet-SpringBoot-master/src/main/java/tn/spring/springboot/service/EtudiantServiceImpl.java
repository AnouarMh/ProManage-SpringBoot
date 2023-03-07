package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.*;
import tn.spring.springboot.repository.*;

import javax.transaction.Transactional;
import java.util.List;

@Service //cree une instance de ce service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService{

    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository;
    ContratRepository contratRepository;
    EquipeRepository equipeRepository;
    AccountRepository accountRepository;
    @Override
    public List<Etudiant> getAllEtudiant() {

        return etudiantRepository.findAll() ;
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {

        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {

        return etudiantRepository.save(e);
    }

    @Override
    public void deleteEtudiant(Long id) {

        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant getEtudiantById(Long id) {

        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public Etudiant findEtudiantByPrenomE(String prenom) {
        return etudiantRepository.findEtudiantByPrenomE(prenom);
    }

    @Override
    public void assignEtudianttoDepartement(Long idEtudiant, Long idDepartement) {
        Etudiant etudiant= this.etudiantRepository.findById(idEtudiant).orElse(null);
        Departement departement= this.departementRepository.findById(idDepartement).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> retrieveEtudiantByEquipeThematique(String thematique) {
        return etudiantRepository.retrieveEtudiantByEquipeThematique(thematique);
    }

    @Override
    public void updateEtudiantByOption(Option op, Long idEtudiant) {
        etudiantRepository.updateEtudiantByOption(op, idEtudiant);
    }

    @Override
    @Transactional //on va toucher plus q'une table fl BD
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat, Long idEquipe) {
        Contrat contrat=contratRepository.findById(idContrat).orElse(null);
        Equipe equipe=equipeRepository.findById(idEquipe).orElse(null);

           // etudiantRepository.save(e);
          //  e.getEquipes().add(equipe);
           // e.getContrats().add(contrat);
            contrat.setEtudiant(e);
            equipe.getEtudiants().add(e);
           // contratRepository.save(contrat);
        return  etudiantRepository.save(e);
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Long idDepartement) {
        return etudiantRepository.findEtudiantByDepartementIdDepartement(idDepartement);
    }

    @Override
    public Etudiant addEtudiantAnsAssignToAccount(Etudiant e, String userName) {
        Account account=accountRepository.findById(userName).orElse(null);
        e.setAccount(account);
        return etudiantRepository.save(e);
    }

   /* @Scheduled(fixedRate = 6000)
    public void fixedRateMethod(){
        System.out.println("Method with fixed Rate");
    }*/
}
