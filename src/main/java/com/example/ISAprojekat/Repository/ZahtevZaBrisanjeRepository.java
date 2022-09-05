package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.DTO.ZahtevZaBrisanjeDTO;
import com.example.ISAprojekat.Model.ZahtevZaBrisanje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZahtevZaBrisanjeRepository extends JpaRepository<ZahtevZaBrisanje,Long> {
}
