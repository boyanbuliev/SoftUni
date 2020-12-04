package WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends AnimalImpl {
    private String livingRegion;

    public Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Vegetable)) {
            throw new IllegalStateException(String.format("%ss are not eating that type of food!",
                    this.getAnimalType()));
        }
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#");
        return String.format("%s[%s, %s, %s, %d]", this.getClass().getSimpleName(),
                this.getAnimalName(), df.format(this.getAnimalWeight()), this.getLivingRegion(),
                this.getFoodEaten());
    }
}
