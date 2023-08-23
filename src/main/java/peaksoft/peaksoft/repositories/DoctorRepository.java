package peaksoft.peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.peaksoft.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

}
