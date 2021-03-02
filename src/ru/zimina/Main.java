package ru.zimina;

import java.util.List;

import static ru.zimina.BurgerPrinter.printBurgerIngredients;
import static ru.zimina.IngredientsPrinter.printPile;


public class Main {
    public static void main(String[] args) {

        // Гененрируем набор упаковок с ингридиентами для обработки
        List<List<Ingredients>> pileOfPackages =
                IngredientsGenerator.generatePileOfIngredients(10);

        printPile(pileOfPackages);

        // Получаем список бракованных упаковок
        List<List<Ingredients>> defectivePackages = BurgerValidator.getDefectivePackages(pileOfPackages);

        // Удаляем все бракованные упаковки
        pileOfPackages.removeAll(defectivePackages);

        if (!pileOfPackages.isEmpty()) {

            for (List<Ingredients> unpreparedBurgers : pileOfPackages) {
                Chef.cookBurger(unpreparedBurgers);
            }
            List<Burger> cookedBurgers = Chef.getAllCookedBurgers();

            System.out.println("ВСЕ ГОТОВЫЕ БУРГЕРЫ:");
            printBurgerIngredients(cookedBurgers);
        } else {
            System.out.println("Ни одна упаковка ингредиентов не соответсвует условиям!");
        }
    }



}
