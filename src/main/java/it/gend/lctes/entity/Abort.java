package it.gend.lctes.entity;

import it.gend.lctes.entity.enums.TypeOfAbort;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "abort")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Abort {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    TypeOfAbort typeOfAbort;
    Integer gestationalEpoch;
    @ManyToMany(mappedBy = "abortSet")
    Set<Patient> parent;
}
