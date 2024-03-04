package ft.etachott.controller;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.widget.AutosuggestionWidgets;

public class ConsoleController {
    private final LineReader reader;
    private final AutosuggestionWidgets autosuggestionWidgets;

    public ConsoleController() {
        this.reader = LineReaderBuilder.builder().build();
        this.autosuggestionWidgets = new AutosuggestionWidgets(reader);
        autosuggestionWidgets.enable();
    }

    public void run() {
        String input;

        try {
            while (true) {
                input = reader.readLine("(> ");
                System.out.println("input = " + input);
            }
        } catch (EndOfFileException e) {
            System.out.println("See you later!");
            System.exit(0);
        }
    }
}
