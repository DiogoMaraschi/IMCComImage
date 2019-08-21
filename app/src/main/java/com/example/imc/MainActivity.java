package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_calc = (Button) findViewById(R.id.botao_calc);
        Button btn_creditos = (Button) findViewById(R.id.botao_creditos);


        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText alt = (EditText) findViewById(R.id.alt_main);
                EditText pes = (EditText) findViewById(R.id.pes_main);

                TextView result = findViewById(R.id.text_mostrar);

                String aux = (String) alt.getText().toString();
                String aux2 = (String) pes.getText().toString();

                final Double altura = Double.parseDouble(aux);

                final Double peso = Double.parseDouble(aux2);

               Double aux3 = (peso/(altura*altura));

               String aux4 = null;

               if(aux3<=17.99){
                   aux4 = "abaixo do peso";

               } else if (aux3<=24.99){

                   aux4 = "peso normal";

               }else if (aux3>24.99){
                   aux4 ="acima do peso";
               }

               String resultado = String.valueOf(aux3);

               result.setText(resultado+" "+aux4);


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
