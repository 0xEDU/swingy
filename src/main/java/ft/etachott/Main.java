package ft.etachott;

import ft.etachott.builder.GameControllerBuilder;
import ft.etachott.controller.GameController;
import ft.etachott.view.ConsoleView;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java -jar swingy.jar [console | gui]");
        }
        GameControllerBuilder gameControllerBuilder = new GameControllerBuilder();
        switch (args[0]) {
            case "gui":
                System.out.println("gui!");
            case "console":
            default:
                GameController consoleController = gameControllerBuilder
                        .setGameView(new ConsoleView())
                        .build();
                consoleController.run();
        }
    }
}