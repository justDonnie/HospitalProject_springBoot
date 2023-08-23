package peaksoft.peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Doctor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doctor_gen")
    @SequenceGenerator(
            name = "doctor_gen",
            sequenceName = "doctor_seq",
            allocationSize = 1
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    @ManyToOne
    private Hospital hospital;
    @ManyToMany
    private List<Department>departments;
    @OneToMany(mappedBy = "doctor")
    private List<Appointment>appointments;

    public Doctor(String firstName, String lastName, String position, String email, Hospital hospital, List<Department> departments, List<Appointment> appointments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.hospital = hospital;
        this.departments = departments;
        this.appointments = appointments;
    }
}
