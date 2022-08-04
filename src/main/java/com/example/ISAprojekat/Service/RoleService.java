package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Role;
import com.example.ISAprojekat.Model.Uloga;

import java.util.List;

public interface RoleService {
    Uloga findById(Long id);
    List<Uloga> findByName(String name);
    Uloga findOneByName(String name);
}
