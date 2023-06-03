package main.src;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

import static java.time.temporal.TemporalAdjusters.firstInMonth;

public class RentalAgreement {
    private Tool tool;
    private int rentalDays;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private long chargeDays;
    private BigDecimal prediscountCharge;
    private int discountPercent;
    private BigDecimal discountAmount;
    private BigDecimal finalCharge;
    private static final DateTimeFormatter inFormatter = DateTimeFormatter.ofPattern("M/d/yy");
    private static final DateTimeFormatter outFormatter = DateTimeFormatter.ofPattern("MM/dd/yy");

    public RentalAgreement(String toolCode, String checkoutDateStr, int rentalDays, String discountPercent) throws IllegalArgumentException {
        this.discountPercent = Integer.parseInt(discountPercent.replace("%", ""));
        if(this.discountPercent < 0 || 100 < this.discountPercent) {
            throw new IllegalArgumentException("Discount Percent has to be a whole percentage between 0% and 100%");
        }
        if(rentalDays < 1) {
            throw new IllegalArgumentException("Rental days has to be a whole number greater than or equal to 1");
        }
        switch (toolCode) {
            case "CHNS":
                tool = new CHNS();
                break;
            case "LADW":
                tool = new LADW();
                break;
            case "JAKD":
                tool = new JAKD();
                break;
            case "JAKR":
                tool = new JAKR();
                break;
        }
        checkoutDate = LocalDate.parse(checkoutDateStr, inFormatter);
        this.rentalDays = rentalDays;
        dueDate = checkoutDate.plusDays(rentalDays);
        chargeDays = calculateChargeDays(checkoutDate, dueDate, tool);
        prediscountCharge = tool.getDailyCharge().multiply(BigDecimal.valueOf(chargeDays));
        discountAmount = prediscountCharge.multiply(BigDecimal.valueOf(this.discountPercent).divide(BigDecimal.valueOf(100)));
        finalCharge = prediscountCharge.subtract(discountAmount);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tool code: "+ getToolCode()+"\n");
        sb.append("Tool type: "+ getToolType()+"\n");
        sb.append("Tool brand: "+ getBrand()+"\n");
        sb.append("Rental days: "+getRentalDays()+"\n");
        sb.append("Check out date: "+getCheckoutDate()+"\n");
        sb.append("Due date: "+getDueDate()+"\n");
        sb.append("Daily rental charge: "+getDailyRentalCharge()+"\n");
        sb.append("Charge days: "+getChargeDays()+"\n");
        sb.append("Pre-discount charge: "+ getPrediscountCharge()+"\n");
        sb.append("Discount percent: "+getDiscountPercent()+"\n");
        sb.append("Discount amount: "+getDiscountAmount()+"\n");
        sb.append("Final Charge: "+getFinalCharge()+"\n");
        return sb.toString();
    }

    public String getToolCode() {
        return tool.toolCode;
    }

    public String getToolType() {
        return tool.toolType;
    }

    public String getBrand() {
        return tool.brand;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public String getCheckoutDate() {
        return checkoutDate.format(outFormatter);
    }

    public String getDueDate() {
        return dueDate.format(outFormatter);
    }

    public String getDailyRentalCharge() {
        return "$"+tool.getDailyCharge().setScale(2, RoundingMode.HALF_EVEN);
    }

    public long getChargeDays() {
        return chargeDays;
    }

    public String getPrediscountCharge() {
        return "$"+prediscountCharge.setScale(2, RoundingMode.HALF_EVEN);
    }

    public String getDiscountPercent() {
        return discountPercent+"%";
    }

    public String getDiscountAmount() {
        return "$"+discountAmount.setScale(2, RoundingMode.HALF_EVEN);
    }

    public String getFinalCharge() {
        return "$"+finalCharge.setScale(2, RoundingMode.HALF_EVEN);
    }

    private boolean isWeekend(LocalDate date) {
        return (date.get(ChronoField.DAY_OF_WEEK) == 6 || date.get(ChronoField.DAY_OF_WEEK) == 7);
    }
    private boolean isHoliday(LocalDate date) {
        LocalDate july4th = LocalDate.of(date.getYear(), 7, 4);
        LocalDate laborDay = LocalDate.of(date.getYear(), 9, 1).with(firstInMonth(DayOfWeek.MONDAY));
        return (date.isEqual(july4th) || date.isEqual(laborDay));
    }
    private long calculateChargeDays(LocalDate checkoutDate, LocalDate dueDate, Tool tool) {
        long days = 0;
        for (LocalDate date = checkoutDate.plusDays(1); date.isBefore(dueDate.plusDays(1)); date = date.plusDays(1)) {
            if (isHoliday(date) && tool.isHolidayCharge) {
                days++;
            } else if (isWeekend(date) && tool.isWeekendCharge && !isHoliday(date)) {
                days++;
            } else if (!isWeekend(date) && !isHoliday(date)) {
                days++;
            }
        }
        return days;
    }
}
