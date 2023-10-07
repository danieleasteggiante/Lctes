package it.gend.lctes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "abortGeneratedBy")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AbortGeneratedBy {
    @Id
    Long id;
    @ManyToOne
    @JoinColumn(name="patient_id")
    Patient patient;
    @ManyToOne
    @JoinColumn(name="abort_id")
    Abort abort;

}
