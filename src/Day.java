import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Day {
    private static List<String> weekendDaysList = Arrays.asList( "SATURDAY", "SUNDAY");
    public static final String ANSI_CURRENT_DATE_COLOR = "\u001B[31m";
    public static final String ANSI_RESET_COLOR = "\u001B[0m";
    public static final String ANSI_WEEKEND_COLOR = "\u001B[34m";

    public void printDay(String color, int day) {
        System.out.print(String.format("%-1s", ""));
        System.out.print(color + day );
    }

    public void printDay(int day, int month, int year) {
        if (isCurrentDate(day, month))
            printCurrentDay(day);
        else if (isWeekend(day, month, year)) {printWeekend(day);}
        else {
            printDay(ANSI_RESET_COLOR, day);
        }
    }

    private boolean isWeekend(int day, int month, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        String dayOfWeek = localDate.getDayOfWeek().name();
        return weekendDaysList.contains(dayOfWeek);
    }

    private void printWeekend(int day) {
        System.out.print(String.format("%-1s", ""));
        System.out.print(ANSI_WEEKEND_COLOR + day);
    }

    private void printCurrentDay(int day) {
        printDay(ANSI_CURRENT_DATE_COLOR, day);
    }

    public boolean isCurrentDate(int day,int month) {
        if (LocalDate.now().getDayOfMonth() == day && LocalDate.now().getMonth().getValue() == month) {
            return true;
        }
        return false;
    }
}

