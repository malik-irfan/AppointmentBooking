package com.spolight.appointment.appointment_booking.dao;

import com.spolight.appointment.appointment_booking.model.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Employee",description = "Operations about employee")
public interface EmployeeDao {



    @Operation(
            summary = "Create employee",
            description = "Create a new employee entity and its data in data source"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "successful operation")
    })
    ResponseEntity< ? > createEmployee(@RequestBody Employee e);



    @Operation(
            summary = "Update employee",
            description = "Update employee entity data in data source"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "successful operation")
    })
    ResponseEntity< ? > updateEmployee(@Parameter(
            description = "ID of employee to be update",
            required = true)
            @PathVariable long id,
           @Parameter(
                   description = "Employee data to be update",
                   required = true)
           @RequestBody Employee e);



    @Operation(
            summary = "Delete employee",
            description = "Delete employee entity and its data from data source"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "successful operation")
    })
    ResponseEntity< ? > deleteEmployee(@PathVariable long id);



    @Operation(
            summary = "Get employee by id",
            description = "Fetch employee(by id) entity and its data from data source"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "successful operation")
    })
    ResponseEntity< ? > getEmployee(@Parameter(
            description = "ID of employee to be retrieved",
            required = true)
            @PathVariable long id);


    @Operation(
            summary = "Get list of all employee`s",
            description = "Fetch all employee entities and their data from data source"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "successful operation")
    })
    ResponseEntity<?> getAllEmployee();
}
