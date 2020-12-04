package CounterStriker.models.players;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        isAlive = true;
        this.setGun(gun);
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    public void setHealth(int health) {
        InvalidValue(health, INVALID_PLAYER_HEALTH);
        this.health = health;
    }

    public void setArmor(int armor) {
        InvalidValue(armor, INVALID_PLAYER_ARMOR);
        this.armor = armor;
    }

    private void InvalidValue(int value, String message) {
        if (value < 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        if (this.health < 0) {
            this.health = 0;
        }
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {
        if (points > this.armor) {
            health -= points + this.armor;
            this.armor = 0;
        } else {
            this.armor -= points;
        }
        if (health <= 0) {
            this.isAlive = false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %s", this.getClass().getSimpleName(), this.getUsername()))
                .append(System.lineSeparator())
                .append(String.format("--Health: %d", this.getHealth()))
                .append(System.lineSeparator())
                .append(String.format("--Armor: %d", this.getArmor()))
                .append(System.lineSeparator())
                .append(String.format("--Gun: %s", this.getGun().getName()));
        return sb.toString().trim();
    }
}
