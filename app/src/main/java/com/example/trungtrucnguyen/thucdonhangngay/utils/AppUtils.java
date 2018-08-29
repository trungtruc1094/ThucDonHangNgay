package com.example.trungtrucnguyen.thucdonhangngay.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * The utility class where all utility methods are present and can be used
 * anywhere in the app.
 *
 * @author Amruta.Doye
 *
 */
public class AppUtils {

    /**
     * The method to show toast messages.
     *
     * @param context
     * @param message
     */
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}