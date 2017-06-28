import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class Calendar {
    private static int mondayIndex = 1;
    private static int year, month;

    public static void printCalendar(YearMonth date) {
        year = date.getYear();
        month = date.getMonthValue();
        printInfo();
        printHeader();
        printBody();
    }

    private static void printInfo() {
        System.out.println("Calendar for " + month + " " + year);
    }

    private static void printBody() {
        int numberOfMonthDays = Month.of(month).maxLength();
        int firstDayOfMonth = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
        printPreviousMonthDays(firstDayOfMonth);
        printDays(numberOfMonthDays);
    }

    private static void printPreviousMonthDays(int firstDayOfMonth) {
        for (int day = mondayIndex; day < firstDayOfMonth; day++) {
            System.out.print("    ");
        }
    }

    public static void printHeader() {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            System.out.print(dayOfWeek.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.CANADA));
            System.out.print(String.format("%-1s", ""));
        }
        System.out.println();
    }

    private static void printDays(int numberOfMonthDays) {
        for (int day = 1; day <= numberOfMonthDays; day++) {
            Day newCalendarDay = new Day();
            newCalendarDay.printDay(day, month, year);
            printSeparator(day);
        }
    }

    private static void printSeparator(int day) {
        if (isLastDayOfWeek(day)) {
            System.out.print("\n");
        } else {
            addExtraSpace(day);
        }
    }

    private static boolean isLastDayOfWeek(int day) {
        String curDay = LocalDate.of(year, month, day).getDayOfWeek().name();
        return curDay.equals("SUNDAY");
    }

    private static void addExtraSpace(int day) {
        if (day < 10) {
            System.out.print(String.format("%-2s", ""));
        } else {
            System.out.print(String.format("%-1s", ""));
        }
    }

}

