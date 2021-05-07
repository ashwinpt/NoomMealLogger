package com.ashwin.framework.noommeallogger.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ashwin.framework.noommeallogger.model.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodRepository {

    private static FoodRepository instance;
    private List<Food> foodList = new ArrayList<>();

    // Singleton
    public static FoodRepository getInstance() {
        if (instance == null) {
            instance = new FoodRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Food>> getFoodList() {
        setFoodList();

        MutableLiveData<List<Food>> foodData = new MutableLiveData<>();
        foodData.setValue(foodList);

        return foodData;
    }

    private void setFoodList() {
        foodList.add(new Food("1", "Bananas"));
        foodList.add(new Food("2", "Banana Bread"));
        foodList.add(new Food("3", "Banana Muffin"));
        foodList.add(new Food("4", "Banana Smoothie"));
        foodList.add(new Food("5", "Chicken"));
        foodList.add(new Food("6", "BBQ Chicken"));
        foodList.add(new Food("7", "Chicken Sandwich"));
        foodList.add(new Food("8", "Chicken Roast"));
        foodList.add(new Food("9", "Apple"));
        foodList.add(new Food("10", "Apple Pie"));
        foodList.add(new Food("11", "Apple Tart"));
        foodList.add(new Food("12", "Oatmeal"));
        foodList.add(new Food("13", "Hard boiled Eggs"));
        foodList.add(new Food("14", "Scrambled Eggs"));
        foodList.add(new Food("15", "Toast with eggs"));
        foodList.add(new Food("16", "Orange juice"));
        foodList.add(new Food("17", "Apple juice"));
        foodList.add(new Food("18", "Cranberry juice"));
        foodList.add(new Food("19", "Grape juice"));
        foodList.add(new Food("20", "Whole grain rolled oats"));
        foodList.add(new Food("21", "Almond Milk"));
        foodList.add(new Food("22", "Fat free milk"));
        foodList.add(new Food("23", "1% milk"));
        foodList.add(new Food("24", "2% milk"));
        foodList.add(new Food("25", "Full fat milk"));
        foodList.add(new Food("26", "Soy milk"));
        foodList.add(new Food("27", "Peanut butter sandwich"));
        foodList.add(new Food("28", "Tomato mozzarella sandwich"));
        foodList.add(new Food("29", "Veggie sandwich"));
        foodList.add(new Food("30", "Fruit cup"));
    }
}
