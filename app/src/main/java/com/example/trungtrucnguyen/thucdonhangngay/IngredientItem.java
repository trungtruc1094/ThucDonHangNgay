package com.example.trungtrucnguyen.thucdonhangngay;

import java.io.Serializable;

public class IngredientItem implements Serializable {
    private String name;
    private int amount;
    private String unit;
    private boolean isCheckboxChecked;

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public boolean isCheckboxChecked(){
        return isCheckboxChecked;
    }

    public void setCheckboxChecked(boolean isCheckboxChecked){
        this.isCheckboxChecked = isCheckboxChecked;
    }
}
