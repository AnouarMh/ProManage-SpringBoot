// spring product model
package tn.spring.springboot.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teams")
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    public String name;
    public String description;

    @ManyToOne(targetEntity = Detail.class)
    @JoinColumn(name = "detail_id")
    private Detail detail;

    @Column(name = "detail")
    @JsonAlias("detail_id")
    private Long detailId;

    @Override
    public String toString() {
        return "Team [id=" + id + ", name=" + name + ", name=" + name + ", description=" + description +
                ", detail_id=" + detailId + "]";
    }

}