package peaksoft.peaksoft.services;


import peaksoft.peaksoft.entities.Patient;

import java.util.List;

public interface PatientService {
    void savePatient(Patient patient,Long hospId);

    List<Patient> getAllPatients(Long hospId);

    Patient getPatientById(Long id);

    void deletePatient(Long id);

    void updatePatient(Long id,Patient patient);

}
