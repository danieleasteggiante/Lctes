package it.gend.lctes.controller;

import it.gend.lctes.DTO.AbortDTO;
import it.gend.lctes.DTO.PatientDTO;
import it.gend.lctes.DTO.mapper.PatientMapper;
import it.gend.lctes.entity.Abort;
import it.gend.lctes.entity.Patient;
import it.gend.lctes.entity.enums.TypeOfAbort;
import it.gend.lctes.repository.AbortRepository;
import it.gend.lctes.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
@Slf4j
public class PatientController {
    private PatientRepository patientRepository;
    private PatientMapper patientMapper;
    @Autowired
    public PatientController(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @GetMapping("/{id}")
    public @ResponseBody PatientDTO createCanvass(@PathVariable Long id) {
        log.info("REST request to get patient with Id {}", id);
        Patient patient =  patientRepository.findById(id).get();
        log.info("Size esami {}", patient.getExamSet().size());
        return patientMapper.patientToPatientDTO(patient);
    }
}
