package ru.zimina;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

/**
 * Генератор готовых упаковок ингредиентов от поставщика.
 */

public class IngredientsGenerator {

    static List<Ingredients> ingredients;

    /**
            * Метод генерирует одну упаковку бургерных ингредиентов.
            * @return
            */
    public static List<Ingredients> generateIngredients(){
        ingredients = new ArrayList<>();
        int ingredientCount = (int) (random() * 10); //количество ингредиентов в упаковке

        for (int i=0;i<ingredientCount;i++){
            int ingredientNumber = (int) (random() * 8); //генерация номера ингредиента
            Ingredients currentIngredients =
                    Ingredients.values()[ingredientNumber];
            ingredients.add(currentIngredients);
        }
        return ingredients;
    }

    /**
     * Метод генерирует несколько упаковок бургерных ингредиентов.
     * @param count - количество требуемых упаковок.
     * @return
     */
    public static List<List<Ingredients>> generatePileOfIngredients(int count){
        List<List<Ingredients>> pileOfIngredients = new ArrayList<>();
        for(int i=0;i<count;i++){
            pileOfIngredients.add(generateIngredients());
        }
        return pileOfIngredients;
    }
}
