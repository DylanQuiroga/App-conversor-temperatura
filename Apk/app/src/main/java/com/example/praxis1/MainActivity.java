package com.example.praxis1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] unidades = {"°C", "°F", "K", "°Re", "°Ra"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unidades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Button boton = findViewById(R.id.boton);
        Button ayuda = findViewById(R.id.ayuda);
        Spinner spinner = findViewById(R.id.spinner);
        EditText valor = findViewById(R.id.valor);
        EditText resultado = findViewById(R.id.resultado);
        resultado.setEnabled(false);
        resultado.setTextColor(-16777216);

        spinner.setAdapter(adapter);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double valorIn = Double.parseDouble(valor.getText().toString());
                    double gc, gf, k, gre, gra;

                    DecimalFormat df = new DecimalFormat("#.00");

                    if(spinner.getSelectedItem() == "°C"){
                        gf = Double.parseDouble(df.format(1.8 * valorIn + 32));
                        k = Double.parseDouble(df.format(valorIn + 273.15));
                        gre = Double.parseDouble(df.format(valorIn / 1.25));
                        gra = Double.parseDouble(df.format(valorIn * 1.8 + 491.67));

                        resultado.setText(gf + " °F\n" + k + " K \n" + gre + " °Re\n" + gra + " °Ra");

                    }else if (spinner.getSelectedItem() == "°F"){
                        gc = Double.parseDouble(df.format((valorIn - 32) / 1.8));
                        k = Double.parseDouble(df.format((5 * valorIn + 2298.35) / 9));
                        gre = Double.parseDouble(df.format((valorIn - 32) * 0.44));
                        gra = Double.parseDouble(df.format(valorIn + 459.76));

                        resultado.setText(gc + " °C \n" + k + " K \n" + gre + " °Re\n" + gra + " °Ra");

                    } else if (spinner.getSelectedItem() == "K") {
                        gc = Double.parseDouble(df.format(valorIn - 273.15));
                        gf = Double.parseDouble(df.format((5 * valorIn + 2298.35) / 9));
                        gre = Double.parseDouble(df.format((valorIn - 273.15) * 0.80));
                        gra = Double.parseDouble(df.format(valorIn * 1.8));

                        resultado.setText(gc + " °C \n" + gf + " F \n" + gre + " °Re\n" + gra + " °Ra");

                    } else if (spinner.getSelectedItem() == "°Re") {
                        gc = Double.parseDouble(df.format(valorIn / 0.80));
                        gf = Double.parseDouble(df.format(valorIn * 2.250));
                        k = Double.parseDouble(df.format((valorIn / 0.80) + 273.15));
                        gra = Double.parseDouble(df.format((valorIn * 2.250) + 492.67));

                        resultado.setText(gc + " °C \n" + gf + " F \n" + k + " K\n" + gra + " °Ra");

                    } else if (spinner.getSelectedItem() == "°Ra") {
                        gc = Double.parseDouble(df.format((valorIn - 491.67) * 1.8));
                        gf = Double.parseDouble(df.format(valorIn - 459.67));
                        k = Double.parseDouble(df.format(valorIn * 1.8));
                        gre = Double.parseDouble(df.format((valorIn - 491.67)*0.44));

                        resultado.setText(gc + " °C \n" + gf + " F \n" + k + " K\n" + gre + " °Re");
                    }
                }catch (Exception e){
                    System.out.println("error");
                }
            }
        });

        ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInfoWindow(view);
            }
        });

    }

    public void openInfoWindow(View view) {
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }

}