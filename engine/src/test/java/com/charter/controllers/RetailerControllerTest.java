package com.charter.controllers;

import com.charter.dto.RetailerDto;
import com.charter.entities.Retailer;
import com.charter.services.RetailerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class RetailerControllerTest {

    @Mock
    private RetailerService retailerService;

    private RetailerController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        controller = new RetailerController(retailerService);
    }

    @Test
    void testGetRetailers() {
        // Given
        List<Retailer> retailers =
                List.of(
                    Retailer.builder().id(1L).firstName("Retailer 1").email("retailer1@example.com").build(),
                    Retailer.builder().id(2L).firstName("Retailer 2").email("retailer2@example.com").build());
        when(retailerService.findAllRetailers()).thenReturn(retailers);

        // When
        List<Retailer> result = controller.getRetailers();

        // Then
        assertEquals(retailers, result);
    }

    @Test
    void testGetRetailersWithNoRetailers() {
        // Given
        List<Retailer> retailers = Collections.emptyList();
        when(retailerService.findAllRetailers()).thenReturn(retailers);

        // When
        List<Retailer> result = controller.getRetailers();

        // Then
        assertTrue(result.isEmpty());
    }

    @Test
    void addRetailers_ShouldReturnRetailerId_WhenRetailerAddedSuccessfully() {
        // Given
        RetailerDto retailerDto = new RetailerDto();
        Retailer retailer = Retailer.builder().id(1L).build();

        when(retailerService.addRetailer(any(RetailerDto.class))).thenReturn(retailer);

        // When
        Long retailerId = controller.addRetailers(retailerDto);

        // Then
        assertThat(retailerId).isEqualTo(1L);
    }

    @Test
    void login_ShouldReturnHttpStatusOk_WhenRetailerLoggedInSuccessfully() {
        // Given
        RetailerDto retailerDto = new RetailerDto();
        Retailer retailer = Retailer.builder().id(1L).build();

        when(retailerService.login(any(RetailerDto.class))).thenReturn(retailer);

        // When
        ResponseEntity<String> response = controller.login(retailerDto);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void login_ShouldReturnHttpStatusUnauthorized_WhenRetailerLoginFails() {
        // Given
        RetailerDto retailerDto = new RetailerDto();

        when(retailerService.login(any(RetailerDto.class))).thenReturn(null);

        // When
        ResponseEntity<String> response = controller.login(retailerDto);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }
}
