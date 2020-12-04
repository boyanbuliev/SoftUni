package PokemonTrainer;

import java.util.Iterator;
import java.util.List;

public class Trainer {
    private String name;
    private int badge;
    private List<Pokemon> pokemon;

    public Trainer(String name, List<Pokemon> pokemon) {
        this.name = name;
        this.pokemon = pokemon;
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public boolean isContained(String element) {
        for (Pokemon pok : this.pokemon) {
            if (pok.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void loseHealth() {
        Iterator<Pokemon> iterator = pokemon.iterator();
        while (iterator.hasNext()) {
            Pokemon next = iterator.next();
            next.setHealth(next.getHealth() - 10);
            if (next.getHealth() <= 0) {
               iterator.remove();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badge, this.pokemon.size());
    }
}
