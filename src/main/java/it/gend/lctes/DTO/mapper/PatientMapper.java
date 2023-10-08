package it.gend.lctes.DTO.mapper;

import it.gend.lctes.DTO.AbortDTO;
import it.gend.lctes.DTO.PatientDTO;
import it.gend.lctes.entity.Abort;
import it.gend.lctes.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PatientMapper {
    @Mapping(target = "partnerName", source = "patient.partner.name")
    @Mapping(target = "partnerId", source = "patient.partner.id")
    PatientDTO patientToPatientDTO(Patient patient);

}
