package tn.spring.springboot.service;

import java.util.List;

import tn.spring.springboot.entities.Detail;

public interface IDetailService {
    public List<Detail> getAll();
    public Detail get(Long id);
    public List<Detail> getBy(String name, String detail);
    public List<Detail> getSorted(String order);
    public Detail addOne(Detail detail);
    public Detail updateOne(Detail detail);
    public void deleteOne(Long id);
    
}
