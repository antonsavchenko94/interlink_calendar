import java.time.LocalDate;
import java.time.YearMonth;

public class Calendar {
    private static LocalDate currentDate = LocalDate.now();
    private static int currentMonth = currentDate.getMonthValue();
    private static int mondayIndex = 1;

    public static void printCalendar(YearMonth date) {
        int year = date.getYear();
        int month = date.getMonthValue();
        printInfo(year, month);
        printHeader();
        printBody(year, month);
    }

    private static void printInfo(int year, int month) {
        System.out.println("Calendar for " + month + " " + year);
    }

    private static void printBody(int year, int month) {
        int firstDayOfMonth = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
        int numberOfMonthDays = LocalDate.of(year, month, 1).getMonth().maxLength();
        printPreviousMonthDays(firstDayOfMonth);

        printDays(numberOfMonthDays, month, year);
    }

    private static void printPreviousMonthDays(int firstDayOfMonth) {
        for (int day = mondayIndex; day < firstDayOfMonth; day++) {
            System.out.print("    ");
        }
    }

    public static void printHeader() {
        System.out.println("Mo  Tu  We  Th  Fr  Sa  Su");
    }

    private static void printDays(int numberOfMonthDays, int month, int year) {
        for (int day = 1; day <= numberOfMonthDays; day++) {
            Day newCalendarDay = new Day();
            newCalendarDay.printDay(day, month, currentMonth, year);
            printSeparator(day);
        }
    }
    private static void printSeparator(int day){
        if (isLastDayOfWeek(day)) {
            System.out.print("\n");
        } else {
            addExtraSpace(day);
        }
    }

    private static boolean isLastDayOfWeek(int day) {
        return ((day + 6 - 1) % 7 == 0);
    }

    private static void addExtraSpace(int day) {
        if (day < 10) {
            System.out.print("  ");
        } else {
            System.out.print(" ");
        }
    }

}

