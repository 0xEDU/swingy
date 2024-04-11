package ft.etachott.controller;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.widget.AutosuggestionWidgets;
import ft.etachott.view.ConsoleView;

public class ConsoleController extends GameController {
    private final LineReader reader;
    private final AutosuggestionWidgets autosuggestionWidgets;
    private final ConsoleView consoleView;

    public ConsoleController() {
        this.reader = LineReaderBuilder.builder().build();
        this.autosuggestionWidgets = new AutosuggestionWidgets(reader);
        this.consoleView = new ConsoleView();
        autosuggestionWidgets.enable();
        super();
    }

    @Override
    public void run() {
        consoleView.printBanner();
        while (true) {
            try {
                super.handleInput(this.getInput());
            } catch (UserInterruptException e) {
                continue;
            } catch (EndOfFileException e) {
                System.out.println("See you later!");
                System.exit(0);
            }
        }
    }

	@Override
	public String getInput() {
        return this.reader.readLine("--> ");
	}
}
