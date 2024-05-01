package ft.etachott.model;

public class Character {
    private final String _name;
    private final String _role;
    private int _level;
    private long _exp;
    private int _attack;
    private int _defense;
    private int _hitPoints;
    private String _weapon = null;
    private String _armor = null;
    private String _helm = null;

    public Character(
            String name,
            String role,
            int level,
            long exp,
            int attack,
            int defense,
            int hitPoints
    ) {
        _name = name;
        _role = role;
        _level = level;
        _exp = exp;
        _attack = attack;
        _defense = defense;
        _hitPoints = hitPoints;
    }

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
