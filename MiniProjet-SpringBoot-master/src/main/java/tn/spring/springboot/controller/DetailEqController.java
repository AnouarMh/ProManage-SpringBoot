package tn.spring.springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entities.DetailEquipe;
import tn.spring.springboot.service.IDetailEqService;

import java.util.List;

@RestController
@AllArgsConstructor
public class DetailEqController {

    IDetailEqService detailEqService;

    @GetMapping("/getallDetailE")
    public List<DetailEquipe> getAllDetailEquipe(){
        return detailEqService.getAllDetailEquipe();
    }

    @PostMapping("/addDetailE")
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe detailEquipe){
        return detailEqService.addDetailEquipe(detailEquipe);
    }

    @PutMapping("/updateDetailE")
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe detailEquipe) {
        return detailEqService.updateDetailEquipe(detailEquipe);
    }

    @DeleteMapping("deleteDetailE/{id}")
    public void deleteDetailEquipe(@PathVariable("id") Long id){
        detailEqService.deleteDetailEquipe(id);
    }

    @GetMapping("/findbythematique/{thematique}")
    public List<DetailEquipe> findByThematiqueLike(@PathVariable("thematique") String thematique){
        return detailEqService.findByThematiqueLike(thematique);
    }
}
