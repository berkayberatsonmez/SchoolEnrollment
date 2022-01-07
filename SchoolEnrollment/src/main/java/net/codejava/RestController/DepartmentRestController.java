package net.codejava.RestController;

import net.codejava.Exceptions.ResourceNotFoundException;
import net.codejava.Model.Department;
import net.codejava.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @DeleteMapping("departments/delete/{id}")
    public List<Department> deleteDepartment(@PathVariable("id") Integer id){
        Department department = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found" + id));

        repo.delete(department);
        return repo.findAll();
    }

    @PutMapping("departments/edit/{id}")
    public Department updateDepartment(@PathVariable Integer id,@RequestBody Department department){
        Department updateDepartment = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found" + id));

        updateDepartment.setName(department.getName());

        return  repo.save(updateDepartment);
    }




}
