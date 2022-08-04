package com.example.ISAprojekat.Controller;



import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.ISAprojekat.Repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Service.KorisnikService;

// Primer kontrolera cijim metodama mogu pristupiti samo autorizovani korisnici
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class KorisnikAccessAuthController {

    @Autowired
    private KorisnikService userService;


    @Autowired
    private KorisnikRepository userRepository;

    // Za pristup ovoj metodi neophodno je da ulogovani korisnik ima ADMIN ulogu
    // Ukoliko nema, server ce vratiti gresku 403 Forbidden
    // Korisnik jeste autentifikovan, ali nije autorizovan da pristupi resursu
    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Korisnik loadById(@PathVariable Long userId) {
        return this.userService.findOne(userId);
    }

    @GetMapping("/user/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Korisnik> loadAll() {
        return this.userService.findAll();
    }

    @GetMapping("/whoami")
    @PreAuthorize("hasRole('USER')")
    public Korisnik user(Principal user) {
        return this.userRepository.findByUsername(user.getName());
    }

    @GetMapping("/foo")
    public Map<String, String> getFoo() {
        Map<String, String> fooObj = new HashMap<>();
        fooObj.put("foo", "bar");
        return fooObj;
    }
}

