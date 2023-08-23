package peaksoft.peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import peaksoft.peaksoft.enums.Gender;

import java.util.List;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Patient {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_gen")
    @SequenceGenerator(
            name = "patient_gen",
            sequenceName = "patient_seq",
            allocationSize = 1
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Enumerated (EnumType.STRING)
    private Gender gender;
    private String email;
    @ManyToOne
    private Hospital hospital;
    @OneToMany(mappedBy = "patient")
    private List<Appointment>appointments;

    public Patient(String firstName, String lastName, String phoneNumber, Gender gender, String email, Hospital hospital, List<Appointment> appointments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
        this.hospital = hospital;
        this.appointments = appointments;
    }
}



