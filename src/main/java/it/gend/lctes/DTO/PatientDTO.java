package it.gend.lctes.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.gend.lctes.entity.enums.Sex;
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
    String partnerId;
    String partnerName;
    String partnerSurname;
    String currentPartnerName;
    String getCurrentPartnerSurname;
    Boolean pregnant;
    @JsonProperty("listaEsami")
    Set<ExamDTO> examSet;
    String requestingDepartment;
    String indicationInvestigation;
    String personalHistory;
    String familyHistory;
}
