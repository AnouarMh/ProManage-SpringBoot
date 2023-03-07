package tn.spring.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Departement")
public class Departement implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idDepartement")
    private Long idDepartement;
    private String nomDepartement;
    private  String code;
    private  String type;
    private  String description;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "departement")
    @JsonIgnore
    private Set<Etudiant> etudiants;
    @ManyToOne
    Universite universite;
}
