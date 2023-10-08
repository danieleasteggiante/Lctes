package it.gend.lctes.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "examFamily")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ExamFamily {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    @OneToMany( mappedBy = "examFamily")
    Set<Exam> exam;

}
