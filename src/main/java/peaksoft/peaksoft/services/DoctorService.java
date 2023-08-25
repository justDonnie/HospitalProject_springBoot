package peaksoft.peaksoft.services;

import peaksoft.peaksoft.entities.Department;
import peaksoft.peaksoft.entities.Doctor;
import java.util.List;


public interface DoctorService {

    void saveDoctor(Doctor doctor, Long hospId);

    List<Doctor> getAllDoctors(Long hospId);

    Doctor getDoctorById(Long docId);

    void deleteDoctor(Long docId);

    void updateDoctor(Long docId, Doctor newDoctor);

    Doctor getDoctorByHospitalId(Long hospId,Long docId);

}
