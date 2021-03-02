package ru.zimina;

import java.util.ArrayList;
import java.util.List;

import static ru.zimina.Chef.getIngredientIndexes;

/**
 * Класс для проверки упаковок ингредиентов
 */
public class BurgerValidator {

    /**
     * Метод проверки, содержится ли в упаковке ингредиентов достаточное количество ингредиентов
     * для приготовления бургера (проверяется что булочек 2 или 3 и присутствует хотя бы одна котлета)
     * @param upakovka
     * @return
     */
    private static void validate(List<Ingredients> upakovka) throws BurgerException {

        try {
            validateByBuns(upakovka);
            validateByMeat(upakovka);

        } catch (BurgerException e) {

        }
    }

    public static boolean validateByMeat (List<Ingredients> upakovka) throws BurgerException {
        boolean result = upakovka.contains(Ingredients.MEAT);

        if (!result) {
            throw new BurgerException("В упаковке нет мяса!");
        }

        return result;
    }

    public static boolean validateByBuns (List<Ingredients> upakovka) throws BurgerException {
        boolean flag1 = upakovka.contains(Ingredients.BUN);
        boolean flag2 = false;

        if (!flag1) {
            throw new BurgerException("В упаковке нет булочек!");
        } else {
            int bunsCount = getIngredientIndexes(upakovka, Ingredients.BUN).size();
            if (bunsCount < 2) {
                throw new BurgerException("В упаковке не достаточно булочек!");
            } else if (bunsCount > 3) {
                throw new BurgerException("В упаковке слишком много булочек!");
            } else {
                flag2 = true;
            }

        }

        return flag1 && flag2;
    }

    public static List<List<Ingredients>> getDefectivePackages(List<List<Ingredients>> pileOfPackages)  {

        List<List<Ingredients>> defectivePackages = new ArrayList<>();
        // Перебираем упаковки и убираем отбракованные
        for (int i = 0; i < pileOfPackages.size(); i++ ) {
            List<Ingredients> upakovka = pileOfPackages.get(i);

            try {
                validateByMeat(upakovka);
                validateByBuns(upakovka);

            } catch (BurgerException e) {
                System.err.println(e.getMessage() + "\r\n" + upakovka);
                defectivePackages.add(upakovka);
            }

        }

        return defectivePackages;


    }

}
