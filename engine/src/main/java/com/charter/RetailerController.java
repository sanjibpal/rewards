package com.charter;

import com.charter.entities.Retailer;
import com.charter.repositories.RetailerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RetailerController {

    private final RetailerRepository retailerRepository;

    /**
     * Return the list of Retailers with their details - like Name, email etc
     * @return list of Retailers
     */
    @GetMapping(value = "/v1/retailers")
    public List<Retailer> getRetailers() {
        return retailerRepository.findAll();
    }
}
