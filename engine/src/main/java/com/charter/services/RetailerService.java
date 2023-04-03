package com.charter.services;

import com.charter.dto.RetailerDto;
import com.charter.entities.Retailer;
import com.charter.repositories.RetailerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class RetailerService {
    private final RetailerMapper mapper;
    private final RetailerRepository retailerRepository;

    public List<Retailer> findAllRetailers() {
        return retailerRepository.findAll();
    }
    public Retailer addRetailer(RetailerDto retailerDto) {
        retailerDto.setPassword(new BCryptPasswordEncoder().encode(retailerDto.getPassword()));
        Retailer retailer = mapper.updateCustomerFromDto(retailerDto);
        retailerRepository.save(retailer);
        return retailer;
    }

    public Retailer login(RetailerDto retailerDto) {
        return retailerRepository.findByEmailAndPassword(retailerDto.getEmail(), retailerDto.getPassword());
    }
}
