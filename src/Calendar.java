import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class Calendar {
    public static YearMonth date;

    public static void printCalendar(YearMonth yearMonth) {
        date = yearMonth;
        printInfo();
        printHeader();
        printBody();
    }

    private static void printInfo() {
        System.out.println("Calendar for " + date.getMonthValue() + " " + date.getYear());
    }

    private static void printBody() {
        Month localDate = Month.of(date.getMonthValue());
        LocalDate firstDayOfMonth = LocalDate.of(date.getYear(), date.getMonthValue(), 1);
        printPreviousMonthDays(firstDayOfMonth);
        printDays(localDate);
    }

    private static void printPreviousMonthDays(LocalDate localDate) {
        int firstDayOfMonth = localDate.getDayOfWeek().getValue();
        for (int day = 1; day < firstDayOfMonth; day++) {
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


    private static void printDays(Month numberOfMonthDays) {
        int maxLengthOfMonth = numberOfMonthDays.maxLength();
        for (int numberOfDay = 1; numberOfDay <= maxLengthOfMonth; numberOfDay++) {
            Day newCalendarDay = new Day();
            LocalDate day = LocalDate.of(date.getYear(), date.getMonthValue(), numberOfDay);
            newCalendarDay.printDay(day, numberOfDay);
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
