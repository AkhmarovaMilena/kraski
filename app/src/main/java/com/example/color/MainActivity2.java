package com.example.color;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setPadding(16, 25, 16, 16);

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null){
            int s = arguments.getInt("square");
            String stock = arguments.getString("stock");
            textView.setText("Площадь поверхности комнаты: " + s + " м²\n" + stock);
        }
        setContentView(textView);
    }


}