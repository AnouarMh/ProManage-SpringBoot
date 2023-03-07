package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.entities.Specialite;
import tn.spring.springboot.service.IContratService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ContratController {

    IContratService contratService;

    @GetMapping("/getallcontrat")
    public List<Contrat> getAllContrat() {
        return contratService.getAllContrat();
    }

    @PostMapping("/addcontrat")
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    @PutMapping("/updatecontrat")
    public Contrat updateContrat(@RequestBody Contrat contrat) {
        return contratService.updateContrat(contrat);
    }

    @DeleteMapping("deleteContrat/{id}")
    public void deleteContrat(@PathVariable("id") Long id) {
        contratService.deleteContrat(id);
    }

    @PostMapping("/affectContratToEtudiant/{nome}/{prenome}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce, @PathVariable("nome") String nomE, @PathVariable("prenome") String prenomE) {
        return contratService.affectContratToEtudiant(ce, nomE, prenomE);
    }

    @GetMapping("/nbContratsValides/{SD}/{ED}")
    public int nbContratsValides(@PathVariable("SD") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @PathVariable("ED") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return contratService.nbContratsValides(startDate, endDate);
    }

    @GetMapping("/getContrat/{idContrat}")
    private Contrat getContratById(@PathVariable("idContrat") Long idContrat) {
        return contratService.getContratById(idContrat);
    }

    @GetMapping("/getContractByOption/{specialite}")
    public int countContractBySpeciality(@PathVariable("specialite") Specialite specialite) {
        return contratService.countContratBySpecialite(specialite);
    }
    //added
    @GetMapping("/DateContractIsNear/{idContrat}")
    public boolean EndDateIsNear(@PathVariable("idContrat") Long idContrat) {
        return contratService.EndDateIsNear(idContrat);
    }

    @GetMapping("/contrat/{description}")
    List<Contrat> RechercheByDescription(@PathVariable("description") String description) {
        return contratService.RechercheByDescription(description);
    }

    @GetMapping("/contrat/sortDesc")
    List<Contrat> sortDescContrat() {
        return contratService.findContratByOrderByMontantContratDesc();
    }

    @GetMapping("/contrat/sortAsc")
    List<Contrat> sortAscContrat() {
        return contratService.findContratByOrderByMontantContratAsc();
    }

    @GetMapping("/Searchcontrat")
    List<Contrat> searchContract(@RequestParam("query") String query) {
        return contratService.searchContract(query);
    }

    @GetMapping("/SearchPlusAmountcontracts")

    public List<Contrat> findAllContractsWhichHaveSup300Amount(@RequestParam("amount") int amount) {
        return contratService.findAllContractsWhichHaveSupAmount(amount);
    }


    @GetMapping("/SearchMaxAmountContract")
    public Optional<Contrat> ViewContractMaxAmount() {
        return contratService.ViewContractMaxAmount();
    }

    @PostMapping("/addcontratAndAffectIt/{idEtud}")
    public Contrat addAndAffectContratToEtudiant(@RequestBody Contrat c,@PathVariable("idEtud") Long idEtud) {
        return contratService.addAndAffectContratToEtudiant(c,idEtud);
    }
}
