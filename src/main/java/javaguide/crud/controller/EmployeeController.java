package javaguide.crud.controller;

import javaguide.crud.dto.EmployeeDto;
import javaguide.crud.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //build add employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmploy= employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmploy, HttpStatus.CREATED);
    }

    //build get employee rest api
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") long employeeId){
       EmployeeDto employeeDto= employeeService.getEmployeeById(employeeId);
       return ResponseEntity.ok(employeeDto);
    }

    //build get all Employee
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
       List<EmployeeDto> employees=   employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //build Update employee
    
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto= employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    // build delete Employee
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully!");
    }
}
