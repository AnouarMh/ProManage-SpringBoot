package tn.spring.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.springboot.entities.Team;
import tn.spring.springboot.service.TeamService;


@RestController
@RequestMapping("/teams/")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping("")
    @ResponseBody
    public List<Team> get(
        @RequestParam(required = false) Long id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String description,
        @RequestParam(required = false) Long detail_id
        ) {

        List<Team> teams = new ArrayList<Team>();

        if (id != null) {
            teams.add(teamService.get(id));
            return teams;
        }
        if (name != null || description != null || detail_id != null) {
            teams = teamService.getBy(name, description, detail_id);
            return teams;
        }

        teams = teamService.getAll();
        return teams;
    }

    @GetMapping("sorted")
    @ResponseBody
    public List<Team> getSorted(@RequestParam(required = false) String order) {
        return teamService.getSorted(order);
    }

    @PostMapping("add")
    @ResponseBody
    public Team add(@RequestBody Team team) {
        return teamService.addOrUpdate(team);
    }

    @PutMapping("update")
    @ResponseBody
    public Team update(@RequestBody Team team) {
        return teamService.addOrUpdate(team);
    }

    @DeleteMapping("delete")
    @ResponseBody
    public void delete(@RequestParam Long id) {
        teamService.deleteOne(id);
    }

}
