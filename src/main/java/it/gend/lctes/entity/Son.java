package it.gend.lctes.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Parent;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "son")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Son {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String surname;
    Date dateOfBirth;
    String stateOfHealth;
    @ManyToMany(mappedBy = "sonSet")
    Set<Patient> parent;
}
