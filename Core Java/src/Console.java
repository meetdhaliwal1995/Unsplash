import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Console {

    public static String Readline() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine
        return reader.readLine();
    }

    public static void Writeline(String s) {
        System.out.println(s);
    }

    public static String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();

        Arrays.sort(tempArray);

        return new String(tempArray);
    }

    public static String sort(String s) {

        String[] strArray = s.split("\\s+");
        Arrays.sort(strArray);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            sb.append(strArray[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String sortStringg(String s) {
        String[] strArray = s.split("\\s+");
        Arrays.sort(strArray);
        return String.join(" ", strArray);
    }

    static class StringLengthComparator implements Comparator<String> { //Custom Comparator class according to your need

        @Override
        public int compare(String str1, String str2) {
            return str1.length() - str2.length();// compare length of Strings
        }

    }

    public static void soetStringSpace(String s) {
        String strings[] = s.split(" ");
        Arrays.sort(strings, new Console.StringLengthComparator());
        for (String str : strings)
            System.out.println(str);
    }

    public static String findPrimeNum(int limit) {

        int i;
        int num;
        String primeNumbers = "";

        for (i = 0; i <= limit; i++) {
            int counter = 0;
            for (num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter = counter + 1;
                }
            }
            if (counter == 2) {
                primeNumbers = primeNumbers + i + " ";
            }
        }

        return primeNumbers;
    }

    public static int findPrimeNumber(int limit) {
        int i;
        int counter = 0;

        for (i = 0; i < limit; i++) {

            boolean isprime = true;

            if ((i % 2 == 0) || (i % 3 == 0) || (i % 5 == 0) || (i % 7 == 0)) {
                isprime = false;
            }
            if (i == 2 || i == 3 || i == 7 || i == 5) isprime = true;

            if (isprime) {

                counter++;

            }

        }
        return counter;
    }
}
