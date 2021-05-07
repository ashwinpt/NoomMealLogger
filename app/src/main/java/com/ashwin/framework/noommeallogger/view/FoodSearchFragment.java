package com.ashwin.framework.noommeallogger.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ashwin.framework.noommeallogger.R;
import com.ashwin.framework.noommeallogger.model.Food;
import com.ashwin.framework.noommeallogger.viewmodel.FoodViewModel;

import java.util.ArrayList;
import java.util.List;

public class FoodSearchFragment extends Fragment {

    private RecyclerView foodItemsRecyclerView;
    private EditText searchItemsEditText;

    private FoodListAdapter foodListAdapter;
    private FoodViewModel foodViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        foodViewModel = ViewModelProviders.of(this).get(FoodViewModel.class);
        return inflater.inflate(R.layout.food_list_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchItemsEditText = view.findViewById(R.id.food_item_search_text);
        foodItemsRecyclerView = view.findViewById(R.id.food_items_recycler_view);

        foodListAdapter = new FoodListAdapter(getContext());
        foodViewModel.getFoodItems().observe(getViewLifecycleOwner(), foods -> foodListAdapter.setFoodList(foods));

        searchItemsEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                filterFoodList(s.toString());
            }
        });

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        foodItemsRecyclerView.setLayoutManager(layoutManager);
        foodItemsRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), layoutManager.getOrientation()));
        foodItemsRecyclerView.setAdapter(foodListAdapter);
    }

    private void filterFoodList(String searchText) {
        List<Food> completeList = foodViewModel.getFoodItems().getValue();

        if (completeList == null || completeList.isEmpty()) {
            return;
        }

        if (searchText == null || searchText.isEmpty()) {
            foodListAdapter.setFoodList(completeList);
            return;
        }

        List<Food> filteredList = new ArrayList<>();

        for (Food food : completeList) {
            if (food.getName().toLowerCase().contains(searchText.toLowerCase())) {
                filteredList.add(food);
            }
        }
        foodListAdapter.setFoodList(filteredList);
    }
}
