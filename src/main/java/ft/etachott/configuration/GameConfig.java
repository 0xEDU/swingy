package ft.etachott.configuration;

import ft.etachott.view.ConsoleView;
import ft.etachott.view.IGameView;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
public class GameConfig {

    @Bean
    @Primary
    public IGameView gameView(ApplicationArguments args) {
        List<String> viewArgs = args.getNonOptionArgs();

        if (viewArgs.isEmpty()) {
            return new ConsoleView();
        }

        switch (viewArgs.get(0)) {
            case "gui":
                // TODO: Create GUI view.
            case "console":
            default:
                return new ConsoleView();
        }
    }
}
