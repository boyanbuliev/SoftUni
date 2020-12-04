package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster = new ArrayList<>();

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return roster.removeIf(player -> player.getName().equals(name));
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
                return;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
                return;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> removed = new ArrayList<>();
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getClazz().equals(clazz)) {
                removed.add(roster.get(i));
                roster.remove(roster.get(i));
                i--;
            }
        }
        Player[] removedArr = new Player[removed.size()];
        for (int i = 0; i < removedArr.length; i++) {
            removedArr[i] = removed.get(i);
        }
        return removedArr;
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Players in the guild: ")
                .append(this.name).append(":")
                .append(System.lineSeparator());
        for (Player player : roster) {
            sb.append(player)
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
