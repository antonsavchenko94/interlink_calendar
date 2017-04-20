import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Day {
    private static ArrayList hollidayIndexes = new ArrayList<>(Arrays.asList(6, 7));
    private static LocalDate currentDate = LocalDate.now();
    public static int currentDay = currentDate.getDayOfMonth();
    public static final String ANSI_CURRENT_DATE_COLOR = "\u001B[31m";
    public static final String ANSI_RESET_COLOR = "\u001B[0m";
    public static final String ANSI_WEEKEND_COLOR = "\u001B[34m";
    public static final String SEPARATOR = " ";

    public void printDay(String color, int day, String separator) {
        System.out.print(color + day + separator);
    }

    public void printDay(int day, int month, int currentMonth, int year) {
        if (isCurrentDate(day, month, currentMonth))
            printCurrentDay(day);
        else if (isWeekend(day, currentMonth, year)) {printWeekend(day);}
        else {
            printDay(ANSI_RESET_COLOR, day, SEPARATOR);
        }
    }

    private boolean isWeekend(int day, int currentMonth, int year) {
        LocalDate localDate = LocalDate.of(year, currentMonth, day);
        int dayOfWeek = localDate.getDayOfWeek().getValue();
        return hollidayIndexes.contains(dayOfWeek);
    }

    private void printWeekend(int day) {
        System.out.print(ANSI_WEEKEND_COLOR + day + SEPARATOR);
    }

    private void printCurrentDay(int day) {
        printDay(ANSI_CURRENT_DATE_COLOR, day, SEPARATOR);
    }

    public boolean isCurrentDate(int day, int month, int currentMonth) {
        if (day == currentDay && month == currentMonth) {
            return true;
        }
        return false;
    }
}

