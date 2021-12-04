package com.example.ISAprojekat.Controller;


import com.example.ISAprojekat.Model.Admin;
import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.DTO.AdminDTO;
import com.example.ISAprojekat.Model.DTO.BoatDTO;
import com.example.ISAprojekat.Service.AdminService;
import com.example.ISAprojekat.Service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @GetMapping(value = "/all")
    public ResponseEntity<List<AdminDTO>> getAllAdmins() {

        List<Admin> admins = adminService.findAll();

        // convert boats to DTOs
        List<AdminDTO> adminDTOS = new ArrayList<>();
        for (Admin a : admins) {
            adminDTOS.add(new AdminDTO(a));
        }

        return new ResponseEntity<>(adminDTOS, HttpStatus.OK);
    }
}
