package com.eployees.data.employe_db.controller;

import com.eployees.data.employe_db.exception.ResourceNotFoundException;
import com.eployees.data.employe_db.dao.EmployeeRepository;
import com.eployees.data.employe_db.model.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //get employees
    @GetMapping("/employees")
    public List<EmployeeDetails> getAllEmployee(){
        return employeeRepository.findAll();
    }
    //get employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDetails> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        EmployeeDetails employee = (EmployeeDetails) employeeRepository.findAllById(employeeId).
                orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id:: "+ employeeId));
        return ResponseEntity.ok().body(employee);
    }
    //save employee
    @PostMapping("/employees")
    public EmployeeDetails createEmployee(@RequestBody EmployeeDetails employee){
        EmployeeDetails emp = new EmployeeDetails(employee.getName(),employee.getAge(),employee.getAddress(),employee.getSalary());
        return employeeRepository.save(emp);
    }

    //update employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDetails> updateEmployee(@PathVariable(value = "id") Long employeeId, @Valid @RequestBody EmployeeDetails employeeDetails) throws ResourceNotFoundException {
        EmployeeDetails employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id:: "+ employeeId));
        employee.setName(employeeDetails.getName());
        employee.setAge(employeeDetails.getAge());
        employee.setAddress(employeeDetails.getAddress());
        employee.setSalary(employeeDetails.getSalary());
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    //delete employee
    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        EmployeeDetails employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
