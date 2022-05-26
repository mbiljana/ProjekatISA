package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.Admin;
import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Repository.AdminRepository;
import com.example.ISAprojekat.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin getByUsernameAndPassword(String username, String password) {
        Admin admin = this.adminRepository.findByUsernameAndPassword(username,password);
        return admin;
    }


    @Override
    public List<Admin> findAll(){
        return adminRepository.findAll();
    }

    @Override
    public Admin getOne(Long id) {
        Admin admin = this.adminRepository.findById(id).get();
        return admin;
    }


}
