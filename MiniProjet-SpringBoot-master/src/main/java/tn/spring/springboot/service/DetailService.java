package tn.spring.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Detail;
import tn.spring.springboot.repository.IDetailRepo;

@Service
public class DetailService {
    @Autowired
    private IDetailRepo detailRepo;

    public List<Detail> getAll() {
        List<Detail> details = detailRepo.findAll();
        return details;
    }

    public Detail get(Long id) {
        return detailRepo.findById(id).get();
    }

    public List<Detail> getBy(String name, String detail) {
        return detailRepo.findByArgs(name, detail);
    }

    public List<Detail> getSorted(String order) {
        if (order != null && order.equals("detail"))
            return detailRepo.findAllSortNameDESC();
        return detailRepo.findAllSortName();
    }

    public Detail addOne(Detail detail) {
        return detailRepo.save(detail);
    }

    public Detail updateOne(Detail detail) {
        return detailRepo.save(detail);
    }

    public void deleteOne(Long id) {
        detailRepo.deleteById(id);
    }
    
}
