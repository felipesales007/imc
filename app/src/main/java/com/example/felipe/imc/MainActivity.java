package com.example.felipe.imc;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    EditText etPeso, etAltura;
    ImageView btnCalcular, btnLimpar;
    double peso, altura, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getSupportActionBar().hide();
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = (EditText) findViewById(R.id.etPeso);
        etAltura = (EditText) findViewById(R.id.etAltura);

        btnCalcular = (ImageView) findViewById(R.id.btnCalcular);
        btnLimpar = (ImageView) findViewById(R.id.btnLimpar);

        btnLimpar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    etPeso.setText("");
                    etAltura.setText("");
                }
                catch (Exception e)
                {

                }
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    if(etPeso.getText().length() == 0 && etAltura.getText().length() == 0)
                    {
                        alerta("Atenção", "Campo peso e altura estão em branco!");
                        return;
                    }
                    if(etPeso.getText().length() == 0)
                    {
                        alerta("Atenção", "Campo peso está em branco!");
                        return;
                    }
                    if(etAltura.getText().length() == 0)
                    {
                        alerta("Atenção", "Campo altura está em branco!");
                        return;
                    }
                    else
                    {
                        peso = Double.parseDouble(etPeso.getText().toString());
                        altura = Double.parseDouble(etAltura.getText().toString());
                        resultado = peso / (altura * altura);
                        //alerta("Resultado", String.valueOf(resultado));

                        if(resultado < 17)
                        {
                            alerta("Atenção!", "Você está muito abaixo do peso!");
                        }
                        if(resultado >= 17 && resultado <= 18.49)
                        {
                            alerta("Atenção!", "Você está abaixo do peso!");
                        }
                        if(resultado >= 18.50 && resultado <= 24.99)
                        {
                            alerta("Atenção!", "Você está com o  peso ideal!");
                        }
                        if(resultado >= 25 && resultado <= 29.99)
                        {
                            alerta("Atenção!", "Você está acima do peso!");
                        }
                        if(resultado >= 30 && resultado <= 34.99)
                        {
                            alerta("Atenção!", "Você está com obesidade I!");
                        }
                        if(resultado >= 35 && resultado <= 39.99)
                        {
                            alerta("Atenção!", "Você está com obesidade II (servera)!");
                        }
                        if(resultado >= 40)
                        {
                            alerta("Atenção!", "Você está com obesidade III (mórbida)!");
                        }
                        return;
                    }
                }
                catch (Exception e)
                {

                }
            }
        });
    }

    public void alerta(String titulo, String mensagem)
    {
        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);

        alerta.setTitle(titulo);
        alerta.setMessage(mensagem);
        alerta.setNeutralButton("OK", null);
        alerta.show();
    }
}
