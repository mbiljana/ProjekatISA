package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Admin;
import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Model.Korisnik;

import java.util.List;

public interface AdminService {
    Admin getByUsernameAndPassword(String username, String password);
     List<Admin> findAll();
    Admin getOne(Long id);
    Admin findOne(Long id);
    Admin update(Admin admin) throws Exception;
}
