package com.example.project;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class Utils {

    public static void show(String str, Context context) {
        if (IS_DEBUG) {
//            Toast.makeText(context, "Toast", Toast.LENGTH_SHORT).show();
            showToast(str, context);
        } else {
//            Log.e("Name", "ShowLog");
            showLog("Log", str);
        }
    }

    public final static boolean IS_DEBUG = false;


    public static void showToast(String str, Context context) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }

    public static void showLog(String string, String str) {
        Log.e(string, str);
    }

    public static int sumArray(int[] arr) {

        int count = 0;
        for (int num : arr) {

            count = count + num;
        }
        return count;
    }

    public static int sumArray1(String[] array) {

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (!array[i].isEmpty()) {
                int sum = Integer.parseInt(String.valueOf(array[i]));
                count = count + sum;
            }

        }
        return count;
    }

    public static int sumInt(String s) {
        int count = 0;
        count = Integer.parseInt(count + s);
        return count;
    }

    protected static class Person {
        String fname = "manjeet";
        String lname = "singh";
        int age = 28;

    }



}
