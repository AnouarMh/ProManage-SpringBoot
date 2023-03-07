package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Projet;
import tn.spring.springboot.entities.Tache;
import tn.spring.springboot.repository.ProjetRepositry;
import tn.spring.springboot.repository.TacheRepositry;
import tn.spring.springboot.service.TacheService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TacheServiceImpl implements TacheService {
    @Autowired
    TacheRepositry tacheRepositry;
    @Autowired
    ProjetRepositry projetRepositry;
    @Override
    public List<Tache> getallTache() {
        return tacheRepositry.findAll();
    }

    @Override
    public Tache addTache(Tache t) {
        return tacheRepositry.save(t);
    }

    @Override
    public Tache updateTache(Tache t) {
        return tacheRepositry.save(t);
    }

    @Override
    public void deleteTache(Long id) {
        tacheRepositry.deleteById(id);

    }

    @Override
    public Tache getTache(Long id) {
        return tacheRepositry.findById(id).orElse(null);
    }

    @Override
    public void affectTachetoProjet(String nomT,String nomP) {
        System.out.println(nomT);
        Tache tache=tacheRepositry.findByLibelle(nomT);
        Projet projet=projetRepositry.findProjetByNomProjet(nomP);
        projet.getTaches().add(tache);
        projetRepositry.save(projet);

    }
    @Override
    public List<Tache> getNomstachebyNomProjet(String NomProjet) {
        Projet projet=projetRepositry.findProjetByNomProjet(NomProjet);
        Long nb=projet.getTaches().stream().count();
        List result=new ArrayList<>();
        for(int i=0;i<nb;i++) {
            List<Tache> taches=tacheRepositry.retrievenomTacheBynomProjet(NomProjet);
            result= taches.parallelStream().map(Tache::getLibelle).collect(Collectors.toList());
        }
        return result;


    }

    @Override
    public List<Tache> TrieTacheASC() {
        return tacheRepositry.TrieTachesASC();
    }

    @Override
    public List<Tache> TrieTacheDESC() {
        return tacheRepositry.TrieTachesDESC();
    }
}
