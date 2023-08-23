package peaksoft.peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Department {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_gen")
    @SequenceGenerator(
            name = "department_gen",
            sequenceName = "department_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    @ManyToOne
    @ToString.Exclude
    private Hospital hospital;

    @ManyToMany(mappedBy = "departments")
    private List<Doctor> doctors;

    public Department(String name, Hospital hospital, List<Doctor> doctors) {
        this.name = name;
        this.hospital = hospital;
        this.doctors = doctors;
    }
}
