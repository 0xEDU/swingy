package ft.etachott.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue
    private Long _id;

    private String _name;
    private String _role;
    private int _level;
    private Long _exp;
    private int _attack;
    private int _defense;
    private int _hitPoints;
    private String _weapon = null;
    private String _armor = null;
    private String _helm = null;

    public Character( ) {}

    public String getName() {
        return _name;
    }

    public String getRole() {
        return _role;
    }

    public void setLevel(int level) {
        _level = level;
    }

    public int getLevel() {
        return _level;
    }

    public void setExp(long exp) {
        _exp = exp;
    }

    public long getExp() {
        return _exp;
    }

    public void setAttack(int attack) {
        _attack = attack;
    }

    public int getAttack() {
        return _attack;
    }

    public void setDefense(int defense) {
        _defense = defense;
    }

    public int getDefense() {
        return _defense;
    }

    public void setHitPoints(int hitPoints) {
        _hitPoints = hitPoints;
    }

    public int getHitPoints() {
        return _hitPoints;
    }

    public void setWeapon(String weapon) {
        _weapon = weapon;
    }

    public String getWeapon() {
        return _weapon;
    }

    public void setArmor(String armor) {
        _armor = armor;
    }

    public String getArmor() {
        return _armor;
    }

    public void setHelm(String helm) {
        _helm = helm;
    }

    public String getHelm() {
        return _helm;
    }
}
