package com.example.thread;

import android.util.Log;
import android.view.View;

public class ThreadClass extends Thread {



    private DefaultInterface defaultInterface;

    public ThreadClass(DefaultInterface defaultInterface) {
        this.defaultInterface = defaultInterface;
    }

    @Override
    public void run() {
        for (int i = 0; i<16; i++){

            if (i==4){
                defaultInterface.getValue("hello");
            }else if (i==6){
                defaultInterface.getValue("hiiiii");
            }else if (i==8){
                defaultInterface.getValue("manjeet");
            }else if (i==10){
                defaultInterface.getValue("dhaliwal");
                break;
            }

            Log.e("ddd","ddd" + i);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
