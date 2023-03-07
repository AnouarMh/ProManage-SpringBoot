package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.Universite;
import tn.spring.springboot.service.DepartementServiceImpl;
import tn.spring.springboot.service.IUniversiteService;
import tn.spring.springboot.service.UniversiteServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
public class UniversiteController {

    UniversiteServiceImpl universiteService;
    DepartementServiceImpl departementService;
    //get all Universite
    @GetMapping("/getallUniversite")
    public List<Universite> GetUni(){

        return  universiteService.getAllUniversite();
    }

    //add new Univ
    @PostMapping("/addUniversite/")
    public void  addUniv(@RequestBody Universite U  ){
        universiteService.addUniversite(U);
    }
    //update Univ
    @PutMapping("/updateUniversite/{idUni}")
    public void updateUni(@PathVariable("idUni") Long id, @RequestBody Universite E){

        E.setIdUniversite(id);
        universiteService.updateUniversite(E);
    }
    @PutMapping("/updateUniversite/")
    @ResponseBody
    public Universite updateUniversite(@RequestBody Universite E) {

        return   universiteService.updateUniversite(E);
    }
    //Delete Univ
    @DeleteMapping("/deleteUniversite/{idUni}")
    public  void deleteUni(@PathVariable("idUni") Long id){

        universiteService.deleteUniversite(id);
    }
    //Add Univ To Depart
    @PostMapping("/addUniversiteToDepartement/{idUni}/{idDepart}")
    public void  addUnivtoDep(@PathVariable("idUni") Long idU,@PathVariable("idDepart") Long id){
        universiteService.assignDepartToUni(idU, id);
    }
    //nombre totale department by iduniv
    @GetMapping("/nbDepartment/{idUni}")
    public long getnbrDepartmentByuniver(@PathVariable("idUni") Long idU) {
        return universiteService.nbTotalDepartment(idU);
    }
    @GetMapping("/universite/{idUni}")

    public Universite getUniversiteById(@PathVariable("idUni") Long idU) {
        return universiteService.getUnid(idU);
    }
}
