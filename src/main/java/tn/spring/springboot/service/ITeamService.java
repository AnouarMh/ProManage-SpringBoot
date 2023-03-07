package tn.spring.springboot.service;

import java.util.List;


import tn.spring.springboot.entities.Team;

public interface ITeamService {
    public List<Team> getAll();

    public Team get(Long id);

    public List<Team> getByArgs(String name, String desc);

    public Team addOne(Team team);

    public Team updateOne(Team team);

    public void deleteOne(Long id);
}
