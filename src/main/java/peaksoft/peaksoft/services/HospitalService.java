package peaksoft.peaksoft.services;


import peaksoft.peaksoft.entities.Hospital;

import java.util.List;

public interface HospitalService {

    void saveHospital(Hospital hospital);

    List<Hospital> getAllHospitals();

    Hospital getHospitalById(Long id);

    void deleteHospital(Long id);

    void updateHospital(Long id,Hospital newHospital);

//    List<Hospital> getAllHospitals(String name, String address);
}
