package com.example.trungtrucnguyen.thucdonhangngay;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class IngredientListAdapter extends BaseAdapter {
    private ArrayList<IngredientItem> mItemsList;
    private LayoutInflater mLayoutInflater;

    public IngredientListAdapter(Context context, ArrayList<IngredientItem> list){
        mItemsList = list;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setmItemsList(ArrayList<IngredientItem> mItemsList) {
        this.mItemsList = mItemsList;
        notifyDataSetChanged();
    }

    public ArrayList<IngredientItem> getmItemsList() {
        return mItemsList;
    }

    @Override
    public int getCount() {
        if (mItemsList != null) {
            return mItemsList.size();
        } else {
            return 0;
        }
    }

    @Override
    public IngredientItem getItem(int i) {
        IngredientItem ingredientItem = null;
        if (mItemsList != null && mItemsList.size() > 0){
            ingredientItem = mItemsList.get(i);
        }
        return ingredientItem;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;

        if (view == null){
            ViewHolder viewHolder = new ViewHolder();
            view = mLayoutInflater.inflate(R.layout.ingredient_item_layout, viewGroup, false);
            viewHolder.itemLayout = (RelativeLayout) view.findViewById(R.id.itemLayout);
            viewHolder.ingredient_checkbox = (CheckBox) view.findViewById(R.id.ingredient_checkbox);
            viewHolder.ingredient_name = (TextView) view.findViewById(R.id.ingredient_name);
            viewHolder.ingredient_amount = (TextView) view.findViewById(R.id.ingredient_amount);
            viewHolder.ingredient_unit = (TextView) view.findViewById(R.id.ingredient_unit);
            view.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) view.getTag();
        final IngredientItem ingredientItem = getItem(i);
        if (ingredientItem != null && viewHolder != null){
            if ((i % 2) == 0){
                viewHolder.itemLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            } else {
                viewHolder.itemLayout.setBackgroundColor(Color.parseColor("#A6A6A6"));
            }

            viewHolder.ingredient_name.setText(ingredientItem.getName());
            viewHolder.ingredient_amount.setText(String.valueOf(ingredientItem.getAmount()));
            viewHolder.ingredient_unit.setText(ingredientItem.getUnit());

            viewHolder.ingredient_checkbox.setTag(i);
            viewHolder.ingredient_checkbox.setChecked(ingredientItem.isCheckboxChecked());
        }

        return view;
    }

    public static class ViewHolder{
        RelativeLayout itemLayout;
        CheckBox ingredient_checkbox;
        TextView ingredient_name;
        TextView ingredient_amount;
        TextView ingredient_unit;
    }
}
