package com.example.praxis1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Button boton = findViewById(R.id.boton);
    Spinner spinner = findViewById(R.id.spinner);
    EditText valor = findViewById(R.id.valor);
    EditText resultado = findViewById(R.id.resultado);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}