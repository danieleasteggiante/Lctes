package it.gend.lctes.DTO;

import it.gend.lctes.entity.enums.TypeOfAbort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class AbortDTO {
    TypeOfAbort typeOfAbort;
    Integer gestationalEpoch;
}
