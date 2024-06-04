package com.spolight.appointment.appointment_booking.controller;

import com.spolight.appointment.appointment_booking.dao.EmployeeDao;
import com.spolight.appointment.appointment_booking.dao.EmployeeDaoImpl;
import com.spolight.appointment.appointment_booking.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeController implements EmployeeDao {


    @Override
    @PostMapping(value = "/employee", produces = "application/json")
    public ResponseEntity<?> createEmployee(@RequestBody Employee e) {
        int result = 0;
        System.out.println("New Employee Creating: "+e.getFirstName());
        result = EmployeeDaoImpl.createEmployee(e);
        if (result != 0){
            return new ResponseEntity<>("Employee Created Successfully!", HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("Failed to create employee",HttpStatus.CONFLICT);
        }
    }

    @Override
    @PutMapping(value = "/employee/{id}", produces = "application/json")
    public ResponseEntity<?> updateEmployee(@PathVariable long id,@RequestBody Employee e) {
        int result = 0;
        System.out.println("Employee going to update:"+id);
        result = EmployeeDaoImpl.updateEmployee(id,e);
        if (result != 0){
            return new ResponseEntity<>("Updated Successfully!", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Updation failed", HttpStatus.NOT_MODIFIED);
        }
    }

    @Override
    @DeleteMapping(value = "/employee/{id}", produces = "application/json")
    public ResponseEntity<?> deleteEmployee(long id) {
        int result = 0;
        System.out.println("Employee going to delete: "+id);
        result = EmployeeDaoImpl.deleteEmployee(id);
        if(result != 0){
            return new ResponseEntity<>("Delete successfully!", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Failed to delete", HttpStatus.CONFLICT);
        }
    }

    @Override
    @GetMapping(value = "/employee/{id}", produces = "application/json")
    public ResponseEntity<?> getEmployee(long id) {
        Employee employee = null;
        employee = EmployeeDaoImpl.getEmployee(id);
        if (employee != null){
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @GetMapping(value = "/employee",produces = "application/json")
    public ResponseEntity<?> getAllEmployee() {
        List<Employee> employeeList = EmployeeDaoImpl.getAllEmployee();
        if ( !employeeList.isEmpty()){
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
