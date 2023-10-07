package it.gend.lctes.DTO;

import it.gend.lctes.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class RelationDTO {
    Set<Patient> partners;
}
