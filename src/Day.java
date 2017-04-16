import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day {
    private static ArrayList hollidayIndexes = new ArrayList<>(Arrays.asList(5, 6));
    private static LocalDate currentDate = LocalDate.now();
    public static int currentDay = currentDate.getDayOfMonth();
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String SEPARATOR = " ";

    public void printDay(String color, int day) {
        if (Integer.toString(day).length() >= 2) {
            printDay(color, day, SEPARATOR);
        } else {
            System.out.print(color + day);
        }
    }
    public void printDay(String color, int day, String separator) {
        System.out.print(color + day + separator);
    }
        public void printWeek(int day, int month, int currentMonth, int weekdayIndex) {
            if (isCurrentDate(day, month, currentMonth ));
            else if (hollidayIndexes.contains(weekdayIndex)) System.out.print(ANSI_BLUE + day);
            else if (day < 10) {
                printDay(ANSI_RESET, day, " ");
            } else printDay(ANSI_RESET, day, "");
        }
        public boolean isCurrentDate(int day, int month, int currentMonth ){
            if (day == currentDay && month == currentMonth) {
                printDay(ANSI_RED, day, "");
                return true;
            }
            return false;
        }
    }

