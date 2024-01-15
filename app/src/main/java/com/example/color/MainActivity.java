package com.example.color;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toast toast;
    EditText textHight, textWeigt, textColorM, textQuantity, textVolume;
    String textStock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textHight = (EditText) findViewById(R.id.EditHight);
        textWeigt = (EditText) findViewById(R.id.EditWidth);

        textColorM = (EditText) findViewById(R.id.EditColorM);
        textQuantity = (EditText) findViewById(R.id.EditQuantity);
        textVolume = (EditText) findViewById(R.id.EditVolume);

        RadioGroup radio = findViewById(R.id.RadioGroupStock);
        radio.setOnCheckedChangeListener((radioGroup, id)->{
            RadioButton radioButton = findViewById(id);
            switch (radioButton.getText().toString()){
                case "10% запаса":
                    textStock = "Кол-во краски с учётом 10% запаса: " + PaintConsumption(0.1) + " л.";
                    break;
                case "15% запаса":
                    textStock = "Кол-во краски с учётом 15% запаса: " + PaintConsumption(0.15) + " л.";
                    break;
                case "Без запаса":
                    textStock = "Кол-во краски без запаса: "  + PaintConsumption(0) + " л.";
                    break;
            }
        });
    }
    public int Square(){ //Площадь комнаты
        int weight = Integer.valueOf(textWeigt.getText().toString());
        int hight = Integer.valueOf(textHight.getText().toString());
        int S = weight * hight;
        return S;
    }
    public double PaintConsumption(double a){ //кол-во необходимой краски
        Square();
        double l = Integer.valueOf(textColorM.getText().toString());
        double q = Integer.valueOf(textQuantity.getText().toString());
        double n = Integer.valueOf(textVolume.getText().toString());
        double V = l * Square() * q * n;
        double s = (V * a)+V;
        return s;
    }
    public void Question1(View view) {
        toast = Toast.makeText(this, "Кол-во литров краски на 1м²", Toast.LENGTH_LONG);
        toast.show();
    }
    public void Question2(View view) {
        toast = Toast.makeText(this, "Рассчёт кол-ва краски с учётом запаса", Toast.LENGTH_LONG);
        toast.show();
    }
    public void Result(View view) {
        try{
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("square", Square());
            intent.putExtra("stock", textStock);
            startActivity(intent);
        }
        catch(Exception ex){
            toast = Toast.makeText(this, "Введите данные", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}