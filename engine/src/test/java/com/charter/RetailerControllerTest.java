package com.charter;

import com.charter.entities.Retailer;
import com.charter.repositories.RetailerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class RetailerControllerTest {

    @Mock
    private RetailerRepository retailerRepository;

    private RetailerController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        controller = new RetailerController(retailerRepository);
    }

    @Test
    void testGetRetailers() {
        // Given
        List<Retailer> retailers =
                List.of(
                    Retailer.builder().id(1L).firstName("Retailer 1").email("retailer1@example.com").build(),
                    Retailer.builder().id(2L).firstName("Retailer 2").email("retailer2@example.com").build());
        when(retailerRepository.findAll()).thenReturn(retailers);

        // When
        List<Retailer> result = controller.getRetailers();

        // Then
        assertEquals(retailers, result);
    }

    @Test
    void testGetRetailersWithNoRetailers() {
        // Given
        List<Retailer> retailers = Collections.emptyList();
        when(retailerRepository.findAll()).thenReturn(retailers);

        // When
        List<Retailer> result = controller.getRetailers();

        // Then
        assertTrue(result.isEmpty());
    }
}
