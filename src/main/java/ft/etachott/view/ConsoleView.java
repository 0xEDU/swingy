package ft.etachott.view;

public class ConsoleView extends GameView {
    public ConsoleView() {
        super();
    }

    @Override
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

    @Override
    public void createHeroView() {
        System.out.println("create hero");
    }

    @Override
    public void chooseHeroView() {
        System.out.println("choose hero");
    }

    @Override
    public void exitView() {
        System.out.println("See you later!");
    }


}
