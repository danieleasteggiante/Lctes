package it.gend.lctes.DTO.mapper;

import it.gend.lctes.DTO.AbortDTO;
import it.gend.lctes.entity.Abort;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AbortMapper {
    AbortDTO abortToAbortDTO(Abort car);
}
