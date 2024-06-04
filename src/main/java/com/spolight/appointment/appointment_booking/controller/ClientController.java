package com.spolight.appointment.appointment_booking.controller;

import com.spolight.appointment.appointment_booking.dao.ClientDao;
import com.spolight.appointment.appointment_booking.dao.ClientDaoInterface;
import com.spolight.appointment.appointment_booking.dao.EmployeeDaoImpl;
import com.spolight.appointment.appointment_booking.model.Client;
import com.spolight.appointment.appointment_booking.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1")
public class ClientController implements ClientDaoInterface {



    @Override
    @PostMapping(value = "/clients", produces = "application/json")
    public ResponseEntity< ? > addClient(@RequestBody Client c){
        int result = 0;
        result = ClientDao.insertClient(c);
        if (result != 0){
            return new ResponseEntity<>("User Added Successfully!", HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("Failed to Add User", HttpStatus.CONFLICT);
        }
    }


    @PutMapping(value = "/clients/{id}", produces = "application/json")
    public ResponseEntity<?> updateClient(@PathVariable long id,@RequestBody Client c) {
        int result = 0;
        System.out.println("Client going to update:"+id);
        result = ClientDao.updateClient(id,c);
        if (result != 0){
            return new ResponseEntity<>("Updated Successfully!", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Updation failed", HttpStatus.NOT_MODIFIED);
        }
    }


    @Override
    @DeleteMapping(value = "/clients/{id}", produces = "application/json")
    public ResponseEntity< ? > deleteClient(@PathVariable long id){
        int result = 0;
        result  = ClientDao.deleteClient(id);
        if (result != 0){
            return new ResponseEntity<>("User Deleted Successfully!", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Failed to Delete User:"+id,HttpStatus.CONFLICT);
        }
    }


    @Override
    @GetMapping(value = "/clients/{id}", produces = "application/json")
    public ResponseEntity< ? > getClient(@PathVariable long id){
        Client client = ClientDao.selectClient(id);
        if (client != null){
            return new ResponseEntity<>(client, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
        }
    }


    @Override
    @GetMapping(value = "/clients", produces = "application/json")
    public ResponseEntity<?> getClientList() {
        List<Client> list =  ClientDao.selectAllClients();
        if ( !list.isEmpty()){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
}
