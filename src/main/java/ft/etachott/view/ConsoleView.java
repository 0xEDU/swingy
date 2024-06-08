package ft.etachott.view;

import ft.etachott.model.Character;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.widget.AutosuggestionWidgets;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleView implements IGameView {
    private final LineReader _reader;

    public ConsoleView() {
        _reader = LineReaderBuilder.builder().build();
        AutosuggestionWidgets autosuggestionWidgets = new AutosuggestionWidgets(_reader);
        autosuggestionWidgets.enable();
    }

    public String getInput() {
        return prettyReadline("").toLowerCase();
    }

    public void characterRoleView() {
        System.out.println("╭─────────────────────────────────────────────────────────────────────────────────────╮");
        System.out.println("│ Available roles:                                                                    │");
        System.out.println("│                                                                                     │");
        System.out.println("│ NetRunner: Rather than living in realspace where your abilities are limited by      │");
        System.out.println("│            reality, you prefer to experience life through the means offered within  │");
        System.out.println("│            the Net's artificial universe.                                           │");
        System.out.println("│ Base Stats:  30 Attack | 15 Defense | 25 Health Points                              │");
        System.out.println("│                                                                                     │");
        System.out.println("│ Techie: You make your living by building, fixing and modifying stuff - a crucial    │");
        System.out.println("│         occupation in a technological world where no one knows how half the stuff   │");
        System.out.println("│         works.                                                                      │");
        System.out.println("│ Base Stats:  15 Attack | 30 Defense | 35 Health Points                              │");
        System.out.println("│                                                                                     │");
        System.out.println("│ Nomad: You live with a Nomad pack that roams the freeways. You look for supplies,   │");
        System.out.println("│        odd jobs and spare parts in a world where society has fragmented.            │");
        System.out.println("│ Base Stats:  20 Attack | 20 Defense | 30 Health Points                              │");
        System.out.println("╰─────────────────────────────────────────────────────────────────────────────────────╯");
    }

    public void errorView(String error) {
        System.out.println("─➤ ERROR: " + error);
    }

    private String prettyReadline(String promptMessage) {
        System.out.println("╭──────────────────────────────────────────────────────────────────────────────────── •");
        return _reader.readLine("╰➤ " + promptMessage);
    }

    public String[] getRawCharacterInput() {
        String characterName = prettyReadline("Enter your character name: ");
        characterRoleView();
        String characterRole = prettyReadline("Enter your character role: ").toLowerCase();
        return new String[]{characterName, characterRole};
    }

    public void initialView() {
        System.out.print("\033[H\033[2J");
        System.out.println("╭─────────────────────────────────────────────────────────────────────────────────────╮");
        System.out.println("│ CyberSWINGY                                                                         │");
        System.out.println("│ The Roleplaying Game of the Dark Future                                             │");
        System.out.println("│                                                                                     │");
        System.out.println("│ Available commands:                                                                 │");
        System.out.println("│                                                                                     │");
        System.out.println("│ Choose -> Choose a character                                                        │");
        System.out.println("│ Create -> Create a character                                                        │");
        System.out.println("│ Exit   -> Quit the game                                                             │");
        System.out.println("╰─────────────────────────────────────────────────────────────────────────────────────╯");
    }

    public void createCharacterView() {
        System.out.println("╭─────────────────────────────────────────────────────────────────────────────────────╮");
        System.out.println("│ So you wanna be a cyberpunk? Choose your name and get a role.                       │");
        System.out.println("╰─────────────────────────────────────────────────────────────────────────────────────╯");
    }

    private void displayCharacter(Character character) {
        System.out.println("│ • ID: " + character.getId());
        System.out.println("│ • Name: " + character.getName());
        System.out.println("│ • Role: " + character.getRole());
        System.out.println("│ • Level: " + character.getLevel());
        System.out.println("│ • Exp: " + character.getExp());
        System.out.println("│ • Attack: " + character.getAttack());
        System.out.println("│ • Defense: " + character.getDefense());
        System.out.println("│ • Hit Points: " + character.getHitPoints());
        System.out.println("│ • Weapon: " + character.getWeapon());
        System.out.println("│ • Armor: " + character.getArmor());
        System.out.println("│ • Helm: " + character.getHelm());
    }

    public void chooseCharacterView(List<Character> characters) {
        characters.forEach(character -> {
            System.out.println("╭──────────────────────────────────────────────────────────────────────────────────── •");
            displayCharacter(character);
            System.out.println("╰──────────────────────────────────────────────────────────────────────────────────── •");
        });
        String strId = prettyReadline("Enter the character ID: ");
    }

    public void exitView() {
        System.out.println("See you later!");
    }
}
