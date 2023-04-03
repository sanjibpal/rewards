package com.charter.controllers;

import com.charter.dto.TransactionDto;
import com.charter.entities.Point;
import com.charter.entities.Retailer;
import com.charter.repositories.PointRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class RewardsControllerTest {
    @Mock
    private PointRepository pointRepository;

    RewardsController rewardsController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        rewardsController = new RewardsController(pointRepository);
    }

    @Test
    public void testGetRewardsDetails() {
        // Arrange
        Long retailerId = 1L;
        Retailer retailer = Retailer.builder().id(retailerId).firstName("Test D").build();
        List<Point> expectedPoints = List.of(
            Point.builder().id(1L).points(100).entryTime(LocalDateTime.now()).retailer(retailer).build(),
            Point.builder().id(2L).points(200).entryTime(LocalDateTime.now()).retailer(retailer).build());
        when(pointRepository.findAllByRetailerId(retailerId)).thenReturn(expectedPoints);

        // Act
        List<Point> actualPoints = rewardsController.getRewardsDetails(retailerId);

        // Assert
        assertThat(actualPoints).isEqualTo(expectedPoints);
    }

    @Test
    void testGetRewardsWithValidRetailerId() {
        // Given
        Long retailerId = 123L;
        List<Point> points = List.of(
                Point.builder()
                .points(100).retailer(Retailer.builder().id(retailerId).build())
                .entryTime(LocalDateTime.of(2023, 3, 1, 10, 0)).build(),
                Point.builder()
                .points(50).retailer(Retailer.builder().id(retailerId).build())
                .entryTime(LocalDateTime.of(2023, 2, 1, 10, 0)).build());
        when(pointRepository.findByRetailerIdAndEntryTimeGreaterThan(any(), any())).thenReturn(points);

        // When
        Map<String, Integer> result = rewardsController.getRewards(retailerId);

        // Then
        Map<String, Integer> expected = Map.of("MARCH", 100, "FEBRUARY", 50);
        assertEquals(expected, result);
    }

    @Test
    void testGetRewardsWithNonExistingRetailerId() {
        // Given
        Long retailerId = 123L;
        when(pointRepository.findByRetailerIdAndEntryTimeGreaterThan(any(), any())).thenReturn(List.of());

        // When
        Map<String, Integer> result = rewardsController.getRewards(retailerId);

        // Then
        assertTrue(result.isEmpty());
    }

    @Test
    void testAddTransaction() {
        // Given
        TransactionDto transactionDto = new TransactionDto(100f);
        when(pointRepository.save(any(Point.class))).thenReturn(Point.builder().points(50).build());

        // When
        Point point = rewardsController.addTransaction(1L, transactionDto);

        // Then
        assertEquals(50, point.getPoints());
    }
}
