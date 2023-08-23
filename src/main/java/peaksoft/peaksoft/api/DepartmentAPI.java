package peaksoft.peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.peaksoft.entities.Department;
import peaksoft.peaksoft.services.DepartmentService;


@Controller
@RequestMapping("/departments/{hospId}")
@RequiredArgsConstructor

public class DepartmentAPI {
    private final DepartmentService departmentService;

    @GetMapping
    public String getAllDeps(Model model, @PathVariable Long hospId) {
        model.addAttribute("allDepartments", departmentService.getAllDepartments(hospId));
        return "views/department/allDepartment";
    }


    @GetMapping("/new")
    public String createDep(Model model, @PathVariable("hospId") Long hospId) {
        model.addAttribute("newDep", new Department());
        model.addAttribute("hospId", hospId);
        return "views/department/newDep";
    }
///{hospId}/save
    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute Department department, @PathVariable("hospId") Long hospId) {
        departmentService.saveDepartment(department, hospId);
        return "redirect:/departments/"+hospId;
    }
///departments/{hospId}/enter/{depId}
    @GetMapping("/enter/{depId}")
    public String enterToDepsChapter(@PathVariable Long depId, @PathVariable Long hospId) {
       departmentService.findDepartmentByHospitalId(depId, hospId);
        return "views/department/enterToDepsChapter";
    }

    @GetMapping("/update/{depId}")
    public String updatePage (@PathVariable Long depId,@PathVariable Long hospId, Model model){
        model.addAttribute("depId",depId);
        model.addAttribute("currentDepartment",departmentService.getDepartmentById(depId));
        return "views/department/updatePage";
    }
    //departments/{hospId}/edit/{depId}
    @PostMapping("/edit/{depId}")
    public String editDep (@ModelAttribute("currentDepartment") Department newDepartment,
                           @PathVariable Long depId,
                           @PathVariable Long hospId){
        departmentService.updateDepartment(depId,newDepartment);
        return "redirect:/departments/" + hospId;
    }
    @GetMapping("/delete/{depId}")
    public String deleteDep(@PathVariable Long depId,
                            @PathVariable("hospId") Long hospId){
        departmentService.deleteDepartment(depId);
        return "redirect:/departments/" +hospId;
    }

}
