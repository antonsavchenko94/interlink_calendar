import java.time.DayOfWeek;
import java.time.LocalDate;

public class Day {
    public static final String ANSI_CURRENT_DATE_COLOR = "\u001B[31m";
    public static final String ANSI_RESET_COLOR = "\u001B[0m";
    public static final String ANSI_WEEKEND_COLOR = "\u001B[34m";

    public void printDay(String color, int day) {
        System.out.print(String.format("%-1s", ""));
        System.out.print(color + day );
    }

    public void printDay(LocalDate day, int date) {
        if (isCurrentDate(day))
            printCurrentDay(date);
        else if (isWeekend(day)) {printWeekend(date);}
        else {
            printDay(ANSI_RESET_COLOR, date);
        }
    }

    private boolean isWeekend(LocalDate day) {
        return day.getDayOfWeek() == DayOfWeek.SATURDAY ||
                day.getDayOfWeek() == DayOfWeek.SUNDAY ;
    }

    private void printWeekend(int day) {
        System.out.print(String.format("%-1s", ""));
        System.out.print(ANSI_WEEKEND_COLOR + day);
    }

    private void printCurrentDay(int day) {
        printDay(ANSI_CURRENT_DATE_COLOR, day);
    }

    public boolean isCurrentDate(LocalDate day) {
        if (day.equals(LocalDate.now())) {
            return true;
        }
        return false;
    }
}
