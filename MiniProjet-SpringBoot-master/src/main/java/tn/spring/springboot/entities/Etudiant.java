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
@Table(name = "Etudiant")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtudiant")
    private Long idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option options;
    @ManyToOne
    Departement departement;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "etudiant")
    @JsonIgnore
    private Set<Contrat>contrats;

    @ManyToMany(mappedBy = "etudiants", cascade = CascadeType.PERSIST)
    private Set<Equipe> equipes;
    @JsonIgnore
    @OneToOne
    private Account account;


}
