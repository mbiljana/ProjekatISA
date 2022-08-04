package com.example.ISAprojekat.Service.Impl;



import java.util.List;

import com.example.ISAprojekat.Model.Uloga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ISAprojekat.Model.Role;
import com.example.ISAprojekat.Repository.RoleRepository;
import com.example.ISAprojekat.Service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Uloga findById(Long id) {
        Uloga auth = this.roleRepository.getOne(id);
        return auth;
    }

    @Override
    public List<Uloga> findByName(String name) {
        List<Uloga> roles = this.roleRepository.findByName(name);
        return roles;
    }

    @Override
    public Uloga findOneByName(String name) {
        Uloga roles = this.roleRepository.findOneByName(name);
        return roles;
    }


}

