package ru.zimina;

import java.util.List;

public class IngredientsPrinter {

    public static void printPile(List<List<Ingredients>> pileOfIngredients){
        System.out.println("ВСЕ СПИСКИ ИНГРИДИЕНТОВ");
        for(List<Ingredients> ingredients : pileOfIngredients){
            System.out.println(ingredients);
        }
        System.out.println("===========================");
    }

}
