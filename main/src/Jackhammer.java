package main.src;

import java.math.BigDecimal;

public abstract class Jackhammer extends Tool {
    public Jackhammer() {
        dailyCharge = new BigDecimal("2.99");
        isWeekdayCharge = true;
        isWeekendCharge = false;
        isHolidayCharge = false;
        toolType = "Jackhammer";
    }
}
