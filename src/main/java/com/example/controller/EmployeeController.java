package com.example.controller;


import com.example.dto.EmployeeDto;
import com.example.model.Department;
import com.example.model.Employee;
import com.example.repository.DepartmentRepo;
import com.example.repository.EmployeeRepo;
import com.example.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

// Annotation
@RestController
// Class
public class EmployeeController
{
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService)
   {
       this.employeeService = employeeService;
   }
    @Autowired
    private EmployeeRepo repo;
    @Autowired
    private DepartmentRepo drepo;


    @PostMapping("/add-employee")
    public String saveEmployee(@Valid @RequestBody Employee emp,@RequestParam String departmentName)
    {
        Instant instant = Instant.now();
        emp.setCreatedDate(instant);
        // Retrieve or create the department
        Department department = drepo.findByName(departmentName);
        if (department == null) {
            department = new Department();
            department.setName(departmentName);
            drepo.save(department);
        }

        emp.setDepartment(department); // Set the department reference
        repo.save(emp);
        return "Added Successfully";

        //--not required to uncomment

//        Department department = drepo.findByName(emp.getDepartment());
//        if (department.getName() == null) {
//            department = new Department();
//            department.setName(department.getName());
//            drepo.save(department);
//
//        }
//        repo.save(emp);
//        return "Added Successfully";


    }

//---------------second-----
//    @PostMapping("/add-employee")
//    public String saveBooks(@Valid @RequestBody Employee emp, @RequestParam Department departmentName){
//        Instant instant = Instant.now();
//        emp.setCreatedDate(instant);
//
//        // Retrieve or create the department based on departmentName
//        Department department = drepo.findByName(departmentName);
//        if (department == null) {
//            department = new Department();
//            department.setName(departmentName);
//            drepo.save(department);
//        }
//
//        emp.setDepartment(department); // Set the department reference
//        repo.save(emp);
//        return "Added Successfully";
//    }

    @GetMapping("/get-emp")
    public List<Employee> getEmployees()
    {

//        System.out.println("GET request to /get-emp"); // Add this line for debugging
//        List<Employee> all = repo.findAll();
//        System.out.println("Retrieved " + employees.size() + " employees"); // Add this line for debugging
//        return all;

        return repo.findAll();
    }

//-----------------------first--------
    @PutMapping("update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeDto employeeDto,@RequestParam String departmentName)
    {
        Employee employee = employeeService.updateEmployee(employeeDto);
        Instant instant = Instant.now();
        employee.setCreatedDate(instant);

        Department department = drepo.findByName(departmentName);
        if (department == null) {
            department = new Department();
            department.setName(departmentName);
            drepo.save(department);
        }
        employee.setDepartment(department);

        return ResponseEntity.ok(employee);
    }


    //-------------second------------------
//    @PutMapping("update")
//    public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeDto employeeDto, @RequestParam Department departmentName)
//    {
//        Employee employee = employeeService.updateEmployee(employeeDto);
//        Instant instant = Instant.now();
//        employee.setCreatedDate(instant);
//
//        // Retrieve or create the department based on departmentName
//        Department department = drepo.findByName(departmentName);
//        if (department == null) {
//            department = new Department();
//            department.setName(departmentName);
//            drepo.save(department);
//        }
//
//        employee.setDepartment(department);
//
//        return ResponseEntity.ok(employee);
//    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id){
        repo.deleteById(id);
        return "Deleted Successfully";
    }

}

