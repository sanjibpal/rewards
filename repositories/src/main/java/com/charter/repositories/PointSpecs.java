package com.charter.repositories;

import com.charter.entities.Point;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
// @TODO
public class PointSpecs {
    public static Specification<Point> hasOldPoints() {
        return (root, query, builder) -> {
            LocalDateTime date = LocalDateTime.now().minusMonths(3);
            return builder.lessThan(root.get("Point.entryTime"), date);
        };
    }

    public static Specification<Point> isRetailer() {
        return (root, query, builder) -> {
            LocalDateTime date = LocalDateTime.now().minusMonths(3);
            return builder.lessThan(root.get("retailer.id"), date);
        };
    }

}
