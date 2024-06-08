package ft.etachott.service;

import ft.etachott.builder.CharacterBuilder;
import ft.etachott.model.Character;
import ft.etachott.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GameService {
    private final CharacterRepository _characterRepository;

    @Autowired
    public GameService(CharacterRepository characterRepository) {
        _characterRepository = characterRepository;
    }

    public void createCharacter(String[] rawCharacterInput) {
        Map<String, int[]> rolesMap = Map.of(
                "netrunner", new int[]{30,15,25},
                "techie", new int[]{15,30,35},
                "nomad", new int[]{20, 20, 30}
        );

        String name = rawCharacterInput[0];
        String role = rawCharacterInput[1];
        CharacterBuilder characterBuilder = new CharacterBuilder();
        Character newCharacter = characterBuilder
                .setName(name)
                .setRole(role)
                .setLevel(1)
                .setExp(0)
                .setAttack(rolesMap.get(role)[0])
                .setDefense(rolesMap.get(role)[1])
                .setHitPoints(rolesMap.get(role)[2])
                .build();
        _characterRepository.save(newCharacter);
        // Character newCharacter = new Character(
        //         name, role, 1, 0, rolesMap.get(role)[0], rolesMap.get(role)[1], rolesMap.get(role)[2]
        // );
        // _gameRepository.save(newCharacter);
    }

    public List<Character> getCharacters() {
        return _characterRepository.findAll();
    }
}
