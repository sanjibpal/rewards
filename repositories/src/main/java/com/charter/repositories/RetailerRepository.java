package com.charter.repositories;


import com.charter.entities.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetailerRepository extends JpaRepository<Retailer, Long> {
}
