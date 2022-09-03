package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.PriceListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceListItemRepository extends JpaRepository<PriceListItem, Integer> {
}
