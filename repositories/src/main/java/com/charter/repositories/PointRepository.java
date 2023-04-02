package com.charter.repositories;


import com.charter.entities.Point;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PointRepository extends JpaRepository<Point, Long> {
    List<Point> findByRetailerIdAndEntryTimeGreaterThan(Long retailerId, LocalDateTime time);

    List<Point> findAllByRetailerId(Long retailerId);
}
