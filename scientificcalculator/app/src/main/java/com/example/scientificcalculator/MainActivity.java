package com.example.scientificcalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.zero_btn)
    Button zeroBtn;
    @BindView(R.id.one_btn)
    Button oneBtn;
    @BindView(R.id.two_btn)
    Button twoBtn;
    @BindView(R.id.three_btn)
    Button threeBtn;
    @BindView(R.id.four_btn)
    Button fourBtn;
    @BindView(R.id.five_btn)
    Button fiveBtn;
    @BindView(R.id.six_btn)
    Button sixBtn;
    @BindView(R.id.seven_btn)
    Button sevenBtn;
    @BindView(R.id.eight_btn)
    Button eightBtn;
    @BindView(R.id.nine_btn)
    Button nineBtn;
    @BindView(R.id.list_iv)
    ImageView listIv;
    @BindView(R.id.screen_1)
    TextView screen1;
    @BindView(R.id.screen_2)
    TextView screen2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.list_iv)
    public void onListClick(View v) {
        ListFrag listFrag = new ListFrag();
        getSupportFragmentManager().beginTransaction()
                .add(android.R.id.content, listFrag)
                .addToBackStack(listFrag.getTag())
                .commit();
    }

    @OnClick(R.id.zero_btn)
    public void onZeroClick(View v) {
//        String value = screen1.getText().toString();
        screen1.setText(getScreen1Text() + "0");
    }

    @OnClick(R.id.one_btn)
    public void onOneClick(View v) {
        screen1.setText(getScreen1Text() + "1");
    }

    @OnClick(R.id.two_btn)
    public void onTwoClick(View v) {
        screen1.setText(getScreen1Text() + "2");
    }

    @OnClick(R.id.three_btn)
    public void onThreeClick(View v) {
        screen1.setText(getScreen1Text() + "3");
        Log.e("hello", "three");
    }

    @OnClick(R.id.four_btn)
    public void onFourCLick(View v) {
        screen1.setText(getScreen1Text() + "4");
    }

    @OnClick(R.id.five_btn)
    public void onFiveClick(View v) {
        screen1.setText(getScreen1Text() + "5");
    }

    @OnClick(R.id.six_btn)
    public void onSixClick(View v) {
        screen1.setText(getScreen1Text() + "6");
    }

    @OnClick(R.id.seven_btn)
    public void onSevenClick(View v) {
        screen1.setText(getScreen1Text() + "7");
    }

    @OnClick(R.id.eight_btn)
    public void onEightClick(View v) {
        screen1.setText(getScreen1Text() + "8");
    }

    @OnClick(R.id.nine_btn)
    public void onNineClick(View v) {
        screen1.setText(getScreen1Text() + "9");
    }

    @OnClick(R.id.dot_btn)
    public void onDotClick(View v) {
        if (!getScreen1Text().contains(".")) {
            screen1.setText(getScreen1Text() + ".");
        }
    }

    @OnClick(R.id.plus_btn)
    public void onPlusClick(View v) {
        screen1.setText(getScreen1Text() + "+");
    }

    @OnClick(R.id.minus_btn)
    public void onMinusClick(View v) {
        screen1.setText(getScreen1Text() + "-");
    }

    @OnClick(R.id.multply_btn)
    public void onMultiplyClick(View v) {
        screen1.setText(getScreen1Text() + "*");
    }

    @OnClick(R.id.divide_btn)
    public void onDivideClick(View v) {
        screen1.setText(getScreen1Text() + "/");
    }

    @OnClick(R.id.exp_btn)
    public void onExpClick(View v) {
        screen1.setText(getScreen1Text() + "Exp");
    }

    @OnClick(R.id.ans_btn)
    public void onAnsClick(View v) {
        screen1.setText(getScreen1Text() + "Ans");
    }

    @OnClick(R.id.del_btn)
    public void onDlteBtn(View v) {
        String[]
                arr = getScreen1Text().split("");
        arr[arr.length - 1] = "";

        String val = "";

        for (int i = 0; i < arr.length; i++) {
            val = val + arr[i];
        }

        screen1.setText(val);
        screen2.setText(val);
    }

    @OnClick(R.id.AC_btn)
    public void onAcBtn(View v) {
        screen1.setText("");
        screen2.setText("");
    }

    @OnClick(R.id.equal_btn)
    public void onEqualClick(View v) {
        if (!getScreen1Text().isEmpty()) {
            if (getScreen1Text().contains("+")) {
                String[] arr = getScreen1Text().split("\\+");
//
//                int val1 = Integer.parseInt(arr[0]);
//                int val2 = Integer.parseInt(arr[1]);
//
//                int tot = val1 + val2;
//
//                screen2.setText(String.valueOf(tot));

                int temp = 0;

                for (int i = 0; i < arr.length; i++) {
                    int val = Integer.parseInt(arr[i]);
                    temp = temp + val;
                }

                screen2.setText(String.valueOf(temp));
            }

            if (getScreen1Text().contains("-")) {
                String[] arr = getScreen1Text().split("-");

                int temp = 0;

                for (int i = 0; i < arr.length; i++) {
                    int val = Integer.parseInt(arr[i]);

                    if (temp == 0) {
                        temp = val;
                    } else {
                        temp = temp - val;
                    }
                }

                screen2.setText(String.valueOf(temp));
            }
        }
        if (getScreen1Text().contains("*")) {
            String[] arr = getScreen1Text().split("\\*");

            int temp = 0;

            for (int i = 0; i < arr.length; i++) {
                int val = Integer.parseInt(arr[i]);

                if (temp == 0) {
                    temp = val;
                } else {
                    temp = temp * val;
                }
            }
            screen2.setText(String.valueOf(temp));
        }

        if (getScreen1Text().contains("/")) {
            String[] arr = getScreen1Text().split("/");

            int temp = 0;

            for (int i = 0; i < arr.length; i++) {
                int val = Integer.parseInt(arr[i]);
//                float b = (float) temp;
//                float val = Float.parseFloat("i");

                if (temp == 0) {
                    temp = val;
                } else {
                    temp = temp / val;
                }
            }
            screen2.setText(String.valueOf((float) temp));
        }
    }

    private String getScreen1Text() {
        return screen1.getText().toString();
    }
}
