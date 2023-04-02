package com.charter;

import com.charter.dto.TransactionDto;
import com.charter.entities.Point;
import com.charter.entities.Retailer;
import com.charter.repositories.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RewardsController {

    private final PointRepository pointRepository;

    /**
     * Returns reward points for the retailer {retailerId}
     * @param retailerId Retailer Id
     * @return Reward Points
     */
    @GetMapping(value = "/v1/{retailerId}/rewards-details")
    public List<Point> getRewardsDetails(@PathVariable Long retailerId) {
        return pointRepository.findAllByRetailerId(retailerId);
    }

    /**
     * Returns reward points for the retailer {retailerId} grouped by month
     * @param retailerId Retailer Id
     * @return Reward Points for the last 3 months
     */
    @GetMapping(value = "/v1/{retailerId}/rewards")
    public Map<String, Integer> getRewards(@PathVariable Long retailerId) {
        LocalDateTime dateTime = LocalDateTime.now().minusMonths(3);
        List<Point> points = pointRepository.findByRetailerIdAndEntryTimeGreaterThan(retailerId, dateTime);

        return points.stream().collect(
                Collectors.groupingBy(p -> p.getEntryTime().getMonth().name(),
                    Collectors.summingInt(Point::getPoints)));
    }

    /**
     * Record points rewarded with the timestamp
     * @param retailerId Retailer Id
     * @param transactionDto Transaction e.g. Amount data
     * @return Status
     */
    @PostMapping(value = "/v1/{retailerId}/transaction")
    public Point addTransaction(
            @PathVariable Long retailerId,
            @Valid @RequestBody TransactionDto transactionDto) {
        Point point = Point.builder()
                .points(PointsCalcUtil.calculatePoints(Math.round(transactionDto.getAmount())))
                .retailer(Retailer.builder().id(retailerId).build())
                .entryTime(LocalDateTime.now()).build();
        return pointRepository.save(point);
    }
}
