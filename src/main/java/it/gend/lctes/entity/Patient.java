package it.gend.lctes.entity;

import it.gend.lctes.entity.enums.Sex;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;
@Entity
@Table(name = "patient")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Patient {
    @Id
    Long id;
    String name;
    String surname;
    String bornIn;
    Date dateOfBirth;
    Sex sex;
    String contact;
    String originState;
    String cf;
    @ManyToOne
    @JoinColumn(name="relation_id")
    Relation relation;
    String currentPartnerName;
    String getCurrentPartnerSurname;
    Boolean pregnant;
    @OneToMany(mappedBy="patient")
    Set<SonGeneratedBy> sonGeneratedBySet;
    @OneToMany(mappedBy="patient")
    Set<AbortGeneratedBy> abortGeneratedBySet;
    String requestingDepartment;
    String indicationInvestigation;
    String personalHistory;
    String familyHistory;
    @OneToMany(mappedBy="patient")
    Set<Exam> examSet;
}
