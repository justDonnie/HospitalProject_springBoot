package peaksoft.peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.peaksoft.entities.Doctor;
import peaksoft.peaksoft.entities.Patient;
import peaksoft.peaksoft.services.PatientService;

@Controller
@RequestMapping("/patients/{hospId}")
@RequiredArgsConstructor


public class PatientAPI {
    private final PatientService patientService;

    @GetMapping
    public String getAllPatients(Model model, @PathVariable Long hospId){
        model.addAttribute("allPatients",patientService.getAllPatients(hospId));
        return "/views/patient/allPatients";
    }

    @GetMapping("/new")
    public String createPatient(Model model, @PathVariable ("hospId") Long hospId){
        model.addAttribute("newPat", new Patient());
        model.addAttribute("hospId",hospId);
        return "/views/patient/newPat";
    }
    @PostMapping("/save")
    public String savePatient(@ModelAttribute Patient patient, @PathVariable("hospId")Long hospId){
        patientService.savePatient(patient,hospId);
        return "redirect:/patients/"+hospId;
    }



}
