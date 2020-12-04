package CardsWithPower;

public class Card {
    public static String GetPower(Suit suit, Rank rank) {
        return String.format("Card name: %s of %s; Card power: %d", rank,
                suit, suit.getPower() + rank.getPower());
    }
}
