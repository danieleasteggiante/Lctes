package it.gend.lctes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sonGeneratedBy")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SonGeneratedBy {
    @Id
    Long id;
    @ManyToOne
    @JoinColumn(name="patient_id")
    Patient patient;
    @ManyToOne
    @JoinColumn(name="son_id")
    Son son;

}
