import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private static LocalDate currentDate = LocalDate.now();
    private static int currentDay = currentDate.getDayOfMonth();
    private static int currentMonth = currentDate.getMonthValue();
    private static int currentYear = currentDate.getYear();

    public static void main(String args []) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter month and year: MM yyyy ");
        String inputLine = input.readLine();

        if (inputLine.trim().isEmpty()) {
            printCalendarMonthYear(currentMonth, currentYear);
        } else {
            String[] part = inputLine.split(" ");
            int month = Integer.parseInt(part[0]);
            int year = Integer.parseInt(part[1]);
            try {

                if (month < 1 || month > 12)
                    throw new Exception("Invalid index for month: " + month);
                printCalendarMonthYear(month, year);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
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
        System.out.println("Mo  Tu  We  Th  Fr  Sa  Su"); // The order of days depends on your calendar
        for (int day = 2; day < firstDayOfMonth; day++) {
            System.out.print("    "); //this loop to print the first day in his correct place
            weekdayIndex++;
        }
        for (int day = 1; day <= numberOfMonthDays; day++) {
            if (day == currentDay && month == currentMonth) System.out.print(ANSI_RED + day);
            else if (weekdayIndex == 5 || weekdayIndex == 6) System.out.print(ANSI_BLUE + day);
            else if (day < 10) // this is just for better visialising because unit number take less space of course than 2
            {
                System.out.print( ANSI_RESET + day+" ");
            }
            else System.out.print(ANSI_RESET + day);
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
