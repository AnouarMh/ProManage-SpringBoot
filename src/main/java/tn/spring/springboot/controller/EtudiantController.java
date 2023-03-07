package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Etudiant;
import tn.spring.springboot.entities.Option;
import tn.spring.springboot.service.IEtudiantService;

import java.util.List;


@RestController
@AllArgsConstructor
public class EtudiantController {


    IEtudiantService etudiantService;

    @GetMapping("/getalletudiant")

    public List<Etudiant> getAllEtudiant(){
        return etudiantService.getAllEtudiant();
    }

    @PostMapping("/addetudiant")
    @PreAuthorize("hasRole('User')")
    public Etudiant addEtudiant(@RequestBody Etudiant e){
        return etudiantService.addEtudiant(e);
    }


    @DeleteMapping("/deleteE/{idEtudiant}")
    @PreAuthorize("hasRole('User')")
    private void deleteEtudiant(@PathVariable("idEtudiant") Long idEtudiant){
         etudiantService.deleteEtudiant(idEtudiant);
    }

    @PutMapping("/updateE")
    @PreAuthorize("hasRole('User')")
    private Etudiant updateE(@RequestBody Etudiant e){
        return etudiantService.updateEtudiant(e);
    }


    //@PreAuthorize("hasRole('User')")
    @GetMapping("/getE/{idEtudiant}")
    private Etudiant getEtuById(@PathVariable("idEtudiant") Long idEtudiant){
        System.out.println(idEtudiant);
        return etudiantService.getEtudiantById(idEtudiant);
    }

    @GetMapping("/findetudiantByP/{prenom}")
    public Etudiant findEtudiantByPrenomE(@PathVariable("prenom") String prenom){
        return etudiantService.findEtudiantByPrenomE(prenom);
    }

    @PostMapping("/assignEtudToDepart/{idEtudiant}/{idDepart}")
    public void assignEtudianttoDepartement(@PathVariable("idEtudiant") Long idEtudiant,@PathVariable("idDepart") Long idDepartement){
        etudiantService.assignEtudianttoDepartement(idEtudiant,idDepartement);
    }

    @GetMapping("retrieveEtudiantByEquipeThematique/{thematique}")
    public List<Etudiant> retrieveEtudiantByEquipeThematique ( @PathVariable("thematique") String thematique){
        return etudiantService.retrieveEtudiantByEquipeThematique(thematique);
    }

    @PutMapping("/updateEtudiantByOption/{op}/{idEtudiant}")
    public void updateEtudiantByOption(@PathVariable("op") Option op,@PathVariable("idEtudiant") Long idEtudiant){
        etudiantService.updateEtudiantByOption(op, idEtudiant);
    }

    @PostMapping("/addAndAssignEtudiantToEquipeAndContract/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable("idContrat") Long idContrat,@PathVariable("idEquipe") Long idEquipe){
        Etudiant etudiant= etudiantService.addAndAssignEtudiantToEquipeAndContract(e, idContrat, idEquipe);
        return etudiant;
    }

    @GetMapping("/getEtudiantsByDepartement/{idDepart}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable("idDepart") Long idDepartement){
        return etudiantService.getEtudiantsByDepartement(idDepartement);
    }

    @PostMapping("/assigntoaccount/{userName}")
    @PreAuthorize("hasRole('User')")
    public Etudiant addEtudiantAnsAssignToAccount(@RequestBody Etudiant e,@PathVariable String userName){
        return etudiantService.addEtudiantAnsAssignToAccount(e,userName);
    }
}
