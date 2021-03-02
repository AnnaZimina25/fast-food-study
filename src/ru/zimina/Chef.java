package ru.zimina;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс шеф-повара, отвечающий за превращение неупорядоченных наборов ингредиентов
 * в бургеры.
 */
public class Chef {

    private static List<Burger> allCookedBurgers = new ArrayList<>();


    /**
     * Метод для приготовления бургера в соответствии с рецептами шефа.
     * @param upakovka - принимаемая на вход упаковка неупорядоченных ингридиентов
     * @return
     */

    public static Burger cookBurger(List<Ingredients> upakovka){
        putBuns(upakovka);
        if (upakovka.contains(Ingredients.SALAD)) {
            putSalad(upakovka);
        }
        if (upakovka.contains(Ingredients.CHEESE)) {
            putCheese(upakovka);
        }

        Burger burger = new Burger(upakovka);
        allCookedBurgers.add(burger);
        return  burger;//orderBuns(upakovka);
    }

    public static  List<Burger> getAllCookedBurgers () {
        return allCookedBurgers;
    }


    /**
     * Метод для упорядочивания булочек в бургере.
     * @param upakovka - принимаемая на вход упаковка неупорядоченных ингридиентов
     * @return
     */
    private static List<Ingredients> orderBuns(List<Ingredients> upakovka){
        //находим в упаковке булочку, и перемещаем ее вниз бургера, на 0-ю позицию
        for (int i = 0; i < upakovka.size(); i++){
            Ingredients ingredients = upakovka.get(i);
            if (ingredients.equals(Ingredients.BUN)) {
                upakovka.remove(i);
                upakovka.add(0, ingredients);
                break;
            }
        }

        //находим в упаковке булочку, и перемещаем ее вверх бургера, на последнюю позицию
        for (int i = 1; i < upakovka.size(); i++){
            Ingredients ingredients = upakovka.get(i);
            if (ingredients.equals(Ingredients.BUN)) {
                upakovka.remove(i);
                upakovka.add(upakovka.size(), ingredients);
                break;
            }
        }

        //пытаемся найти 3ю булочку, и перемещаем ее в середину бургера, как в биг маке:)
        for (int i = 1; i < upakovka.size()-1; i++){
            Ingredients ingredients = upakovka.get(i);
            if (ingredients.equals(Ingredients.BUN)) {
                upakovka.remove(i);
                upakovka.add(upakovka.size() / 2, ingredients);
                break;
            }
        }

        //возвращаем готовый бургер
        return upakovka;
    }

    public static List<Integer> getIngredientIndexes(List<Ingredients> upakovka, Ingredients ingredient) {

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < upakovka.size(); i++) {
            Ingredients upakovkaIngredient = upakovka.get(i);
            if (upakovkaIngredient == ingredient) {
                indexes.add(i);
            }
        }

        return indexes;

    }

    private static void removeIngredient (List<Ingredients> upakovka, List<Integer> ingredientIndexes, Ingredients ingredient) {
        List<Ingredients> ingredientList = new ArrayList<>();
        for (int i = 0; i < ingredientIndexes.size(); i++) {
            ingredientList.add(ingredient);

        }
        upakovka.removeAll(ingredientList);
    }

    private static void putBuns (List<Ingredients> upakovka) {
        List<Integer> bunsIndexes = getIngredientIndexes(upakovka, Ingredients.BUN);

        // Удаляем все булочки
       removeIngredient(upakovka, bunsIndexes, Ingredients.BUN);

        // Расставляем булочки по местам
        upakovka.add(0,Ingredients.BUN);
        upakovka.add(Ingredients.BUN);

        if (bunsIndexes.size() == 3) {
            upakovka.add(upakovka.size()/2 , Ingredients.BUN);
        }

    }

    private static void putSalad (List<Ingredients> upakovka) {

        List<Integer> saladIndexes = getIngredientIndexes(upakovka, Ingredients.SALAD);

        // Удаляем весь салат из упаковки
        removeIngredient(upakovka, saladIndexes, Ingredients.SALAD);

        // Помещаем весь салат над нижней булочкой
        for (int i = 0; i < saladIndexes.size(); i++) {
            upakovka.add(1, Ingredients.SALAD);
        }
    }

    private static void putCheese (List<Ingredients> upakovka) {
        List<Integer> cheeseIndexes = getIngredientIndexes(upakovka, Ingredients.CHEESE);

        // Удаляем весь сыр из упаковки
        removeIngredient(upakovka, cheeseIndexes, Ingredients.CHEESE);

        //List<Integer> meatIndexes = getIngredientIndexes(upakovka, Ingredients.MEAT);

        // Пока сыр не закончится раскладываем его над котлетами
        for (int i = 0; i < cheeseIndexes.size(); ) {
            for (int j = 0; j < upakovka.size(); j++) {
                if (upakovka.get(j) == Ingredients.MEAT) {
                    upakovka.add(j + 1, Ingredients.CHEESE);
                }
                i++;

            }

        }
    }

}
