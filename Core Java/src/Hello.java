import javax.swing.plaf.synth.SynthLookAndFeel;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class Hello {

    public static void main(String[] args) throws IOException {
        String num = Console.Readline();
        int get = Integer.parseInt(num);
        String output = Console.findPrimeNum(get);
        System.out.println(output);
    }
}
