package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import tn.spring.springboot.entities.Projet;
import tn.spring.springboot.service.ProjetServiceImpl;


import java.util.List;
import java.util.stream.DoubleStream;




@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/Projet")
public class ProjetController {
    ProjetServiceImpl projetService;
    //getallProjets
    @GetMapping("/getallProjets")
    public List<Projet> getallTaches(){
        return projetService.getallProjetOrderbyName();
    }
    //Add new Projet
    @PostMapping("/addProjet")
    public void addnewProjet(@RequestBody Projet projet){
        projetService.addProjet(projet);
    }
    //Update Projet
    @PutMapping("/updatePojet/{idProjet}")
    public void updateProjet(@PathVariable("idProjet") Long idProjet,@RequestBody Projet p){
            p.setIdProjet(idProjet);
            projetService.updateProjet(p);
    }
    @PutMapping("/updateProjet")
    public Projet modifierProjet(@RequestBody Projet p){
        return projetService.updateProjet(p);
    }
    //Delete Projet
    @DeleteMapping("/deleteProjet/{idProjet}")
    public void deleteContrat(@PathVariable ("idProjet")Long idProjet){
        projetService.deleteProjet(idProjet);
    }
    //getProjet
    @GetMapping("/getProjet/{idProjet}")
    public Projet getProjet(@PathVariable("idProjet")Long idProjet){
        return projetService.getProjet(idProjet);
    }
    //assignTache to projet
    @GetMapping("/addTacheToProjet/{idTache}/{idProjet}")
    public boolean addTachetoProjet(@PathVariable("idTache")Long idTache,@PathVariable("idProjet")Long idProjet){
        return projetService.assignTachetoProjet(idTache, idProjet);
    }
    //Calcul Prix
    @GetMapping("/CalculPrix/{NomProjet}")
    public float calculPrix(@PathVariable("NomProjet")String NomProjet){
        return projetService.calculprixProjet(NomProjet);
    }
    //Add new Projet
    @GetMapping("/getprojetbynom/{NomProjet}")
    public List<Projet> addnewProjet(@PathVariable("NomProjet")String NomProjet){

        return projetService.getProjetByNom(NomProjet);
    }

}
