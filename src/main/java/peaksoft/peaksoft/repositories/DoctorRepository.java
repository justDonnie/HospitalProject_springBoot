package peaksoft.peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.peaksoft.entities.Doctor;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    @Query("select d from Doctor d where d.hospital.id=:hospId")
    List<Doctor> findAll(Long hospId);
}
