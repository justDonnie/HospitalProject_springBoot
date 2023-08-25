package peaksoft.peaksoft.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.peaksoft.entities.Patient;
import peaksoft.peaksoft.repositories.PatientRepository;
import peaksoft.peaksoft.services.PatientService;


import java.util.List;
@Service
@RequiredArgsConstructor

public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    @Override
    public void savePatient(Patient patient,Long hospId) {

    }

    @Override
    public List<Patient> getAllPatients(Long hospId) {
        return null;
    }

    @Override
    public Patient getPatientById(Long id) {
        return null;
    }

    @Override
    public void deletePatient(Long id) {

    }

    @Override
    public void updatePatient(Long id, Patient patient) {

    }
}
