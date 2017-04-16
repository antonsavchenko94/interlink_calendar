import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;


public class UserInput {
    private static LocalDate currentDate = LocalDate.now();
    private static int currentMonth = currentDate.getMonthValue();
    private static int currentYear = currentDate.getYear();
    String inputLine;

    public static void readUserInput() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter month and year: MM yyyy ");
        String inputLine = input.readLine();
        handingUserInput(inputLine);
    }

    public static void handingUserInput(String inputLine){
        if (inputLine.trim().isEmpty()) {
            Main.printCalendarMonthYear(currentMonth, currentYear);
        } else {
            String[] part = inputLine.split(" ");
            int month = Integer.parseInt(part[0]);
            int year = Integer.parseInt(part[1]);
            try {

                if (month < 1 || month > 12)
                    throw new Exception("Invalid index for month: " + month);
                Main.printCalendarMonthYear(month, year);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
