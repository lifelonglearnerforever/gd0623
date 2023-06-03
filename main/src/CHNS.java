package main.src;

import java.math.BigDecimal;

public class CHNS extends Tool {
    public CHNS() {
        dailyCharge = new BigDecimal("1.49");
        isWeekdayCharge = true;
        isWeekendCharge = false;
        isHolidayCharge = true;
        toolCode = "CHNS";
        toolType = "Chainsaw";
        brand = "Stihl";
    }
}
