package it.gend.lctes.DTO;

import it.gend.lctes.entity.AbortGeneratedBy;
import it.gend.lctes.entity.Exam;
import it.gend.lctes.entity.Relation;
import it.gend.lctes.entity.SonGeneratedBy;
import it.gend.lctes.entity.enums.Sex;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Set;
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class PatientDTO {
    Long id;
    String name;
    String surname;
    String bornIn;
    Date dateOfBirth;
    Sex sex;
    String contact;
    String originState;
    String cf;
    Relation relation;
    String currentPartnerName;
    String getCurrentPartnerSurname;
    Boolean pregnant;
    Set<SonGeneratedBy> sonGeneratedBySet;
    Set<AbortGeneratedBy> abortGeneratedBySet;
    String requestingDepartment;
    String indicationInvestigation;
    String personalHistory;
    String familyHistory;
    Set<Exam> examSet;
}
