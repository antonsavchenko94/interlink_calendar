import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Main {
    private static LocalDate currentDate = LocalDate.now();
    private static int currentMonth = currentDate.getMonthValue();

    public static void main(String args []) throws IOException {
        UserInput.readUserInput();

//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("Enter month and year: MM yyyy ");
//        String inputLine = input.readLine();
//
//        if (inputLine.trim().isEmpty()) {
//            printCalendarMonthYear(currentMonth, currentYear);
//        } else {
//            String[] part = inputLine.split(" ");
//            int month = Integer.parseInt(part[0]);
//            int year = Integer.parseInt(part[1]);
//            try {
//
//                if (month < 1 || month > 12)
//                    throw new Exception("Invalid index for month: " + month);
//                printCalendarMonthYear(month, year);
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//            }
//        }
    }
//    public static void printCalendarMonthYear(int month, int year) {
//        System.out.println("Calendar for "+ month + " " + year);
//        int firstDayOfMonth = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
//        int numberOfMonthDays =  LocalDate.of(year, month, 1).getMonth().maxLength();
//        printCalendar(numberOfMonthDays, firstDayOfMonth, month);
//    }
//    private static void printCalendar(int numberOfMonthDays, int firstDayOfMonth, int month) {
//        int weekdayIndex = 0;
//        System.out.println("Mo  Tu  We  Th  Fr  Sa  Su");
//        for (int day = 2; day < firstDayOfMonth; day++) {
//            System.out.print("    ");
//            weekdayIndex++;
//        }
//        for (int day = 1; day <= numberOfMonthDays; day++) {
//            Day printWeek = new Day();
//            printWeek.printWeek(day, month, currentMonth, weekdayIndex);
//            weekdayIndex++;
//            if (weekdayIndex == 7) {
//                weekdayIndex = 0;
//                System.out.println();
//            } else {
//                System.out.print("  ");
//            }
//        }
//    }
}
