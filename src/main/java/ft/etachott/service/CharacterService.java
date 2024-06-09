package ft.etachott.service;

import ft.etachott.model.Character;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    private Character _character = null;

    public void setCharacter(Character character) {
        _character = character;
    }

    public Character getCharacter() {
        return _character;
    }
}
