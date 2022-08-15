package com.example.ISAprojekat.Controller;

import com.example.ISAprojekat.Model.Appointment;
import com.example.ISAprojekat.Model.DTO.AppointmentDTO;
import com.example.ISAprojekat.Model.DTO.SaleDTO;
import com.example.ISAprojekat.Model.Sale;
import com.example.ISAprojekat.Service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = "/app", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class SaleController {

    /*@Autowired
    private SaleService saleService;

    @GetMapping("/instructor")
    @PreAuthorize("hasAnyRole('INSTRUCTOR', 'ADMIN')")
    public ResponseEntity<Set<SaleDTO>> getAllSalesForLoggedInstructor(Principal principal) {
        Set<Sale> sales = saleService.getAllSalesForLoggedInstructor(principal.getName());
        Set<SaleDTO> dto = getSaleDTOS(sales);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    private Set<SaleDTO> getSaleDTOS(Set<Sale> sales) {
        Set<SaleDTO> dto = new HashSet<>();
        for(Sale s : sales) {
            SaleDTO saleDTO = new SaleDTO(s.getId(), s.getDateTimeFrom(), s.getDurationInHours(), s.getMaximumPersons(), s.getExpireDateTime(), s.getAdditionalServices(), s.getPrice());
            saleDTO.setEntityName(s.getRentingEntity().getName());
            dto.add(saleDTO);
        }
        return dto;
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAnyRole('COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR', 'ADMIN')")
    public ResponseEntity<SaleDTO> createSaleForEntity(@RequestBody Sale sale, @PathVariable("id") Integer entityId) {
        Sale newSale = saleService.createSaleForEntity(sale, entityId);
        SaleDTO saleDTO = new SaleDTO(newSale.getId(), newSale.getDateTimeFrom(), newSale.getDurationInHours(), newSale.getMaximumPersons(), newSale.getExpireDateTime(), newSale.getAdditionalServices(), newSale.getPrice());
        return new ResponseEntity<>(saleDTO, HttpStatus.CREATED);
    }*/
}
