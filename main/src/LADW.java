package main.src;

import java.math.BigDecimal;

public class LADW extends Tool {
    public LADW() {
        dailyCharge = new BigDecimal("1.99");
        isWeekdayCharge = true;
        isWeekendCharge = true;
        isHolidayCharge = false;
        toolCode = "LADW";
        toolType = "Ladder";
        brand = "Werner";
    }
}
