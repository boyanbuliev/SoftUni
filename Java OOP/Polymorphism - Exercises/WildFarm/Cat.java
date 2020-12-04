package WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight,
               String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#");
        return String.format("%s[%s, %s, %s, %s, %d]", this.getAnimalType(),
                this.getAnimalName(), this.getBreed(), df.format(this.getAnimalWeight()),
                this.getLivingRegion(), this.getFoodEaten());
    }
}
