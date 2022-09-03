package com.example.ISAprojekat.Controller;



import com.example.ISAprojekat.Model.Admin;

import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Repository.KorisnikRepository;
import com.example.ISAprojekat.Service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

  //  @Autowired
    //private TokenUtils tokenUtils;

    @Autowired
    private KorisnikRepository korisnikRepository;

    //@Autowired
    //private AuthenticationManager authenticationManager;

    @Autowired
    private KorisnikService userService;

    // Prvi endpoint koji pogadja korisnik kada se loguje.
    // Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
    /*@PostMapping("/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {

        // Ukoliko kredencijali nisu ispravni, logovanje nece biti uspesno, desice se
        // AuthenticationException
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        // Ukoliko je autentifikacija uspesna, ubaci korisnika u trenutni security
        // kontekst
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Kreiraj token za tog korisnika
        Korisnik user = (Korisnik) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getUsername());
        int expiresIn = tokenUtils.getExpiredIn();

        // Vrati token kao odgovor na uspesnu autentifikaciju
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
    }*/

    // Endpoint za registraciju novog korisnika
    /*@PostMapping("/signup")
    public ResponseEntity<Korisnik> addUser(@RequestBody UserAuthentificationRequestDTO userRequest, UriComponentsBuilder ucBuilder) {

        Korisnik existUser = this.korisnikRepository.findByUsername(userRequest.getUsername());

        if (existUser != null) {
            throw new ResourceConflictException(userRequest.getId(), "Username already exists");
        }

        Korisnik user = this.userService.save(userRequest);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

   /* @PostMapping("/registerAdmin")
    public ResponseEntity<Admin> registerNewAdmin(@RequestBody Korisnik newAdminUser) throws Exception {
        if(this.userService.findByEmail(newAdminUser.getEmailAddress()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists!");
        }

        Admin addedAdmin = this.userService.save(newAdminUser);
        return new ResponseEntity<>(addedAdmin, HttpStatus.CREATED);
    }*/

    /*@PostMapping("/logout")
    public ResponseEntity<Void> Logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
