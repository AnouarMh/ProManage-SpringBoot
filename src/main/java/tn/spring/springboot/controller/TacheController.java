package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.spring.springboot.entities.Tache;
import tn.spring.springboot.service.TacheServiceImpl;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/Tache")
public class TacheController {
    TacheServiceImpl tacheService;

    //getallTaches
    @GetMapping("/getallTaches")
    public List<Tache> getallTaches() {
        return tacheService.getallTache();
    }

    //Add new Tache
    @PostMapping("/addTache")
    public void addnewTache(@RequestBody Tache tache) {
        tacheService.addTache(tache);
    }

    //Update contrat
    @PutMapping("/updateTache/{idTache}")
    public void updateTache(@PathVariable("idTache") Long idTache, @RequestBody Tache t) {
        t.setIdTache(idTache);
        tacheService.updateTache(t);
    }

    @PutMapping("/updateTache")
    public Tache modifierProjet(@RequestBody Tache t) {
        return tacheService.updateTache(t);
    }

    //Delete Contrat
    @DeleteMapping("/deleteTache/{idTache}")
    public void deleteContrat(@PathVariable("idTache") Long idTache) {
        tacheService.deleteTache(idTache);
    }

    //get Tache
    @GetMapping("/getTache/{idTache}")
    public Tache getTache(@PathVariable("idTache") Long idTache) {
        return tacheService.getTache(idTache);
    }

    @PostMapping("/affectTtoProjet/{nomT}/{nomP}")
    public void affectTtoP(@PathVariable("nomT") String nomT, @PathVariable("nomP") String nomP) {
        tacheService.affectTachetoProjet(nomT, nomP);
    }
    @GetMapping("/getTacheByProjet/{nomProjet}")
    public List Gettache(@PathVariable("nomProjet")String nomProjet){
        return tacheService.getNomstachebyNomProjet(nomProjet);
    }
    @GetMapping("/retrieve-tacheASC")
    public List <Tache> retrieveTacheASC() {
        return tacheService.TrieTacheASC();  }

    @GetMapping("/retrieve-tacheDESC")
    public List <Tache> retrieveTacheDESC() {
        return tacheService.TrieTacheDESC();

    }
}
