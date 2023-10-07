package it.gend.lctes.entity;

import it.gend.lctes.entity.enums.TypeOfAbort;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "abort")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Abort {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    TypeOfAbort typeOfAbort;
    Integer gestationalEpoch;
    @OneToMany(mappedBy = "abort")
    Set<AbortGeneratedBy> generatedBySet;
}
