package ft.etachott;

import ft.etachott.builder.GameControllerBuilder;
import ft.etachott.controller.GameController;
import ft.etachott.view.ConsoleView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            if (args.length != 1) {
                System.err.println("Usage: java -jar swingy.jar [console | gui]");
                return;
            }
            GameControllerBuilder gameControllerBuilder = new GameControllerBuilder();
            switch (args[0]) {
                case "gui":
                    System.out.println("gui!");
                    break;
                case "console":
                default:
                    GameController consoleController = gameControllerBuilder
                            .setGameView(new ConsoleView())
                            .build();
                    consoleController.run();
            }
        };
    }
}