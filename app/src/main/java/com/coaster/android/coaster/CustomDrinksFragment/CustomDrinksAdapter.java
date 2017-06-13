package com.coaster.android.coaster.CustomDrinkFragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coaster.android.coaster.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomDrinksAdapter extends RecyclerView.Adapter<CustomDrinksAdapter.ViewHolder> {

    @BindView(R.id.custom_name_text_view)
    TextView nameView;
    @BindView(R.id.custom_ingredients_text_view)
    TextView ingredientsView;
    @BindView(R.id.custom_instruction_text_view)
    TextView instructionsView;

    List<CustomDrinkRecipe> data;

    public CustomDrinksAdapter(List<CustomDrinkRecipe> customDrinksData) {
        this.data = customDrinksData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_drink_item, parent, false);
        ButterKnife.bind(this, view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomDrinksAdapter.ViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(CustomDrinkRecipe nextDrink) {
            if (nextDrink != null) {
                nameView.setText(nextDrink.getDrinkName());
                ingredientsView.setText(nextDrink.getIngredient());
                instructionsView.setText(nextDrink.getInstruction());
            }
        }
    }
}
