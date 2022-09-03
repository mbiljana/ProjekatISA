package com.example.ISAprojekat.Controller;



import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.ISAprojekat.Model.DTO.IzmenaProfilaDTO;
import com.example.ISAprojekat.Model.DTO.KorisnikDTO;

import com.example.ISAprojekat.Repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Service.KorisnikService;

// Primer kontrolera cijim metodama mogu pristupiti samo autorizovani korisnici
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class KorisnikAccessAuthController {

    @Autowired
    private KorisnikService userService;

    //@Autowired
    //private AuthenticationManager authenticationManager;

    @Autowired
    private KorisnikRepository userRepository;

    //@Autowired
   // private TokenUtils tokenUtils;

    // Za pristup ovoj metodi neophodno je da ulogovani korisnik ima ADMIN ulogu
    // Ukoliko nema, server ce vratiti gresku 403 Forbidden
    // Korisnik jeste autentifikovan, ali nije autorizovan da pristupi resursu
    @GetMapping("/user/{userId}")
    //@PreAuthorize("hasRole('ADMIN')")
    public Korisnik loadById(@PathVariable Integer userId) {
        return this.userService.findOne(userId);
    }

    @GetMapping(value="/getById/{id}")
    //@PreAuthorize("hasAnyRole('ADMIN','COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR','CLIENT')")
    public ResponseEntity<KorisnikDTO> getById(@PathVariable Integer id){
        Korisnik user = userService.findOne(id);
        KorisnikDTO userDTO = new KorisnikDTO(user.getId(), user.getName(), user.getSurname(), user.getPhoneNumber(), user.getEmailAddress(), user.getPassword(), user.getUserStatus(), user.isEnabled(), user.getLastPasswordResetDate());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping(value="/getByEmail/{email}")
   // @PreAuthorize("hasAnyRole('ADMIN','COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR','CLIENT')")
    public ResponseEntity<KorisnikDTO> getByEmail(@PathVariable("email") String email){
        Korisnik user = userService.getByEmailAddress(email);
        KorisnikDTO userDTO = new KorisnikDTO(user.getId(), user.getName(), user.getSurname(), user.getPhoneNumber(), user.getEmailAddress(), user.getPassword(), user.getUserStatus(), user.isEnabled(), user.getLastPasswordResetDate());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    //po username-u
    @GetMapping(value="/getLoggedUser")
    //@PreAuthorize("hasAnyRole('ADMIN','COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR','CLIENT')")
    public ResponseEntity<KorisnikDTO> getLoggedUser(Principal principal){
        KorisnikDTO user=userService.getProfileInfo(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/user/all")
    public List<Korisnik> loadAll() {
        return this.userService.findAll();
    }

    /* transactional
    @DeleteMapping("/deleteUser/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        deleteUserService.deleteUser(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }*/

    /*@PutMapping (value="/changePassword/{password}")
    @PreAuthorize("hasAnyRole('ADMIN','COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR','CLIENT')")
    public ResponseEntity<UserTokenState> changePassword(@PathVariable String password, Principal principal) throws InterruptedException {
        String email = principal.getName();
        userService.updatePassword(principal.getName(), password);
        SecurityContextHolder.clearContext();
        Thread.sleep(1000);
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    email, password));
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Korisnik user = (Korisnik) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getUsername());
        int expiresIn = tokenUtils.getExpiredIn();
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn,user.getUloge().get(1).getName()));
    }*/

    //ne radi
    //ne moze da castuje admina za korisnika u serviceImpl
    @GetMapping("/passwordChanged")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Boolean> hasAdminChangedInitialPassword(Principal admin) {
        Boolean initialPasswordChanged = userService.hasAdminChangedInitialPassword(admin.getName());
        return new ResponseEntity<>(initialPasswordChanged, HttpStatus.OK);
    }

    @GetMapping("/whoami")
    //@PreAuthorize("hasRole('USER')")
    public Korisnik user(Principal user) {
        return this.userRepository.findByUsername(user.getName());
    }

    @GetMapping("/foo")
    public Map<String, String> getFoo() {
        Map<String, String> fooObj = new HashMap<>();
        fooObj.put("foo", "bar");
        return fooObj;
    }

    @PutMapping(value="/update")
    //@PreAuthorize("hasAnyRole('ADMIN','COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR','CLIENT')")
    public ResponseEntity<Void> updateUser(@RequestBody IzmenaProfilaDTO user) throws Exception {
        userService.updateDTO(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

