package peaksoft.peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.peaksoft.entities.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {


}
