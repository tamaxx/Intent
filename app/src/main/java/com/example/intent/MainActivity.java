package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    public final static String CODIGO = "com.example.intent.VALUE";
    public final static String IMPRESSAO = "com.example.intent.PRINT";
    public final static String TIPO = "com.example.intent.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EnviarMensagem(View v) {
        EditText txt_Cod = findViewById(R.id.txtCod_Ingresso2);
        TextView txt_Alerta = findViewById(R.id.txt_Aviso);
        RadioButton rdb_Inteira = findViewById(R.id.rdb_Inteira);
        RadioButton rdb_Meia = findViewById(R.id.rdb_Meia);
        Switch swt_Imprimir = findViewById(R.id.swt_Imprimir);

        Intent intent = new Intent(this, ResultadoActivity.class);
        String codigo = txt_Cod.getText().toString();
        String tipo = null;

            if (rdb_Meia.isChecked()) {
                tipo = "Meia";
            } else if (rdb_Inteira.isChecked()) {
                tipo = "Inteira";
            }

            String imprimir = null;

            if (swt_Imprimir.isChecked()) {
                imprimir = "Impressão de Ingressos requisitada";
            } else {
                imprimir = "Impressão de Ingressos não requisitada";
            }

            intent.putExtra(IMPRESSAO, imprimir);
            intent.putExtra(TIPO, tipo);
            intent.putExtra(CODIGO, codigo);
            if (codigo.length() == 8) {
                startActivity(intent);
            }
            else {
                String alerta;
                alerta = "Por favor, insira um código de ingresso válido (8 dígitos)";
                txt_Alerta.setText(alerta);
            }
    }
}
