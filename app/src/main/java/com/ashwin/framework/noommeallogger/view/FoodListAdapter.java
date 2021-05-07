package com.ashwin.framework.noommeallogger.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ashwin.framework.noommeallogger.R;
import com.ashwin.framework.noommeallogger.model.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodItemViewHolder> {
    public interface FoodItemClickListener {
        void onFoodItemClicked(Food food);
    }

    private List<Food> foodList = new ArrayList<>();
    private Context context;

    public FoodListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FoodListAdapter.FoodItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View foodItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item_view, parent, false);
        return new FoodItemViewHolder(foodItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListAdapter.FoodItemViewHolder holder, int position) {
        Food foodItem = foodList.get(position);
        holder.bind(foodItem, food -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(food.getName())
                    .setPositiveButton("OK", (dialog, which) -> { })
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        if (foodList != null) {
            return foodList.size();
        }
        return 0;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
        notifyDataSetChanged();
    }

    public class FoodItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView foodItemImage;
        private TextView foodItemName;

        public FoodItemViewHolder(@NonNull View itemView) {
            super(itemView);

            foodItemImage = itemView.findViewById(R.id.food_item_image_view);
            foodItemName = itemView.findViewById(R.id.food_item_name_view);
        }

        public void bind(Food foodItem, FoodItemClickListener listener) {
            if ( foodItem == null) {
                return;
            }

            foodItemName.setText(foodItem.getName());
            itemView.setOnClickListener(v -> listener.onFoodItemClicked(foodItem));
        }
    }
}
