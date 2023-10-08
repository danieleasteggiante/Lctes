package it.gend.lctes.DTO;

import it.gend.lctes.entity.ExamFamily;
import it.gend.lctes.entity.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class ExamDTO {
    Long id;
    String name;
    String result;
}
