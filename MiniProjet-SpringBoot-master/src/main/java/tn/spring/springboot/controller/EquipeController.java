package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Niveau;
import tn.spring.springboot.service.IEquipeService;

import java.util.List;

@RestController
@AllArgsConstructor
public class EquipeController {

    IEquipeService equipeService;

    @GetMapping("/getAllEquipe")
    public List<Equipe> getAllEquipe(){
        return equipeService.getAllEquipe();
    }

    @PostMapping("/addEquipe")
    public Equipe addEquipe(@RequestBody Equipe e) {
        return equipeService.addEquipe(e);
    }

    @PutMapping("/updateEquipe")
    public Equipe updateEquipe(@RequestBody Equipe e){
        return equipeService.updateEquipe(e);
    }

    @DeleteMapping("/deleteEquipe/{id}")
    public void deleteEquipe(@PathVariable("id") Long id){
        equipeService.deleteEquipe(id);
    }

    @GetMapping("/findbyidE/{idEtudiant}")
    public List<Equipe> findByEtudiantsIdEtudiant(@PathVariable("idEtudiant") Long idEtudiant){
        return equipeService.findByEtudiantsIdEtudiant(idEtudiant);
    }

    @GetMapping("/findby/{idetudiant}/{idDepart}")
    public List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(@PathVariable("idetudiant") Long idetdudiant,@PathVariable("idDepart") Long idDepart){
        return equipeService.findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idetdudiant,idDepart);
    }

    @GetMapping("/retrieveEqbyNiveauAndThematique/{niveau}/{thematique}")
    public List<Equipe> retriveEquipeByNiveauAndThematique(@PathVariable("niveau") Niveau niveau,@PathVariable("thematique") String thematique){
        return equipeService.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }

    @DeleteMapping("/deleteEquipeByNiveau/{niveau}")
    public void deleteEquipeByNiveau(@PathVariable("niveau") Niveau niveau){
        equipeService.deleteEquipeByNiveau(niveau);
    }

}
