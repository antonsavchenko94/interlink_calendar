import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {
    public static void main(String args []) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter month and year: MM yyyy ");
        String i = br.readLine();
        String[] part = i.split(" ");
        int month = Integer.parseInt(part[0]);
        int year = Integer.parseInt(part[1]);
        try {

            if (month < 1 || month > 12)
                throw new Exception("Invalid index for month: " + month);
            printCalendarMonthYear(month, year);}

        catch (Exception e) {
            System.err.println(e.getMessage());
        }}

    private static void printCalendarMonthYear(int month, int year) {
        Calendar calendar = new GregorianCalendar();
        calendar.clear();
        calendar.set(year, month - 1, 1);
        System.out.println("Calendar for "+ calendar.getDisplayName(Calendar.MONTH, Calendar.LONG,
                Locale.US) + " " + calendar.get(Calendar.YEAR));
        int firstDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);
        int numberOfMonthDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        printCalendar(numberOfMonthDays, firstDayOfMonth, month);
    }
    private static void printCalendar(int numberOfMonthDays, int firstDayOfMonth, int month) {
        int weekdayIndex = 0;
        System.out.println("Mo  Tu  We  Th  Fr  Sa  Su");
        for (int day = 2; day < firstDayOfMonth; day++) {
            System.out.print("    ");
            weekdayIndex++;
        }
        for (int day = 1; day <= numberOfMonthDays; day++) {
            if (weekdayIndex == 5 || weekdayIndex == 6) System.out.print(day);
            else if (day < 10)
            {
                System.out.print(day+" ");
            }
            else System.out.print(day);
            weekdayIndex++;
            if (weekdayIndex == 7) {
                weekdayIndex = 0;
                System.out.println();
            } else {
                System.out.print("  ");
            }
        }
    }
}
