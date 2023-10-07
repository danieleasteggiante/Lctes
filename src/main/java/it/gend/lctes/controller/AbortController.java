package it.gend.lctes.controller;

import it.gend.lctes.DTO.AbortDTO;
import it.gend.lctes.DTO.mapper.AbortMapper;
import it.gend.lctes.entity.Abort;
import it.gend.lctes.entity.enums.TypeOfAbort;
import it.gend.lctes.repository.AbortRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/abort")
@RequiredArgsConstructor
@Slf4j
public class AbortController {

    private AbortRepository abortRepository;

    AbortMapper abortMapper;

    @Autowired
    public AbortController(AbortRepository abortRepository, AbortMapper abortMapper) {
        this.abortRepository = abortRepository;
        this.abortMapper = abortMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<AbortDTO> createCanvass() {
        abortRepository.save(Abort.builder().typeOfAbort(TypeOfAbort.IVG).build());
        log.info("REST request to get All {}", "aborts");
        AbortDTO abortDTO = abortMapper.abortToAbortDTO(abortRepository.findAll().get(0));
        return ResponseEntity
                .ok(abortDTO);
    }
}
