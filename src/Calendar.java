import java.time.*;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Calendar {
    private static int mondayIndex = 1;
    private static List<String> weekendDaysList = Arrays.asList("SUNDAY");

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
        int numberOfMonthDays = Month.of(month).maxLength();
        int firstDayOfMonth = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
        printPreviousMonthDays(firstDayOfMonth);
        printDays(numberOfMonthDays, month, year);
    }

    private static void printPreviousMonthDays(int firstDayOfMonth) {
        for (int day = mondayIndex; day < firstDayOfMonth; day++) {
            System.out.print("    ");
        }
    }

    public static void printHeader() {
        for (DayOfWeek c : DayOfWeek.values()) {
            System.out.print(c.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.CANADA));
            System.out.print(String.format("%-1s", ""));
        }
        System.out.println();
    }

    private static void printDays(int numberOfMonthDays, int month, int year) {
        for (int day = 1; day <= numberOfMonthDays; day++) {
            Day newCalendarDay = new Day();
            newCalendarDay.printDay(day, month, year);
            printSeparator(day, month, year);
        }
    }

    private static void printSeparator(int day, int month, int year) {
        if (isLastDayOfWeek(day, month, year)) {
            System.out.print("\n");
        } else {
            addExtraSpace(day);
        }
    }

    private static boolean isLastDayOfWeek(int day, int month, int year) {
        String curDay = LocalDate.of(year, month, day).getDayOfWeek().name();
        return weekendDaysList.contains(curDay);
    }

    private static void addExtraSpace(int day) {
        if (day < 10) {
            System.out.print(String.format("%-2s", ""));
        } else {
            System.out.print(String.format("%-1s", ""));
        }
    }

}

