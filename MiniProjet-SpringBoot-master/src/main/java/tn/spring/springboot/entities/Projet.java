package tn.spring.springboot.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name ="Projet")
@Getter
@Setter
public class Projet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProjet")
    private Long idProjet;
    private String nomProjet;
    private String theme;
    private Date dateDeb;
    private Date dateFin;
    private float prix;
    @OneToMany
    @JsonIgnore
    private Set<Tache> taches;
}
