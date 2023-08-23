package peaksoft.peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.peaksoft.entities.Patient;


public interface PatientRepository extends JpaRepository<Patient,Long> {


}
