package net.codejava.RestController;


import net.codejava.Exceptions.ResourceNotFoundException;
import net.codejava.Model.Department;
import net.codejava.Exceptions.ApiRequestException;

import net.codejava.Model.Student;
import net.codejava.Repository.DepartmentRepository;
import net.codejava.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentRestController {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private DepartmentRepository departmentRepo;

    @PostMapping("/students/save")
    public Student saveStudent(@RequestBody Student student){

        return studentRepo.save(student);
    }

    @GetMapping("/students")
    public List<Student> listStudents(){
        try {
            return studentRepo.findAll();
        } catch (Exception e){
            throw new ApiRequestException("Not find student");
        }
    }

    @GetMapping("students/edit/{id}")
    public Student showEditStudent(@PathVariable("id") Integer id, Model model) {

        try {
            return studentRepo.findById(id).get();
        } catch (Exception e) {
            throw new ApiRequestException("Not find id " + id);
        }

    }

    @PutMapping("students/edit/{id}")
    public Student updateStudent(@PathVariable Integer id,@RequestBody Student student){
        Student updateStudent = studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found" + id));

        updateStudent.setName(student.getName());
        updateStudent.setStudentNumber(student.getStudentNumber());
        updateStudent.setDepartment(student.getDepartment());

        return  studentRepo.save(updateStudent);
    }

    @DeleteMapping("students/delete/{id}")
    public Student deleteStudent(@PathVariable("id") Integer id){
        Student student = studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found" + id));

        studentRepo.delete(student);
        return new Student();
    }

}
