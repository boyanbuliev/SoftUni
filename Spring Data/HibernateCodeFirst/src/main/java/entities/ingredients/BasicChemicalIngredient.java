package entities.ingredients;

import java.math.BigDecimal;

public abstract class BasicChemicalIngredient extends BasicIngredient implements ChemicalIngredient {
    private String chemicalFormula;

    public BasicChemicalIngredient(String name, BigDecimal price, String chemicalFormula) {
        super(name, price);
        this.chemicalFormula = chemicalFormula;
    }

    @Override
    public String getChemicalFormula() {
        return chemicalFormula;
    }

    @Override
    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }
}
