package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Departement;
import tn.spring.springboot.entities.Option;
import tn.spring.springboot.entities.Universite;
import tn.spring.springboot.service.DepartementServiceImpl;
import tn.spring.springboot.service.IDepartementService;
import tn.spring.springboot.service.UniversiteServiceImpl;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
public class DepartementController {

    DepartementServiceImpl departementService;
    UniversiteServiceImpl universiteService;
    //GetallDepartement
    @GetMapping("/getallDepartement")
    public ResponseEntity<List<Departement>> getallDepartement(){

        return new ResponseEntity<>(departementService.retrieveAllDepartement(), HttpStatus.OK);
    }
    @GetMapping("/getUniversiteee")
    public ResponseEntity<List<Universite>> GetUni(){

        return new ResponseEntity<>(universiteService.getAllUniversite(), HttpStatus.OK) ;
    }
    //add new Departement
    @PostMapping("/addDepartement")
    public ResponseEntity<Departement> addDepartement(@RequestBody Departement departement){
        return new ResponseEntity<>(departementService.addDepartement(departement),HttpStatus.CREATED);
    }
    @PostMapping("/addnewDepartToUniv/{idUniversite}")
    public Departement addnewDepartToUniv(@PathVariable("idUniversite")Long idUniversite,@RequestBody Departement departement){
        Departement d= departementService.addAndAssignDepartToUniv(departement,idUniversite);
        return d;
    }
    @PutMapping("/addnewDepartToUniv/{idUniversite}")
    public Departement updateAndAssignDepartToUniversite(@PathVariable("idUniversite")Long idUniversite,@RequestBody Departement dep){
        dep.getUniversite().setIdUniversite(idUniversite);
        Departement d= departementService.addAndAssignDepartToUniversite(dep,idUniversite);
        return d;
    }
    //update Depart
    @PutMapping("/updateDepartement/{idDepart}")
    public void updateDepart(@PathVariable("idDepart")Long idDepart,Departement d){
        d.setIdDepartement(idDepart);
        departementService.updateDepartement(d);

    }
    @PutMapping("/putDepatement")
    @ResponseBody
    public Departement modifyDepartment(@RequestBody Departement d) {

        return departementService.updateDepartement(d);
    }
    //delete Depart
    @DeleteMapping("/deleteDepartement/{idDepart}")
    public void deleteDepart(@PathVariable("idDepart")Long idDepart){
        departementService.deleteDepartement(idDepart);
    }
    //get Depart By Id
    @GetMapping("/getDepart/{idDepart}")
    public Departement getDepartById(@PathVariable("idDepart")Long idDepart){
        return departementService.retrieveDepartement(idDepart);
    }

    //getDepart by option
    @GetMapping("/getDepartementByOption/{option}")
    public List<Departement> getDepartbyOption(@PathVariable("option")Option option){
        return departementService.retrieveDepartementByOptionEtudiant(option);
    }
    //addDepartToUniv


    //nombre etudiant par idDepart


    //find nom depart by nomuniversite

    @RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
    @ResponseBody
    public List<Departement> saveDepartement(@RequestBody List<Departement> departement) {

        Universite universite = new Universite();
        universite.setNomUniversite("Esprit");

        for (Departement department1 : departement) {
            department1.setUniversite(universite);
        }

        List<Departement> DepartementResponse = departementService.saveDepartement(departement);
        return DepartementResponse;
    }
}
