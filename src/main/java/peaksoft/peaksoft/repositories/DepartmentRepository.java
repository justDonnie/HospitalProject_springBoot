package peaksoft.peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import peaksoft.peaksoft.entities.Department;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    @Query("select d from  Department d where d.hospital.id = :hospId and d.id = :depId")
    Department findDepartmentByHospitalId(Long depId, Long hospId);
}
