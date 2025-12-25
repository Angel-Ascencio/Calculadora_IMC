package org.utl.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class dos extends AppCompatActivity {

    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);

        txtResultado=findViewById(R.id.txtResultado);

        // Recibimos el valor
        double imc = getIntent().getDoubleExtra("IMC", 0.0);

        String diagnostico = obtenemosIMC(imc);

        // Mostrar el IMC
        txtResultado.setText("Su IMC es: " + imc + "\nDiagnóstico: " + diagnostico);
    }


    private String obtenemosIMC(double imc) {
        if (imc < 18.5) {
            return "Bajo de peso";
        } else if (imc >= 18.5 && imc <= 24.9) {
            return "Peso normal";
        } else if (imc >= 25 && imc <= 29.9) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc <= 34.9) {
            return "Obesidad tipo 1";
        } else if (imc >= 35 && imc <= 39.9) {
            return "Obesidad tipo 2";
        } else {
            return "Obesidad tipo 3";
        }
    }
}