package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Projet;
import tn.spring.springboot.entities.Tache;
import tn.spring.springboot.repository.ProjetRepositry;
import tn.spring.springboot.repository.TacheRepositry;

import java.util.*;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Service
@AllArgsConstructor
public class ProjetServiceImpl implements ProjetService{
    @Autowired
    ProjetRepositry projetRepositry;
    @Autowired
    TacheRepositry tacheRepositry;
    @Override
    public List<Projet> getallProjet() {
        return projetRepositry.findAll();
    }

    @Override
    public List<Projet> getProjetByNom(String Nom) {

        List<Projet> liste=projetRepositry.findAll();
        List<Projet> listefinale= new ArrayList<>() ;
        liste.forEach(projet -> {
            if(projet.getNomProjet().contains(Nom)){

                listefinale.add(projet);
            }
        });
        System.out.println("nom : " + listefinale.get(0).getNomProjet());
        if(listefinale!=null)
        return listefinale;
        else
            return null;
    }

    @Override
    public List<Projet> getallProjetOrderbyName() {
        List<Projet> liste=projetRepositry.findAll();


        Collections.sort(liste, new Comparator<Projet>() {
            @Override
            public int compare(Projet u1, Projet u2) {
                return u1.getNomProjet().compareTo(u2.getNomProjet());
            }
        });
        return liste;

    }


    @Override
    public Projet addProjet(Projet p) {
        return projetRepositry.save(p);
    }

    @Override
    public Projet updateProjet(Projet p) {
        return projetRepositry.save(p);
    }

    @Override
    public void deleteProjet(Long id) {
        projetRepositry.deleteById(id);

    }

    @Override
    public Projet getProjet(Long id) {
        return projetRepositry.findById(id).orElse(null);
    }

    @Override
    public Boolean assignTachetoProjet(Long idTache,Long idProjet) {
        Tache tache=tacheRepositry.findById(idTache).orElse(null);
        Projet projet=projetRepositry.findById(idProjet).orElse(null);

            projet.getTaches().add(tache);
            projetRepositry.save(projet);
            return true;

    }

    @Override
    public float calculprixProjet(String NomProjet) {
        float Somme = 0;
        Projet projet=projetRepositry.findProjetByNomProjet(NomProjet);
        Long nb=projet.getTaches().stream().count();
        List<Integer> tache=new ArrayList<>();
        for (int i=0;i<nb;i++){
            List<Tache> taches=projetRepositry.retrieveTachebyNomProjet(NomProjet);
            tache=taches.stream().map(Tache::getPrixTache).collect(Collectors.toList());
            Somme=tache.stream().mapToLong(Integer::longValue).sum();
        }
        projet.setPrix(Somme);
        projetRepositry.save(projet);

        return Somme;
    }

}
