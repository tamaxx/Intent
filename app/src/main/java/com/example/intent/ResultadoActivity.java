package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Bundle extras = getIntent().getExtras();
        String msgtipo = null;
        String msgimprimir = null;
        TextView resultado = findViewById(R.id.txt_Resultado);
        if (extras != null) {
            msgtipo = extras.getString(MainActivity.TIPO);
            String msgcod = getIntent().getStringExtra(MainActivity.CODIGO);
            msgimprimir = extras.getString(MainActivity.IMPRESSAO);

            String txt = String.format("Código do Ingresso: %s \n Tipo do Ingresso: %s \n %s", msgcod, msgtipo, msgimprimir);

            resultado.setText(txt);
        }
    }
}
