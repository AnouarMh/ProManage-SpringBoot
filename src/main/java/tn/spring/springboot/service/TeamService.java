package tn.spring.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Detail;
import tn.spring.springboot.entities.Team;
import tn.spring.springboot.repository.IDetailRepo;
import tn.spring.springboot.repository.ITeamRepo;

@Service
public class TeamService {
    @Autowired
    private ITeamRepo teamRepo;

    @Autowired
    private IDetailRepo detailRepo;

    public List<Team> getAll() {
        List<Team> teams = teamRepo.findAll();
        return teams;
    }

    public Team get(Long id) {
        return teamRepo.findById(id).get();
    }

    public List<Team> getBy(String name, String desc, Long detail_id) {
        return teamRepo.findByArgs(name, desc, detail_id);
    }

    public List<Team> getSorted(String order) {
        if (order != null && order.equals("desc"))
            return teamRepo.findAllSortNameDESC();
        return teamRepo.findAllSortName();
    }

    public Team addOrUpdate(Team t) {
        Team _t = t;

        Long d_id = _t.getDetailId();
        Detail detail = null;

        if (d_id != null) {
            detail = detailRepo.findById(d_id).orElse(null);
            if (detail != null) {
                _t.setDetail(detail);
            } else {
                _t.setDetailId(null);
            }
        }

        if (_t.getId() == null) return teamRepo.save(_t);

        _t = teamRepo.findById(t.getId()).orElse(null);
        
        if (_t != null) { // if detail exists
            if (t.name != null) _t.name = t.name;
            if (t.description != null) _t.description = t.description;

            if (d_id != null && detail != null) {
                    _t.setDetailId(d_id);
                    _t.setDetail(detail);
            }

            return teamRepo.save(_t);
        }

        return teamRepo.save(_t);
    }

    public Team addOne(Team team) {
        return teamRepo.save(team);
    }

    public Team updateOne(Team team) {
        return teamRepo.save(team);
    }

    public void deleteOne(Long id) {
        teamRepo.deleteById(id);
    }
}
