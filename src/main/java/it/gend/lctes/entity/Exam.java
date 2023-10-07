package it.gend.lctes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "exam")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    @JoinColumn(name="patient_id")
    Patient patient;
    String name;
    String result;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "examfamily_id", referencedColumnName = "id")
    ExamFamily examFamily;

}
