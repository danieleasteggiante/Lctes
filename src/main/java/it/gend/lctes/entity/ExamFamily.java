package it.gend.lctes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "examFamily")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ExamFamily {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    @OneToOne(mappedBy = "examFamily")
    Exam exam;

}
