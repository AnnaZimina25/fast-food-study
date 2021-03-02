package ru.zimina;

import java.util.List;

public class BurgerPrinter {

    public static void printBurgerIngredients(List<Burger> cookedBurger){
        for(Burger burger : cookedBurger){
            System.out.println(burger.toString());
        }

    }
}
