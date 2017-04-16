import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Main {
//    public static final String ANSI_RED = "\u001B[31m";
//    public static final String ANSI_RESET = "\u001B[0m";
//    public static final String ANSI_BLUE = "\u001B[34m";
    private static LocalDate currentDate = LocalDate.now();
//    private static int currentDay = currentDate.getDayOfMonth();
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
        System.out.println("Calendar for "+ month + " " + year);
        int firstDayOfMonth = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
        int numberOfMonthDays =  LocalDate.of(year, month, 1).getMonth().maxLength();
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
            Day printWeek = new Day();
            printWeek.printWeek(day, month, currentMonth, weekdayIndex);
//            if (day == currentDay && month == currentMonth) System.out.print(ANSI_RED + day);
//            else if (weekdayIndex == 5 || weekdayIndex == 6) System.out.print(ANSI_BLUE + day);
//            else if (day < 10)
//            {
//                System.out.print( ANSI_RESET + day+" ");
//            }
//            else System.out.print(ANSI_RESET + day);
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
