import java.time.LocalDate;

public class CalendarBody {
    private static LocalDate currentDate = LocalDate.now();
    private static int currentMonth = currentDate.getMonthValue();

    public static void printCalendarBody( int month, int year) {
        System.out.println("Calendar for "+ month + " " + year);
        int firstDayOfMonth = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
        int numberOfMonthDays =  LocalDate.of(year, month, 1).getMonth().maxLength();

        int weekdayIndex = 0;
        for (int day = 2; day < firstDayOfMonth; day++) {
            System.out.print("    ");
            weekdayIndex++;
        }
        for (int day = 1; day <= numberOfMonthDays; day++) {
            Day printWeek = new Day();
            printWeek.printWeek(day, month, currentMonth, weekdayIndex);
            weekdayIndex++;
            if (weekdayIndex == 7) {
                weekdayIndex = 0;
                System.out.println();
            } else {
                System.out.print("  ");
            }
        }
    }
}
