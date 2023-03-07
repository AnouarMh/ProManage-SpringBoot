package tn.spring.springboot.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.stream.DoubleStream;

@Entity
@Table(name = "Tache")
@Getter
@Setter
public class Tache implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTache")
    private Long idTache;
    private String libelle;
    private int prixTache;

}
