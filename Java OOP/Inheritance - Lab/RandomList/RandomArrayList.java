package RandomList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<E> extends ArrayList<E> {
    public Object getRandomElement() {
        Random rnd = new Random();
        return remove(rnd.nextInt(size()));
    }
}
