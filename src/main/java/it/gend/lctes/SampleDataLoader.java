package it.gend.lctes;

import com.github.javafaker.Faker;
import it.gend.lctes.entity.*;
import it.gend.lctes.entity.enums.Sex;
import it.gend.lctes.entity.enums.TypeOfAbort;
import it.gend.lctes.repository.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//@Component
@Transactional
@Slf4j
public class SampleDataLoader implements CommandLineRunner {
    private final AbortRepository abortRepository;
    private final ExamFamilyRepository examFamilyRepository;
    private final ExamRepository examRepository;
    private final PatientRepository patientRepository;
    private final SonRepository sonRepository;
    private final Faker faker;

    public SampleDataLoader(AbortRepository abortRepository, ExamFamilyRepository examFamilyRepository, ExamRepository examRepository, PatientRepository patientRepository, SonRepository sonRepository) {
        this.abortRepository = abortRepository;
        this.examFamilyRepository = examFamilyRepository;
        this.examRepository = examRepository;
        this.patientRepository = patientRepository;
        this.sonRepository = sonRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {

        List<ExamFamily> examFamilyList = IntStream.rangeClosed(0,7)
                .mapToObj(i->{
                    return ExamFamily.builder()
                            .name(faker.medical().symptoms())
                            .build();
                }).toList();

        examFamilyRepository.saveAll(examFamilyList);


        List<Patient> patientList = IntStream.rangeClosed(0,100)
                .mapToObj(i->{

                log.info("paziente nr {} creato ",i);

                Patient patient = Patient.builder()
                            .id(Long.valueOf(faker.random().nextInt(0,99999)))
                            .cf(faker.regexify("^([A-Z]{6}[0-9LMNPQRSTUV]{2}[ABCDEHLMPRST]{1}[0-9LMNPQRSTUV]{2}[A-Z]{1}[0-9LMNPQRSTUV]{3}[A-Z]{1})$|([0-9]{11})$"))
                            .name(faker.name().firstName())
                            .surname(faker.name().lastName())
                            .dateOfBirth(new Date(faker.date().birthday().getTime()))
                            .bornIn(faker.address().state())
                            .contact(faker.phoneNumber().cellPhone())
                            .currentPartnerName(faker.name().name())
                            .currentPartnerSurname(faker.name().lastName())
                            .familyHistory(faker.medical().medicineName())
                            .personalHistory(faker.medical().diseaseName())
                            .pregnant(faker.bool().bool())
                            .requestingDepartment(faker.medical().hospitalName())
                            .sex(Sex.values()[faker.number().numberBetween(0,1)])
                            .originState(faker.address().state())
                            .indicationInvestigation(faker.medical().symptoms())
                            .build();


                    Set<Exam> examList = IntStream.rangeClosed(1,(int)(Math.random() * 3))
                            .mapToObj(j->{
                                Exam exam= Exam.builder()
                                        .name(faker.medical().diseaseName())
                                        .result(faker.medical().diseaseName())
                                        .examFamily(examFamilyList.get((int)(Math.random() * 6)))
                                        .patient(patient)
                                        .build();
                                return exam;
                            }).collect(Collectors.toSet());

                    examRepository.saveAll(examList);
                    patient.setExamSet(examList);


                    Set<Son> sonSet = IntStream.rangeClosed(0,(int)(Math.random() * 3))
                            .mapToObj(j->{
                                Son son =  Son.builder()
                                        .name(faker.medical().diseaseName())
                                        .surname(faker.name().lastName())
                                        .stateOfHealth(faker.medical().symptoms())
                                        .patient(patient)
                                        .build();
                                return son;
                            }).collect(Collectors.toSet());

                    sonRepository.saveAll(sonSet);


                    Set<Abort> abortSet = IntStream.rangeClosed(0,(int)(Math.random() * 3))
                            .mapToObj(j->{
                                Abort abort = Abort.builder()
                                        .patient(patient)
                                        .gestationalEpoch(faker.number().numberBetween(4,40))
                                        .typeOfAbort(TypeOfAbort.values()[(int)(Math.random() * TypeOfAbort.values().length-1)])
                                        .build();
                                return abort;
                            }).collect(Collectors.toSet());

                    abortRepository.saveAll(abortSet);

                    patient.setExamSet(examList);
                    patient.setSonSet(sonSet);
                    patient.setAbortSet(abortSet);
                    patientRepository.save(patient);

                    return patient;

                }).toList();
    }
}
