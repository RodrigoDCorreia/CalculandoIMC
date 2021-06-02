package com.example.calculandoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_RESULTADO_IMC = "com.example.calcularimc.extra.resultado.imc";
    int peso;
    float altura;
    float imc;
    String situacao = "";

    EditText mEditPeso, mEditAltura;
    Button mButtonSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mEditPeso = findViewById(R.id.peso);
        mEditAltura = findViewById(R.id.altura);
        mButtonSecond = findViewById(R.id.button_second);

    }

    @SuppressLint("SetTextI18n")
    public void resultado_imc(View view) {

        peso  = Integer.parseInt(mEditPeso.getText().toString());
        altura = Float.parseFloat(mEditAltura.getText().toString());

        imc = peso / (altura * altura);

        if(imc < 18.5){
            situacao = "Abaixo do Peso";
        }else if ((imc >= 18.5)&&(imc < 25)){
            situacao = "Peso Ideal";
        }else if ((imc >=25.0)&&(imc >=30.0)){
            situacao = "Levemente acima do Peso";
        }else if((imc >=30.0)&&(imc >=35.0)){
            situacao = "Obesidade Grau I";
        }else if ((imc >=35.0)&&(imc >=40.0)){
            situacao = "Obesidade Grau II (Severa)";
        }else {
            situacao = "Obesidade Grau III (Mórbida)";
        }

        mButtonSecond.setText("\nPeso:" + mEditPeso.getText().toString() + "kg" + "\nAltura:" + mEditAltura.getText().toString() + "m"
                +" \n\nIMC:" + String.valueOf(imc) + "\nSituação:" + situacao);

        Button button_second = (Button) view;
        String editPeso = button_second.getText().toString();
        String editAltura = button_second.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_RESULTADO_IMC,editPeso);
        intent.putExtra(EXTRA_RESULTADO_IMC,editAltura);
        setResult(RESULT_OK,intent);
        finish();
    }
}