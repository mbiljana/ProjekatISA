package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Repository.AdminRepository;
import com.example.ISAprojekat.Service.AdminService;
import com.example.ISAprojekat.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @Autowired
    private RoleService roleService;

    @Override
    public Admin getByUsernameAndPassword(String username, String password) {
        Admin admin = this.adminRepository.findByUsernameAndPassword(username,password);
        return admin;
    }

    @Override
    public Admin findOne(Integer id) {

        Admin admin = this.adminRepository.findById(id).get();
        return admin;
    }

    @Override
    public List<Admin> findAll(){
        return adminRepository.findAll();
    }

    @Override
    public Admin getOne(Integer id) {
        Admin admin = this.adminRepository.findById(id).get();
        return admin;
    }

    public Admin update (Admin admin) throws Exception{
        Admin updated = this.adminRepository.findById(admin.getId()).get();
        if(admin.getId() == null){
            throw  new Exception("Greska! Nepostojeci korisnik!");
        }
        updated.setName(admin.getName());
        updated.setSurname(admin.getSurname());
        updated.setUsername(admin.getUsername());
        updated.setEmailAddress(admin.getEmailAddress());
        updated.setRole(admin.getRole());
        updated.setPhoneNumber(admin.getPhoneNumber());
        updated.setState(admin.getState());
        updated.setPassword(admin.getPassword());
        updated.setHomeAddress(admin.getHomeAddress());
        updated.setCity(admin.getCity());
        updated.setBirthDate(admin.getBirthDate());
        Admin promenjen = adminRepository.save(updated);
        return promenjen;
    }



}
