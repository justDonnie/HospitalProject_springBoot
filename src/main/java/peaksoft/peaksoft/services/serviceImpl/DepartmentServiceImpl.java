package peaksoft.peaksoft.services.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.peaksoft.entities.Department;
import peaksoft.peaksoft.entities.Doctor;
import peaksoft.peaksoft.entities.Hospital;
import peaksoft.peaksoft.repositories.DepartmentRepository;
import peaksoft.peaksoft.repositories.DoctorRepository;
import peaksoft.peaksoft.repositories.HospitalRepository;
import peaksoft.peaksoft.services.DepartmentService;
import peaksoft.peaksoft.services.HospitalService;

import java.util.List;

@Service
@RequiredArgsConstructor

public class DepartmentServiceImpl implements DepartmentService {
    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;
    private final HospitalRepository hospitalRepository;
    private final HospitalService hospitalService;

    @Override
    public void saveDepartment(Department department, Long hospId) {
        Hospital hospital = hospitalRepository.findById(hospId).
                orElseThrow(()->new NullPointerException(" The hospital with ID "+hospId+" is not found!!!"));
        department.setHospital(hospital);
        departmentRepository.save(department);
    }

    @Override
    public List<Department>getAllDepartments(Long hospId) {
        return departmentRepository.findAll(hospId);
    }

    @Override
    public Department getDepartmentById(Long depId) {
        return departmentRepository.findById(depId)
                .orElseThrow(()->new RuntimeException("The Department with ID "+depId+" is not found!!!"));
    }

    @Override
    public void deleteDepartment(Long id) throws NullPointerException {
        try {
            Department department = departmentRepository.findById(id)
                    .orElseThrow(() -> new NullPointerException("Department not found"));

            Hospital hospital = department.getHospital();
            hospital.getDepartments().remove(department);
            hospitalService.saveHospital(hospital);
            departmentRepository.deleteById(id);
        } catch (Exception e) {
            throw new NullPointerException("Error while deleting department");
        }
    }

    @Override
    public void updateDepartment(Long depId, Department newDepartment) {
        Department department = departmentRepository.findById(depId)
                .orElseThrow(() -> new RuntimeException("The Department with ID " + depId + " is not found!!!"));
        department.setName(newDepartment.getName());
        departmentRepository.save(department);
    }

    @Override
    public Department findDepartmentByHospitalId(Long depId, Long hospId) {
        return departmentRepository.findDepartmentByHospitalId(depId, hospId);
    }
    @Transactional
    @Override
    public void assignDocToDep(Long docId, Long depId) {
        Department department = departmentRepository.findById(depId)
                .orElseThrow(() -> new RuntimeException("The Department with ID " + depId + " is not found!!!"));
        Doctor doctor = doctorRepository.findById(docId)
                .orElseThrow(() -> new RuntimeException("The Doctor with ID " + depId + " is not found!!!"));
        department.getDoctors().add(doctor);
        doctor.getDepartments().add(department);
        doctorRepository.save(doctor);
        departmentRepository.save(department);
    }

}
