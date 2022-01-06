package net.codejava.RestController;

import net.codejava.Model.Department;
import net.codejava.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class DepartmentRestController {

    @Autowired
    private DepartmentRepository repo;

    @GetMapping("/departments")
    public List<Department> departmentList(){

        return repo.findAll();
    }
   
    @PostMapping("/departments/save")
    public Department saveDepartment(@RequestBody Department department){

        return repo.save(department);
    }




}
