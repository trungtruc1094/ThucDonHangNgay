package com.example.trungtrucnguyen.thucdonhangngay.utils;

import android.content.Context;
import android.content.res.TypedArray;

public class DimensionUtils {
    /**
     * Change value in dp to pixels
     * @param dp
     * @param context
     * @return
     */
    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

}
