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

    private void heroClassView() {
        System.out.println("=======================================================================================");
        System.out.println("=== Available classes:                                                              ===");
        System.out.println("===                                                                                 ===");
        System.out.println("=== NetRunner: Rather than living in realspace where their abilities are limited    ===");
        System.out.println("===            by reality, Netrunners prefer to experience life through the means   ===");
        System.out.println("===            offered within the Net's artificial universe.                        ===");
        System.out.println("=== Base Stats:  30 Attack | 15 Defense | 25 Health Points                          ===");
        System.out.println("===                                                                                 ===");
        System.out.println("=== Techie: You make your living by building, fixing and modifying stuff - a        ===");
        System.out.println("===         crucial occupation in a technological world where no one knows how      ===");
        System.out.println("===         half the stuff works.                                                   ===");
        System.out.println("=== Base Stats:  15 Attack | 30 Defense | 35 Health Points                          ===");
        System.out.println("===                                                                                 ===");
        System.out.println("=== Nomad: You live with a Nomad pack that roams the freeways. You look for         ===");
        System.out.println("===        supplies, odd jobs and spare parts in a world where society has          ===");
        System.out.println("===        fragmented.                                                              ===");
        System.out.println("=== Base Stats:  20 Attack | 20 Defense | 30 Health Points                          ===");
        System.out.println("=======================================================================================");
    }

    public String[] getRawHeroInput() throws InterruptedException {
        String heroName = _reader.readLine("Enter your hero name: ");
        Thread.sleep(2000);
        System.out.println();
        heroClassView();
        String heroClass = _reader.readLine("Enter your hero class: ");
        return new String[]{heroName, heroClass};
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
        System.out.println("=======================================================================================");
        System.out.println("=== Time to create your hero! Choose a nice name and pick a class!                  ===");
        System.out.println("=======================================================================================");
    }

    public void chooseHeroView() {
        System.out.println("choose hero");
    }

    public void exitView() {
        System.out.println("See you later!");
    }


}
