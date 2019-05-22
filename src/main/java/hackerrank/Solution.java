package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'reformatDate' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY dates as parameter.
     */

    public static List<String> reformatDate(List<String> dates) {
        // Write your code here
        List<String> list = new ArrayList<>();
        dates.stream().forEach(a-> list.add(reformat(a)));
        return list;
    }

    public static String reformat(String item) {
        try {
            String[] separatedDate = item.split(" ");
            int day = Integer.parseInt(separatedDate[0].replaceAll("\\D+", ""));

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd");
            String dateInString = String.format("%s-%s-%s", separatedDate[2], separatedDate[1], day);

            Date date = formatter.parse(dateInString);

            formatter = new SimpleDateFormat("yyyy-MM-dd");
            String result = formatter.format(date);
            System.out.println(result);
            return result;
        } catch (Exception ex) {
            return "";
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:\\aa\\a.txt"));

        int datesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> dates = IntStream.range(0, datesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.reformatDate(dates);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
