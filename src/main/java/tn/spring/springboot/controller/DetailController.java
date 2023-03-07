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

import tn.spring.springboot.entities.Detail;
import tn.spring.springboot.service.DetailService;


@RestController
@RequestMapping("/teams/details/")
public class DetailController {
    @Autowired
    private DetailService detailService;

    @GetMapping("")
    @ResponseBody
    public List<Detail> get(
        @RequestParam(required = false) Long id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String detail
        ) {

        List<Detail> details = new ArrayList<Detail>();

        if (id != null) {
            details.add(detailService.get(id));
            return details;
        }
        if (name != null || detail != null) {
            details = detailService.getBy(name, detail);
            return details;
        }

        details = detailService.getAll();
        return details;
    }

    @GetMapping("sorted")
    @ResponseBody
    public List<Detail> getSorted(@RequestParam(required = false) String order) {
        return detailService.getSorted(order);
    }

    @PostMapping("add")
    @ResponseBody
    public Detail add(@RequestBody Detail detail) {
        return detailService.addOne(detail);
    }

    @PutMapping("update")
    @ResponseBody
    public Detail update(@RequestBody Detail detail) {
        return detailService.updateOne(detail);
    }

    @DeleteMapping("delete")
    @ResponseBody
    public void delete(@RequestParam Long id) {
        detailService.deleteOne(id);
    }

}
