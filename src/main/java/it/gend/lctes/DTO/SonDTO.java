package it.gend.lctes.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class SonDTO {
    String name;
    String surname;
    Date dateOfBirth;
    String stateOfHealth;
}
