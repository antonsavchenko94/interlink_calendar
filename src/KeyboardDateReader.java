import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.YearMonth;

public class KeyboardDateReader {
    public static YearMonth currentMonthYear = YearMonth.now();

    public static YearMonth readDate() throws Exception {
        return parseData(readInput());
    }

    private static String readInput() throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter month and year: MM yyyy ");
        return input.readLine();
    }

    private static YearMonth parseData(String inputLine) throws Exception {
        if (inputLine.trim().isEmpty()) {
            return currentMonthYear;
        } else {
            return checkData(inputLine);
        }
    }

    private static YearMonth checkData(String inputLine) throws Exception {
        String[] part = inputLine.split(" ");
        int month = Integer.parseInt(part[0]);
        int year = Integer.parseInt(part[1]);
        if (month < 1 || month > 12) {
            throw new Exception("Invalid index for month: " + month);
        }
        return YearMonth.of(year, month);
    }
}