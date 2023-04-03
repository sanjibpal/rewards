package com.charter.controllers;

import com.charter.dto.RetailerDto;
import com.charter.entities.Retailer;
import com.charter.services.RetailerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class RetailerController {

    private final RetailerService retailerService;

    /**
     * Return the list of Retailers with their details - like Name, email etc
     * @return list of Retailers
     */
    @GetMapping(value = "/v1/retailers")
    public List<Retailer> getRetailers() {
        return retailerService.findAllRetailers();
    }

    /**
     * Register a retailer
     * @param retailer retailer Information
     * @return retailer Id
     */
    @PostMapping(value = "/p1/retailer")
    public Long addRetailers(@RequestBody RetailerDto retailer) {
        return retailerService.addRetailer(retailer).getId();
    }

    /**
     * TODO Not Complete
     * Login the retailer with email nad password
     * @param retailer retailer Information
     * @return login status
     */
    @PostMapping(value = "/p1/retailer/login")
    public ResponseEntity<String> login(@RequestBody RetailerDto retailer) {
        if(Objects.nonNull(retailerService.login(retailer))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
