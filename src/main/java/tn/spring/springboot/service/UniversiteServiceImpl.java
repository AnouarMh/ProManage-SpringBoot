package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Departement;
import tn.spring.springboot.entities.Universite;
import tn.spring.springboot.repository.DepartementRepository;
import tn.spring.springboot.repository.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {

    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;

    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite U) {

        return universiteRepository.save(U) ;
    }

    @Override
    public Universite updateUniversite(Universite U) {
        return universiteRepository.save(U);
    }

    @Override
    public void deleteUniversite(Long id) {
        universiteRepository.deleteById(id);

    }

    @Override
    public Universite getUniversiteById(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public void assignDepartToUni(Long idU, Long dep) {

    }

    @Override
    public long nbTotalDepartment(Long idU) {
        return 0;
    }


    @Override
    public Universite getUnid(long id) {
        return universiteRepository.findById(id).orElse(null);
    }


}
