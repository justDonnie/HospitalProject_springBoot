package peaksoft.peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.peaksoft.entities.Hospital;
import peaksoft.peaksoft.services.HospitalService;

@Controller
@RequestMapping("/views/hospitals")
@RequiredArgsConstructor
public class HospitalAPI {
    private final HospitalService hospitalService;

    @GetMapping
    public String getAllHospitals(Model model){
        model.addAttribute("allHospitals",hospitalService.getAllHospitals());
        return "views/hospital/getAll";
    }
    @GetMapping("/new")
    public String createHospital(Model model){
        model.addAttribute("newHospital",new Hospital());
        return "views/hospital/newHospital";
    }
    @PostMapping("/save")
    public String saveHospital(@ModelAttribute("newHospital") Hospital hospital){
        hospitalService.saveHospital(hospital);
        return "redirect:/views/hospitals";
    }

    @GetMapping("/delete/{hospitalId}")
    public String deleteHospital(@PathVariable ("hospitalId")Long hospId){
        hospitalService.deleteHospital(hospId);
        return "redirect:/views/hospitals";
    }
    @GetMapping("update/{hospitalId}")
    public String updatePage(@PathVariable Long hospitalId, Model model){
        model.addAttribute("currentHospital",hospitalService.getHospitalById(hospitalId));
        return "views/hospital/updatePage";
    }
    @PostMapping("/edit/{hospitalId}")
    public String editHospital(@ModelAttribute Hospital newHospital,
                               @PathVariable Long hospitalId){
        hospitalService.updateHospital(hospitalId,newHospital);
        return "redirect:/views/hospitals";
    }
    @GetMapping("/{hospitalId}/enter")
    public String enterToHospital(@PathVariable Long hospitalId, Model model) {
        Hospital hospital = hospitalService.getHospitalById(hospitalId);
        model.addAttribute("hospital", hospital);
        return "views/hospital/enterToHospital";
    }







}
