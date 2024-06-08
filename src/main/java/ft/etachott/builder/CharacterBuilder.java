package ft.etachott.builder;

import ft.etachott.model.Character;

public class CharacterBuilder {
    private final Character character = new Character();

    public CharacterBuilder setName(String name) {
        character.setName(name);
        return this;
    }

    public CharacterBuilder setRole(String role) {
        character.setRole(role);
        return this;
    }

    public CharacterBuilder setLevel(int level) {
        character.setLevel(level);
        return this;
    }

    public CharacterBuilder setExp(long exp) {
        character.setExp(exp);
        return this;
    }

    public CharacterBuilder setAttack(int attack) {
        character.setAttack(attack);
        return this;
    }

    public CharacterBuilder setDefense(int defense) {
        character.setDefense(defense);
        return this;
    }

    public CharacterBuilder setHitPoints(int hitPoints) {
        character.setHitPoints(hitPoints);
        return this;
    }

    public Character build() {
        return this.character;
    }
}
