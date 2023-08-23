package peaksoft.peaksoft.services;


import peaksoft.peaksoft.entities.Department;
import java.util.List;

public interface DepartmentService {

    void saveDepartment(Department department, Long hospId);

    List<Department> getAllDepartments(Long hospId);

    Department getDepartmentById(Long depId);

    void deleteDepartment(Long depId);

    void updateDepartment(Long depId, Department newDepartment);

    Department findDepartmentByHospitalId(Long depId, Long hospId);

//    void updateDepartmentByHospId(Long depId,Long hospId, Department newDepartment);

}
