package ft.etachott.service;

import ft.etachott.model.Character;
import ft.etachott.repository.GameRepository;

import java.util.Map;

public class GameService {
    final private GameRepository _gameRepository = new GameRepository();
    public GameService() {}

    public void createCharacter(String[] rawCharacterInput) {
        Map<String, int[]> rolesMap = Map.of(
                "netrunner", new int[]{30,15,25},
                "techie", new int[]{15,30,35},
                "nomad", new int[]{20, 20, 30}
        );

        String name = rawCharacterInput[0];
        String role = rawCharacterInput[1];
        Character newCharacter = new Character(
                name, role, 1, 0, rolesMap.get(role)[0], rolesMap.get(role)[1], rolesMap.get(role)[2]
        );
        _gameRepository.save(newCharacter);
    }
}
