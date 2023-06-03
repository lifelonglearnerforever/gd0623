package main.src;

import java.math.BigDecimal;

public abstract class Tool {
    String toolCode;
    String toolType;
    String brand;
    BigDecimal dailyCharge;
    // Removed rental agreement variables from here
    boolean isWeekdayCharge;
    boolean isWeekendCharge;
    boolean isHolidayCharge;

    public BigDecimal getDailyCharge() {
        return dailyCharge;
    }
}
