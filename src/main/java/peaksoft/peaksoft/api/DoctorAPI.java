package peaksoft.peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.peaksoft.entities.Doctor;
import peaksoft.peaksoft.services.DepartmentService;
import peaksoft.peaksoft.services.DoctorService;

@Controller
@RequestMapping("/doctors/{hospId}")
@RequiredArgsConstructor

public class DoctorAPI {
    private final DoctorService doctorService;
    private final DepartmentService departmentService;
    @GetMapping
    public String getAllDocs(Model model, @PathVariable Long hospId){
        model.addAttribute("allDoctors",doctorService.getAllDoctors(hospId));
        return "views/doctor/allDoctors";
    }
    @GetMapping("/new")
    public String createDoctor(Model model, @PathVariable ("hospId") Long hospId){
        model.addAttribute("newDoc", new Doctor());
        model.addAttribute("hospId",hospId);
        return "views/doctor/newDoc";
    }
    @PostMapping("/save")
    public String saveDoctor(@ModelAttribute Doctor doctor, @PathVariable("hospId")Long hospId){
        doctorService.saveDoctor(doctor,hospId);
        return "redirect:/doctors/"+hospId;
    }
    @GetMapping("/enter/{docId}")
    public String enterToDocsChapter(@PathVariable Long docId, @PathVariable Long hospId){
        doctorService.getDoctorByHospitalId(docId,hospId);
        return "/views/doctor/enterToDocsChapter";
    }

    @GetMapping("/update/{docId}")
    public String updatePage (@PathVariable Long docId,@PathVariable Long hospId, Model model){
        model.addAttribute("docId",docId);
        model.addAttribute("currentDoctor",doctorService.getDoctorById(docId));
        return "views/doctor/docUpdatePage";
    }

    @PostMapping("/editDoc/{docId}")
    public String editDoc(@ModelAttribute("currentDoctor") Doctor newDoctor,
                          @PathVariable Long docId,
                          @PathVariable Long hospId){
        doctorService.updateDoctor(docId,newDoctor);
        return "redirect:/doctors/" + hospId;
    }
    @GetMapping("/delete/{docId}")
    public String deleteDoc(@PathVariable Long docId,
                            @PathVariable("hospId") Long hospId){
        doctorService.deleteDoctor(docId);
        return "redirect:/doctors/" +hospId;
    }
    @GetMapping("/assign/{docId}")
    public String assignPage(@PathVariable Long docId,@PathVariable("hospId")Long hospId,Model model){
        model.addAttribute("allDepartments",departmentService.getAllDepartments(hospId));
        model.addAttribute("docId",docId);
        return "views/doctor/assignPage";
    }
    @PostMapping("/accept/{docId}")
    public String acceptAssign(@PathVariable Long docId, Long depId, @PathVariable String hospId){
        departmentService.assignDocToDep(docId,depId);
        return "redirect:/doctors/"+hospId;
    }


}
