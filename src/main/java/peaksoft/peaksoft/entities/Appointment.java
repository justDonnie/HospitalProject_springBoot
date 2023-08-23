package peaksoft.peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Appointment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appointment_gen")
    @SequenceGenerator(
            name = "appointment_gen",
            sequenceName = "appointment_seq",
            allocationSize = 1
    )
    private Long id;
    private LocalDate date;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne
    private Department department;

    public Appointment(LocalDate date, Patient patient, Doctor doctor, Department department) {
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
        this.department = department;
    }
}
