package net.codejava.Controller;

import net.codejava.Exceptions.ApiRequestException;
import net.codejava.Repository.DepartmentRepository;
import net.codejava.Model.Student;
import net.codejava.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import net.codejava.Model.Department;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private DepartmentRepository departmentRepo;

    @GetMapping("/students/new")
    public String showNewStudentForm(Model model){
        List<Department> listDepartments = departmentRepo.findAll();

        model.addAttribute("student", new Student());
        model.addAttribute("listDepartments", listDepartments);

        return "student_form";
    }

    @PostMapping("/students/save")
    public String saveStudent(Student student){
        studentRepo.save(student);

        return "redirect:/students";
    }

    @GetMapping("/students")
    public String listStudents(Model model){
        try {
            List<Student> listStudents = studentRepo.findAll();
            model.addAttribute("listStudents", listStudents);

            return "students";
        } catch (Exception e){
            throw new ApiRequestException("Not find student ");
        }
    }

    @GetMapping("students/edit/{id}")
    public String showEditStudentForm(@PathVariable("id") Integer id, Model model) {
        try {
            Student student = studentRepo.findById(id).get();
            model.addAttribute("student", student);

            List<Department> listDepartments = departmentRepo.findAll();


            model.addAttribute("listDepartments", listDepartments);


            return "student_form";
        } catch (Exception e){
            throw new ApiRequestException("Not find id " + id);
        }
    }
    @GetMapping("students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
            studentRepo.deleteById(id);

            return "redirect:/students";

    }
}
