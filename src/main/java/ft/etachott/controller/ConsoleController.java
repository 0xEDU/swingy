package ft.etachott.controller;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.widget.AutosuggestionWidgets;
import ft.etachott.view.ConsoleView;

public class ConsoleController extends GameController {
    private final LineReader _reader;
    private final AutosuggestionWidgets _autosuggestionWidgets;
    static private final ConsoleView _consoleView = new ConsoleView();

    public ConsoleController() {
        super(_consoleView);
        _reader = LineReaderBuilder.builder().build();
        _autosuggestionWidgets = new AutosuggestionWidgets(_reader);
        _autosuggestionWidgets.enable();
    }

    @Override
    public void run() {
        _consoleView.initialView();
        while (true) {
            try {
                super.handleInput(this.getInput());
            } catch (UserInterruptException ignored) {
            } catch (EndOfFileException e) {
                super.quit();
            }
        }
    }

	@Override
	public String getInput() {
        return _reader.readLine("--> ").toLowerCase();
	}
}
