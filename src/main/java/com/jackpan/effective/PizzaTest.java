package com.jackpan.effective;

import static com.jackpan.effective.NyPizza.Size.SMALL;
import static com.jackpan.effective.Pizza.Topping.*;

/**
 * Pizza test.
 *
 * @author jackpan
 * @version v1.0 2020/11/15 09:31
 */
public class PizzaTest {

    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
    }
}
