package com.epam.collections.queue;

import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DishOrderDeterminer {
    private AbstractSequentialList<Integer> generateDishes(int numberOfDishes) {
        var cycledDishesList = new LinkedList<Integer>();
        for (var dish = 1; dish <= numberOfDishes; dish += 1) {
            cycledDishesList.addLast(dish);
        }
        return cycledDishesList;
    }

    private void eatDishes(List<Integer> dishesOrder, AbstractSequentialList<Integer> cycledDishesList, int everyDishNumberToEat) {
        var dishNumber = 0;
        var dishesEaten = 0;
        while (dishesEaten < everyDishNumberToEat && !cycledDishesList.isEmpty()) {
            var linkedIterator = cycledDishesList.listIterator();
            while (linkedIterator.hasNext()) {
                dishNumber += 1;
                var currentDish = linkedIterator.next();
                if (dishNumber % everyDishNumberToEat == 0) {
                    linkedIterator.remove();
                    dishesOrder.add(currentDish);
                    dishesEaten += 1;
                }
            }
        }
    }

    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        var dishesOrder = new ArrayList<Integer>();
        var cycledDishesList = generateDishes(numberOfDishes);

        while (!cycledDishesList.isEmpty()) {
            eatDishes(dishesOrder, cycledDishesList, everyDishNumberToEat);
        }

        return dishesOrder;
    }
}
