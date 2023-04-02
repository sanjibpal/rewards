package com.charter;

public interface PointsCalcUtil {
    /**
     * Return rewards point from the amount spent
     * @param amount Amount spent
     * @return Points incurred
     */
    static Integer calculatePoints(Integer amount) {
        // if amount > 100, 2 points * amount over 100
        if(amount>100) {
            return (amount-100)*2 + 50;
        } else { // if amount between 50 and 100, 1 point * amount spent over 50
            return Math.max((amount - 50), 0);
        }
    }
}
