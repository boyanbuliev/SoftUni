package CounterStriker.models.field;

import CounterStriker.common.OutputMessages;
import CounterStriker.models.players.Player;

import java.util.*;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {
    private Collection<Player> terrorists;
    private Collection<Player> counterTerrorists;


    @Override
    public String start(Collection<Player> players) {
        this.terrorists = players.stream().filter(p -> p.getClass().getSimpleName().equals("Terrorist"))
                .collect(Collectors.toList());
        this.counterTerrorists = players.stream().filter(p -> p.getClass().getSimpleName()
                .equals("CounterTerrorist")).collect(Collectors.toList());
        while (true) {
            for (Player terrorist : terrorists) {
                counterTerrorists.forEach(p -> p.takeDamage(terrorist.getGun().fire()));
                counterTerrorists.removeIf(counterTerrorist -> !counterTerrorist.isAlive());
                if (counterTerrorists.isEmpty()) {
                    return TERRORIST_WINS;
                }
            }
            for (Player counterTerrorist : counterTerrorists) {
                terrorists.forEach(p -> p.takeDamage(counterTerrorist.getGun().fire()));
                terrorists.removeIf(terrorist -> !terrorist.isAlive());
                if (terrorists.isEmpty()) {
                    return COUNTER_TERRORIST_WINS;
                }
            }
        }
    }
}
