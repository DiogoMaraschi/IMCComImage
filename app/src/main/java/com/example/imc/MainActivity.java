package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_calc = (Button) findViewById(R.id.botao_calc);
        Button btn_creditos = (Button) findViewById(R.id.botao_creditos);
        final ImageView imgAbaixo = findViewById(R.id.imgAbaixo);
        final ImageView imgNormal = findViewById(R.id.imgNormal);
        final ImageView imgOb1 = findViewById(R.id.imgOb1);
        final ImageView imgOb2= findViewById(R.id.imgOb2);
        final ImageView imgOb3= findViewById(R.id.imgOb3);
        final ImageView imgPerfil= findViewById(R.id.imgPerfil);
        final ImageView imgSobrepeso= findViewById(R.id.imgSobrepeso);
        imgAbaixo.setVisibility(View.INVISIBLE);
        imgNormal.setVisibility(View.INVISIBLE);
        imgOb1.setVisibility(View.INVISIBLE);
        imgOb2.setVisibility(View.INVISIBLE);
        imgOb3.setVisibility(View.INVISIBLE);
        imgSobrepeso.setVisibility(View.INVISIBLE);

        imgPerfil.setVisibility(View.VISIBLE);


        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgPerfil.setVisibility(View.INVISIBLE);
                EditText alt = (EditText) findViewById(R.id.alt_main);
                EditText pes = (EditText) findViewById(R.id.pes_main);

                TextView result = findViewById(R.id.text_mostrar);

                String aux = (String) alt.getText().toString();
                String aux2 = (String) pes.getText().toString();

                final Double altura = Double.parseDouble(aux);

                final Double peso = Double.parseDouble(aux2);

                Double aux3 = (peso / (altura * altura));

                String aux4 = null;

                if (aux3 <= 18.5) {
                    aux4 = "Você está abaixo do peso ideal";
                    imgAbaixo.setVisibility(View.VISIBLE);

                } else if (aux3 <= 24.99) {
                    aux4 = "Você está no peso normal";
                    imgNormal.setVisibility(View.VISIBLE);
                } else if (aux3 < 29.9) {
                    aux4 = "Você está com sobrepeso";
                    imgSobrepeso.setVisibility(View.VISIBLE);
                } else if (aux3 < 34.9) {
                    aux4 = "Você está com obesidade 1";
                    imgOb1.setVisibility(View.VISIBLE);
                } else if (aux3 < 39.9) {
                    aux4 = "Você está com obesidade 2";
                    imgOb2.setVisibility(View.VISIBLE);
                } else if (aux3 > 40) {
                    aux4 = "Você está com obesidade 3";
                    imgOb3.setVisibility(View.VISIBLE);
                }

                String resultado = String.valueOf(aux3);

                result.setText(resultado + " " + aux4);

            }
        });

        btn_creditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent vai_pros_credito = new Intent(MainActivity.this, creditos_Activity.class);
                startActivity(vai_pros_credito);


            }
        });
    }
}
