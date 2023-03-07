package tn.spring.springboot.service;

import tn.spring.springboot.entities.DetailEquipe;


import java.util.List;

public interface IDetailEqService {
    List<DetailEquipe> getAllDetailEquipe();
    DetailEquipe addDetailEquipe(DetailEquipe detailEquipe);
    DetailEquipe updateDetailEquipe(DetailEquipe detailEquipe);
    void deleteDetailEquipe (Long id);
    List<DetailEquipe> findByThematiqueLike(String thematique);
}
