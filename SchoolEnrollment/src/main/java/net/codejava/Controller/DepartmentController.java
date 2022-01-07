package net.codejava.Controller;

import net.codejava.Exceptions.ApiRequestException;
import net.codejava.Model.Department;

import net.codejava.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;


@Controller
public class DepartmentController {

    @Autowired
    private DepartmentRepository repo;

    @GetMapping("/departments")
    public String listDepartments(Model model){
        List<Department> listDepartments = repo.findAll();
        model.addAttribute("listDepartments", listDepartments);

        return "departments";
    }
    @GetMapping("/departments/new")
    public String showDepartmentNewForm(Model model){
        model.addAttribute("department", new Department());

        return "department_form";
    }

    @PostMapping("/departments/save")
    public String saveDepartment(Department department){
        repo.save(department);

        return "redirect:/departments";
    }

    @GetMapping("departments/edit/{id}")
    public String showEditDepartmentForm(@PathVariable("id") Integer id, Model model) {
        try {
            Department department = repo.findById(id).get();
            model.addAttribute("department", department);

            return "department_form";
        } catch (Exception e){
            throw new ApiRequestException("Not find id " + id);
        }
    }

    @GetMapping("departments/delete/{id}")
    public String deleteDepartment(@PathVariable("id") Integer id) {
        try{
            repo.deleteById(id);

            return "redirect:/departments";
        } catch (Exception e){
            throw new ApiRequestException("You have a student from that department " + id);
        }

    }

}
