package it.gend.lctes.entity;

import it.gend.lctes.entity.enums.Sex;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Set;
@Entity
@Table(name = "patient")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
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
    @OneToOne
    Patient partner;
    String currentPartnerName;
    String currentPartnerSurname;
    Boolean pregnant;
    String requestingDepartment;
    String indicationInvestigation;
    String personalHistory;
    String familyHistory;
    @OneToMany(mappedBy="patient", cascade = CascadeType.ALL)
    Set<Exam> examSet;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    Set<Abort> abortSet;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    Set<Son> sonSet;
}
