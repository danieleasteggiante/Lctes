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
    @ManyToMany
    @JoinTable(
            name = "abortOf",
            joinColumns = @JoinColumn(name = "parent"),
            inverseJoinColumns = @JoinColumn(name = "abort"))
    Set<Abort> abortSet;
    @ManyToMany
    @JoinTable(
            name = "sonOf",
            joinColumns = @JoinColumn(name = "parent"),
            inverseJoinColumns = @JoinColumn(name = "son"))
    Set<Son> sonSet;
}
