package peaksoft.peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "hospitals")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Hospital {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hospital_gen")
    @SequenceGenerator(
            name = "hospital_gen",
            sequenceName = "hospital_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String address;
    private String image;
    @OneToMany(mappedBy = "hospital",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<Doctor>doctors;
    @OneToMany(mappedBy = "hospital",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<Patient>patients;
    @OneToMany(mappedBy = "hospital",
            cascade = CascadeType.REMOVE,fetch = FetchType.EAGER
    )
    private List<Department> departments;
    @OneToMany
    private List<Appointment>appointments;


    public Hospital(String name, String address, String image, List<Doctor> doctors, List<Patient> patients, List<Department> departments, List<Appointment> appointments) {
        this.name = name;
        this.address = address;
        this.image = image;
        this.doctors = doctors;
        this.patients = patients;
        this.departments = departments;
        this.appointments = appointments;
    }
//    public void addDepartment(Department department){
//        if (departments != null){
//            departments = new ArrayList<>();
//        } else {
//            departments.add(department);
//        }
//    }
}
