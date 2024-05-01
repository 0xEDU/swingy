package ft.etachott.controller;

import org.jline.reader.EndOfFileException;
import org.jline.reader.UserInterruptException;
import ft.etachott.view.ConsoleView;

public class ConsoleController extends GameController {
    static private final ConsoleView _consoleView = new ConsoleView();

    public ConsoleController() {
        super(_consoleView);
    }

    @Override
    public void run() {
        _consoleView.initialView();
        while (true) {
            try {
                super.handleInput(_consoleView.getInput());
            } catch (UserInterruptException ignored) {
            } catch (EndOfFileException e) {
                super.quit();
                System.exit(0);
            }
        }
    }


}
