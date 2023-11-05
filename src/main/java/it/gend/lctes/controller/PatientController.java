package it.gend.lctes.controller;

import it.gend.lctes.DTO.PatientDTO;
import it.gend.lctes.DTO.mapper.PatientMapper;
import it.gend.lctes.entity.Patient;
import it.gend.lctes.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody PatientDTO getPatient(@PathVariable Long id) {
        log.info("REST request to get patient with Id {}", id);
        Patient patient =  patientRepository.findById(id).get();
        return patientMapper.patientToPatientDTO(patient);
    }
    @PostMapping("")
    public @ResponseBody PatientDTO addPatient(@RequestBody PatientDTO patientDTO) {
        log.info("REST request to get patient with Id {}", patientDTO);
        Patient patient = patientRepository.save(patientMapper.patientDTOToPatient(patientDTO));
        return patientMapper.patientToPatientDTO(patient);
    }
}
