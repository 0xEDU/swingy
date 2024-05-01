package ft.etachott.view;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.widget.AutosuggestionWidgets;

public class ConsoleView implements IGameView {
    private final LineReader _reader;

    public ConsoleView() {
        _reader = LineReaderBuilder.builder().build();
        AutosuggestionWidgets autosuggestionWidgets = new AutosuggestionWidgets(_reader);
        autosuggestionWidgets.enable();
    }

    public String getInput() {
        return _reader.readLine("--> ").toLowerCase();
    }

    public void initialView() {
        System.out.println("=========================================================");
        System.out.println("================== WELCOME TO SWINGY!! ==================");
        System.out.println("=========================================================");
        System.out.println("=== AVAILABLE COMMANDS:                               ===");
        System.out.println("===                                                   ===");
        System.out.println("=== CHOOSE => Choose a hero                           ===");
        System.out.println("=== CREATE => Create a hero                           ===");
        System.out.println("=== EXIT   => Quit the game                           ===");
        System.out.println("=========================================================");
    }

    public void createHeroView() {
        System.out.println("create hero");
    }

    public void chooseHeroView() {
        System.out.println("choose hero");
    }

    public void exitView() {
        System.out.println("See you later!");
    }


}
