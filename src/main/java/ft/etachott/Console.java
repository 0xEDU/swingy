package ft.etachott;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;

public class Console {
    public static void run() {
        LineReader reader = LineReaderBuilder.builder().build();
        String input;

        while (true) {
            input = reader.readLine("(> ");
            System.out.println("input = " + input);
        }
    }
}
