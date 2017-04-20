import java.time.YearMonth;

public class Main {
    public static void main(String args []) {
        YearMonth inputDate;
        try {
            inputDate = KeyboardDateReader.readDate();
        } catch (Exception e) {
            System.out.println("Wrong input");
            return;
        }

        Calendar.printCalendar(inputDate);
    }
}
