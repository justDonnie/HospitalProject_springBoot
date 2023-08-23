package peaksoft.peaksoft.services.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.peaksoft.entities.Hospital;
import peaksoft.peaksoft.repositories.HospitalRepository;
import peaksoft.peaksoft.services.HospitalService;

import java.util.List;


@Service
@RequiredArgsConstructor

public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository hospitalRepository;

    @Override
    public void saveHospital(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital getHospitalById(Long hospId) {
        return hospitalRepository.findById(hospId)
                .orElseThrow(()-> new RuntimeException(" Hospital with ID "+hospId+" not found !!!"));
    }

    @Override
    public void deleteHospital(Long id) {
        hospitalRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updateHospital(Long hospitalId, Hospital newHospital) {
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new RuntimeException(" Hospital with ID " + hospitalId + " is not found!!!"));
        hospital.setName(newHospital.getName());
        hospital.setAddress(newHospital.getAddress());
        hospital.setImage(newHospital.getImage());
        hospitalRepository.save(hospital);
    }

//    @Override
//    public List<Hospital> getAllHospitals(String name, String address) {
//        if(name != null & address == null){
//            return hospitalRepository.findAllByName(name);
//        }
//        return hospitalRepository.getAllHospitals();
//    }
}
