package it.gend.lctes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "relation")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @OneToMany(mappedBy="relation")
    Set<Patient> partners;
}
