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
        if (Objects.equals(args[0], "console")) {
            GameController consoleController = gameControllerBuilder
                    .setGameView(new ConsoleView())
                    .build();
            consoleController.run();
        } else if (Objects.equals(args[0], "gui")) {
            System.out.println("gui!");
        }

    }
}