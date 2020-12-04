package PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
//     try {
//         DoughFlourTypeAndCalories.valueOf(flourType).getType();
//     }catch (IllegalArgumentException e){
//             throw new IllegalStateException("Invalid type of dough.");
//
//     }
//        if (DoughFlourTypeAndCalories.valueOf(flourType).getType()!=null){
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalStateException("Invalid type of dough.");

        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy")
                && !bakingTechnique.equals("Homemade")) {
            throw new IllegalStateException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalStateException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;

    }

    public double calculateCalories() {
        if (flourType.equals("White")) {
            switch (bakingTechnique) {
                case "Crispy":
                    return this.weight * 2 * 1.5 * 0.9;
                case "Chewy":
                    return this.weight * 2 * 1.5 * 1.1;
                case "Homemade":
                    return this.weight * 2 * 1.5 * 1.0;
            }
        } else {
            switch (bakingTechnique) {
                case "Crispy":
                    return this.weight * 2 * 1.0 * 0.9;
                case "Chewy":
                    return this.weight * 2 * 1.0 * 1.1;
                case "Homemade":
                    return this.weight * 2 * 1.0 * 1.0;
            }
        }
        return 0;
    }
}