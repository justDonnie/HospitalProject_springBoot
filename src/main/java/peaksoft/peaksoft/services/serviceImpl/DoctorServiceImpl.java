package peaksoft.peaksoft.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.peaksoft.entities.Department;
import peaksoft.peaksoft.entities.Doctor;
import peaksoft.peaksoft.entities.Hospital;
import peaksoft.peaksoft.repositories.AppointmentRepository;
import peaksoft.peaksoft.repositories.DepartmentRepository;
import peaksoft.peaksoft.repositories.DoctorRepository;
import peaksoft.peaksoft.repositories.HospitalRepository;
import peaksoft.peaksoft.services.DoctorService;
import peaksoft.peaksoft.services.HospitalService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService{
    private final DoctorRepository doctorRepository;
    private final HospitalRepository hospitalRepository;
    private final HospitalService hospitalService;
    private final DepartmentRepository departmentRepository;
    private final AppointmentRepository appointmentRepository;


    @Override
    public void saveDoctor(Doctor doctor, Long hospId) {
        Hospital hospital = hospitalRepository.findById(hospId)
                .orElseThrow(() -> new NullPointerException("The Hospital with ID " + hospId + " is not found!!!"));
        doctor.setHospital(hospital);
        doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors(Long hospId) {
        return doctorRepository.findAll(hospId);
    }

    @Override
    public Doctor getDoctorById(Long docId) {
        return doctorRepository.findById(docId)
                .orElseThrow(()-> new NullPointerException("Doctor with ID "+docId+" is not found!!!"));
    }

    @Override
    public void deleteDoctor(Long docId) throws NullPointerException {
        try {
            Doctor doctor = doctorRepository.findById(docId).orElseThrow(() -> new NullPointerException("Doctor with ID " + docId + " not found!!!"));
            Hospital hospital = doctor.getHospital();
            hospital.getDoctors().remove(doctor);
            hospitalService.saveHospital(hospital);
            doctorRepository.deleteById(docId);
        }catch (Exception e) {
            throw new NullPointerException("Error while deleting department");
        }
    }

    @Override
    public void updateDoctor(Long docId, Doctor newDoctor) {
        Doctor doctor = doctorRepository.findById(docId)
                .orElseThrow(() -> new NullPointerException("Doctor with ID" + docId + " is not found!!!"));
        doctor.setFirstName(newDoctor.getFirstName());
        doctor.setLastName(newDoctor.getLastName());
        doctor.setPosition(newDoctor.getPosition());
        doctor.setEmail(newDoctor.getEmail());
        doctorRepository.save(doctor);
    }
    public Doctor getDoctorByHospitalId(Long hospId, Long docId){
        return doctorRepository.getDoctorByHospitalId(hospId,docId);
    }
}
