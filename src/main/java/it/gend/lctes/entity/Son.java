package it.gend.lctes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "son")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Son {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String surname;
    Date dateOfBirth;
    String stateOfHealth;
    @OneToMany(mappedBy="son")
    Set<SonGeneratedBy> parents;

}
