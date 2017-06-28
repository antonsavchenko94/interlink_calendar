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

    public void printDay(LocalDate day, int date) {
        if (isCurrentDate(day, date))
            printCurrentDay(date);
        else if (isWeekend(day)) {printWeekend(date);}
        else {
            printDay(ANSI_RESET_COLOR, date);
        }
    }

    private boolean isWeekend(LocalDate day) {
        String dayOfWeek = day.getDayOfWeek().name();
        return weekendDaysList.contains(dayOfWeek);
    }

    private void printWeekend(int day) {
        System.out.print(String.format("%-1s", ""));
        System.out.print(ANSI_WEEKEND_COLOR + day);
    }

    private void printCurrentDay(int day) {
        printDay(ANSI_CURRENT_DATE_COLOR, day);
    }

    public boolean isCurrentDate(LocalDate day, int date) {
        if (LocalDate.now().getDayOfMonth() == date && LocalDate.now().getMonth().getValue() == day.getMonthValue()) {
            return true;
        }
        return false;
    }
}
