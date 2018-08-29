package com.example.trungtrucnguyen.thucdonhangngay.DataManager;

import com.example.trungtrucnguyen.thucdonhangngay.IngredientItem;

import java.util.ArrayList;
import java.util.Random;

public class IngredientDataManager {
    public static final String[] name = new String[] {
            "Khổ qua",
            "Cà chua",
            "Đậu đũa",
            "Đậu bắp",
            "Ớt sừng đỏ",
            "Cải trắng",
            "Thịt chả cá",
            "Xương heo"};

    public static final int[] amount = new int[] {1, 3, 100, 5, 5, 2, 300, 500};

    public static final String[] unit = new String[] {
            "trái", "trái",
            "gram", "trái", "trái", "củ", "gram", "gram"};

    public static ArrayList<IngredientItem> getIngredientList(){
        ArrayList<IngredientItem> list = new ArrayList<IngredientItem>();
        for (int i = 0; i < name.length; i++) {
            IngredientItem ingredientItem = new IngredientItem();
            ingredientItem.setName(name[i]);
            ingredientItem.setAmount(amount[i]);
            ingredientItem.setUnit(unit[i]);
            list.add(ingredientItem);
        }
        return list;
    }

    public static IngredientItem getRandomItem(){
        IngredientItem ingredientItem = new IngredientItem();
        int randomValue = new Random().nextInt(name.length);
        ingredientItem.setName(name[randomValue]);
        ingredientItem.setAmount(amount[randomValue]);
        ingredientItem.setUnit(unit[randomValue]);

        return ingredientItem;
    }
}
