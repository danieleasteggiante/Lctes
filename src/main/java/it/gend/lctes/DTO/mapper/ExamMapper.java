package it.gend.lctes.DTO.mapper;

import it.gend.lctes.DTO.ExamDTO;
import it.gend.lctes.entity.Exam;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses={PatientMapper.class})
public interface ExamMapper {
    ExamDTO examToExamDTO(Exam exam);
}
