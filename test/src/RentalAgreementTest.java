import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import main.src.RentalAgreement;
import static org.junit.Assert.fail;

public class RentalAgreementTest {

    @Test
    public void test1() {
        try {
            RentalAgreement ra = new RentalAgreement("JAKR", "9/3/15", 5, "101%");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Discount Percent has to be a whole percentage between 0% and 100%", e.getMessage());
        }
    }

    @Test
    public void test2() {
        RentalAgreement ra = new RentalAgreement("LADW", "7/2/20", 3, "10%");
        Assertions.assertEquals("LADW", ra.getToolCode());
        Assertions.assertEquals("Ladder", ra.getToolType());
        Assertions.assertEquals("Werner", ra.getBrand());
        Assertions.assertEquals(3, ra.getRentalDays());
        Assertions.assertEquals("07/02/20",ra.getCheckoutDate());
        Assertions.assertEquals("07/05/20",ra.getDueDate());
        Assertions.assertEquals("$1.99",ra.getDailyRentalCharge());
        Assertions.assertEquals(2,ra.getChargeDays());
        Assertions.assertEquals("$3.98",ra.getPrediscountCharge());
        Assertions.assertEquals("10%",ra.getDiscountPercent());
        Assertions.assertEquals("$0.40",ra.getDiscountAmount());
        Assertions.assertEquals("$3.58",ra.getFinalCharge());
        String raStr = "Tool code: LADW\n" +
                "Tool type: Ladder\n" +
                "Tool brand: Werner\n" +
                "Rental days: 3\n" +
                "Check out date: 07/02/20\n" +
                "Due date: 07/05/20\n" +
                "Daily rental charge: $1.99\n" +
                "Charge days: 2\n" +
                "Pre-discount charge: $3.98\n" +
                "Discount percent: 10%\n" +
                "Discount amount: $0.40\n" +
                "Final Charge: $3.58\n";
        Assertions.assertEquals(raStr,ra.toString());
    }

    @Test
    public void test3() {
        RentalAgreement ra = new RentalAgreement("CHNS", "7/2/15", 5, "25%");
        Assertions.assertEquals("CHNS", ra.getToolCode());
        Assertions.assertEquals("Chainsaw", ra.getToolType());
        Assertions.assertEquals("Stihl", ra.getBrand());
        Assertions.assertEquals(5, ra.getRentalDays());
        Assertions.assertEquals("07/02/15",ra.getCheckoutDate());
        Assertions.assertEquals("07/07/15",ra.getDueDate());
        Assertions.assertEquals("$1.49",ra.getDailyRentalCharge());
        Assertions.assertEquals(4,ra.getChargeDays());
        Assertions.assertEquals("$5.96",ra.getPrediscountCharge());
        Assertions.assertEquals("25%",ra.getDiscountPercent());
        Assertions.assertEquals("$1.49",ra.getDiscountAmount());
        Assertions.assertEquals("$4.47",ra.getFinalCharge());
        String raStr = "Tool code: CHNS\n" +
                "Tool type: Chainsaw\n" +
                "Tool brand: Stihl\n" +
                "Rental days: 5\n" +
                "Check out date: 07/02/15\n" +
                "Due date: 07/07/15\n" +
                "Daily rental charge: $1.49\n" +
                "Charge days: 4\n" +
                "Pre-discount charge: $5.96\n" +
                "Discount percent: 25%\n" +
                "Discount amount: $1.49\n" +
                "Final Charge: $4.47\n";
        Assertions.assertEquals(raStr,ra.toString());
    }

    @Test
    public void test4() {
        RentalAgreement ra = new RentalAgreement("JAKD", "9/3/15", 6, "0%");
        Assertions.assertEquals("JAKD", ra.getToolCode());
        Assertions.assertEquals("Jackhammer", ra.getToolType());
        Assertions.assertEquals("DeWalt", ra.getBrand());
        Assertions.assertEquals(6, ra.getRentalDays());
        Assertions.assertEquals("09/03/15",ra.getCheckoutDate());
        Assertions.assertEquals("09/09/15",ra.getDueDate());
        Assertions.assertEquals("$2.99",ra.getDailyRentalCharge());
        Assertions.assertEquals(3,ra.getChargeDays());
        Assertions.assertEquals("$8.97",ra.getPrediscountCharge());
        Assertions.assertEquals("0%",ra.getDiscountPercent());
        Assertions.assertEquals("$0.00",ra.getDiscountAmount());
        Assertions.assertEquals("$8.97",ra.getFinalCharge());
        String raStr = "Tool code: JAKD\n" +
                "Tool type: Jackhammer\n" +
                "Tool brand: DeWalt\n" +
                "Rental days: 6\n" +
                "Check out date: 09/03/15\n" +
                "Due date: 09/09/15\n" +
                "Daily rental charge: $2.99\n" +
                "Charge days: 3\n" +
                "Pre-discount charge: $8.97\n" +
                "Discount percent: 0%\n" +
                "Discount amount: $0.00\n" +
                "Final Charge: $8.97\n";
        Assertions.assertEquals(raStr,ra.toString());

    }

    @Test
    public void test5() {
        RentalAgreement ra = new RentalAgreement("JAKR", "7/2/15", 9, "0%");
        Assertions.assertEquals("JAKR", ra.getToolCode());
        Assertions.assertEquals("Jackhammer", ra.getToolType());
        Assertions.assertEquals("Ridgid", ra.getBrand());
        Assertions.assertEquals(9, ra.getRentalDays());
        Assertions.assertEquals("07/02/15",ra.getCheckoutDate());
        Assertions.assertEquals("07/11/15",ra.getDueDate());
        Assertions.assertEquals("$2.99",ra.getDailyRentalCharge());
        Assertions.assertEquals(6,ra.getChargeDays());
        Assertions.assertEquals("$17.94",ra.getPrediscountCharge());
        Assertions.assertEquals("0%",ra.getDiscountPercent());
        Assertions.assertEquals("$0.00",ra.getDiscountAmount());
        Assertions.assertEquals("$17.94",ra.getFinalCharge());
        String raStr = "Tool code: JAKR\n" +
                "Tool type: Jackhammer\n" +
                "Tool brand: Ridgid\n" +
                "Rental days: 9\n" +
                "Check out date: 07/02/15\n" +
                "Due date: 07/11/15\n" +
                "Daily rental charge: $2.99\n" +
                "Charge days: 6\n" +
                "Pre-discount charge: $17.94\n" +
                "Discount percent: 0%\n" +
                "Discount amount: $0.00\n" +
                "Final Charge: $17.94\n";
        Assertions.assertEquals(raStr,ra.toString());

    }

    @Test
    public void test6() {
        RentalAgreement ra = new RentalAgreement("JAKR", "7/2/20", 4, "50%");
        Assertions.assertEquals("JAKR", ra.getToolCode());
        Assertions.assertEquals("Jackhammer", ra.getToolType());
        Assertions.assertEquals("Ridgid", ra.getBrand());
        Assertions.assertEquals(4, ra.getRentalDays());
        Assertions.assertEquals("07/02/20",ra.getCheckoutDate());
        Assertions.assertEquals("07/06/20",ra.getDueDate());
        Assertions.assertEquals("$2.99",ra.getDailyRentalCharge());
        Assertions.assertEquals(2,ra.getChargeDays());
        Assertions.assertEquals("$5.98",ra.getPrediscountCharge());
        Assertions.assertEquals("50%",ra.getDiscountPercent());
        Assertions.assertEquals("$2.99",ra.getDiscountAmount());
        Assertions.assertEquals("$2.99",ra.getFinalCharge());
        String raStr = "Tool code: JAKR\n" +
                "Tool type: Jackhammer\n" +
                "Tool brand: Ridgid\n" +
                "Rental days: 4\n" +
                "Check out date: 07/02/20\n" +
                "Due date: 07/06/20\n" +
                "Daily rental charge: $2.99\n" +
                "Charge days: 2\n" +
                "Pre-discount charge: $5.98\n" +
                "Discount percent: 50%\n" +
                "Discount amount: $2.99\n" +
                "Final Charge: $2.99\n";
        Assertions.assertEquals(raStr,ra.toString());
    }

    @Test
    public void testChargeDaysNoHolidays() {
        RentalAgreement ra = new RentalAgreement("JAKR", "7/3/20", 366, "0%");
        Assertions.assertEquals("07/03/20",ra.getCheckoutDate());
        Assertions.assertEquals("07/04/21",ra.getDueDate());
        Assertions.assertEquals(259,ra.getChargeDays()); //259 is correct
    }
    @Test
    public void testChargeDays3HolidaysAndNewYear() {
        RentalAgreement ra = new RentalAgreement("CHNS", "7/3/20", 366, "0%");
        Assertions.assertEquals("07/03/20",ra.getCheckoutDate());
        Assertions.assertEquals("07/04/21",ra.getDueDate());
        Assertions.assertEquals(262,ra.getChargeDays()); // 259 days + 3 holidays
    }

    @Test
    public void testDiscountPercentExceptions() {
        RentalAgreement ra = null;
        try {
            ra = new RentalAgreement("JAKR", "9/3/15", 1, "101%");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Discount Percent has to be a whole percentage between 0% and 100%", e.getMessage());
        }
        try {
            ra = new RentalAgreement("JAKR", "9/3/15", 1, "-1%");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Discount Percent has to be a whole percentage between 0% and 100%", e.getMessage());
        }
        try {
            ra = new RentalAgreement("JAKR", "9/3/15", 1, "100%");
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown any exception");
        }
        try {
            ra = new RentalAgreement("JAKR", "9/3/15", 1, "0%");
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown any exception");
        }
    }
    @Test
    public void testRentalDaysExceptions() {
        RentalAgreement ra = null;
        try {
            ra = new RentalAgreement("JAKR", "9/3/15", 0, "100%");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Rental days has to be a whole number greater than or equal to 1", e.getMessage());
        }
        try {
            ra = new RentalAgreement("JAKR", "9/3/15", -1, "0%");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("Rental days has to be a whole number greater than or equal to 1", e.getMessage());
        }
        try {
            ra = new RentalAgreement("JAKR", "9/3/15", 1, "50%");
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown any exception");
        }
        try {
            ra = new RentalAgreement("JAKR", "9/3/15", 10000, "50%");
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown any exception");
        }
    }
}