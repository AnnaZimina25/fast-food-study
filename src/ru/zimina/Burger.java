package ru.zimina;

import java.util.List;

public class Burger {
    private List<Ingredients> burgerIngredients;

    public Burger(List<Ingredients> burgerIngredients) {
        this.burgerIngredients = burgerIngredients;
    }


    @Override
    public String toString() {
        return this.burgerIngredients.toString();
    }
}
