package com.spolight.appointment.appointment_booking.dao;

import com.spolight.appointment.appointment_booking.model.Client;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name = "Client",description = "Operation about client")
public interface ClientDaoInterface {




    @Operation(
            summary = "Fetch all clients",
            description = "Fetch all clients entities and their data from data source"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "successful operation")
    })
    ResponseEntity<?> getClientList();


    @Operation(
            summary = "Fetch client against provided id",
            description = "Fetch client entity and its data from data source"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "successful operation")
    })
    ResponseEntity< ? > getClient(@Parameter(
            description = "ID of client to be retrieved",
            required = true)
            @PathVariable long id);


    @Operation(
            summary = "Delete client against provided id",
            description = "Delete client entity and its data from data source"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "successful operation")
    })
    ResponseEntity< ? > deleteClient(@PathVariable long id);


    @Operation(
            summary = "Add new client",
            description = "Add new client entity and its data in data source"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "successful operation")
    })
    ResponseEntity< ? > addClient(@RequestBody Client c);
}
