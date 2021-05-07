package com.ashwin.framework.noommeallogger.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ashwin.framework.noommeallogger.model.Food;
import com.ashwin.framework.noommeallogger.repository.FoodRepository;

import java.util.List;

public class FoodViewModel extends ViewModel {

    private MutableLiveData<List<Food>> foodItems;

    public FoodViewModel() {
        if (foodItems == null) {
            foodItems = FoodRepository.getInstance().getFoodList();
        }
    }

    public LiveData<List<Food>> getFoodItems() {
        return foodItems;
    }
}
