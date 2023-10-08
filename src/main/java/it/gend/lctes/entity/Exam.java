package it.gend.lctes.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exam")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id")
    Patient patient;
    String name;
    String result;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "examfamily_id", referencedColumnName = "id")
    ExamFamily examFamily;

}
