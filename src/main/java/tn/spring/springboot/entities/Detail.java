package tn.spring.springboot.entities;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "details")
@Getter
@Setter
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    public String name;
    @Column(nullable = false)
    public String detail;

    @OneToMany(targetEntity = tn.spring.springboot.entities.Team.class, mappedBy = "detail")
    @JsonIgnore
    private Set<Team> teams;

}
