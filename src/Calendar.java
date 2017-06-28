import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class Calendar {
    private static int mondayIndex = 1;
    public static int year, month;

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
        for (int date = 1; date <= numberOfMonthDays; date++) {
            Day newCalendarDay = new Day();
            LocalDate day = LocalDate.of(year, month, date);
            newCalendarDay.printDay(day, date);
            printSeparatorForDay(day);
        }
    }

    private static void printSeparatorForDay(LocalDate day) {
        if (isLastDayOfWeek(day)) {
            System.out.print("\n");
        } else {
            addExtraSpace(day);
        }
    }

    private static boolean isLastDayOfWeek(LocalDate day) {
//        String curDay = LocalDate.of(year, month, day).getDayOfWeek().name();
        return day.getDayOfWeek().name().equals("SUNDAY");
    }

    private static void addExtraSpace(LocalDate day) {
        if (day.getDayOfMonth() < 10) {
            System.out.print(String.format("%-2s", ""));
        } else {
            System.out.print(String.format("%-1s", ""));
        }
    }

}
