package com.oscarmatos.android.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mCampoPeso;
    EditText mCampoEstatura;
    Button mBotonCalcular;
    Button mBotonLimpiar;
    TextView mEtiquetaIMC;
    TextView mEtiquetaOMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCampoPeso=(EditText)findViewById(R.id.campo_peso);
        mCampoEstatura=(EditText)findViewById(R.id.campo_estatura);
        mBotonCalcular=(Button)findViewById(R.id.boton_calcular);
        mBotonLimpiar=(Button)findViewById(R.id.boton_limpiar);
        mEtiquetaIMC=(TextView)findViewById(R.id.etiqueta_imc);
        mEtiquetaOMS=(TextView)findViewById(R.id.etiqueta_oms_res);

        mBotonCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String s = mCampoPeso.getText().toString();
                double peso=Double.parseDouble(s);
                s=mCampoEstatura.getText().toString();
                double estatura=Double.parseDouble(s);
                double imc = peso/(estatura*estatura);
                s=String.format("%2.2f",imc);
                mEtiquetaIMC.setText(s);
                if(imc<18.5)
                {
                    mEtiquetaOMS.setText(R.string.texto_etiqueta_oms_bajo);
                }
                if(imc>=18.5 && imc<=24.99){
                    mEtiquetaOMS.setText(R.string.texto_etiqueta_oms_PN);
                }
                if (imc>=25.0 && imc<=29.99){
                    mEtiquetaOMS.setText(R.string.texto_etiqueta_oms_SP);
                }
                if (imc>=30.00 && imc<=39.99){
                    mEtiquetaOMS.setText(R.string.texto_etiqueta_oms_Ob);
                }
                if(imc>40.0){
                    mEtiquetaOMS.setText(R.string.texto_etiqueta_oms_OE);
                }
            }
        });

        mBotonLimpiar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCampoPeso.setText("");
                mCampoEstatura.setText("");
                mEtiquetaIMC.setText("0.0");
                mEtiquetaOMS.setText("--");
            }
        });
    }
}
