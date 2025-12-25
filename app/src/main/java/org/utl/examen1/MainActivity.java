package org.utl.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btnBoton;
    EditText txtPeso;
    EditText txtEstatura;
    TextView txtR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBoton=findViewById(R.id.btnBoton);
        txtPeso=findViewById(R.id.txtPeso);
        txtEstatura=findViewById(R.id.txtEstatura);

        btnBoton.setOnClickListener(view -> {
           calcular();
        });
    }
    private void calcular() {
        String pesoStr = txtPeso.getText().toString();
        String estaturaStr = txtEstatura.getText().toString();

        // los campos estan vacios los verificamos
        if (!pesoStr.isEmpty() && !estaturaStr.isEmpty()) {

            double peso = Double.parseDouble(pesoStr);
            double estatura = Double.parseDouble(estaturaStr);

            // Calculamos el IMC
            double imc = peso / (estatura * estatura);

            Intent abrirSegundaVista = new Intent(this, dos.class);
            abrirSegundaVista.putExtra("IMC", imc);
            startActivity(abrirSegundaVista);
        }
    }
}