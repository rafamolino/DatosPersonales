package com.example.pc.datospersonales;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnLimpiar;
    EditText editTextNombre;
    EditText editTextApellidos;
    EditText editTextEdad;
    RadioButton hombre;
    RadioButton mujer;
    Switch switchHijos;
    TextView txtInfo;
    Button btnInfo;
    Spinner opcionesEC;

    int edad=0;
    String genero="";
    String hijos="";
    String error="";
    String menormayor="";
    String cadena1="";
    String cadena2="";
    String cadena3="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] estadoCivil = {getResources().getString(R.string.estadoCivil1) , getResources().getString(R.string.estadoCivil2), getResources().getString(R.string.estadoCivil3) , getResources().getString(R.string.estadoCivil4)};
        ArrayAdapter adaptadorEstadoCivil = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, estadoCivil);

        final Spinner OpcionesEC = findViewById(R.id.OpcionesEC);
        OpcionesEC.setAdapter(adaptadorEstadoCivil);


        editTextApellidos = findViewById(R.id.editTextApellidos);
        editTextEdad = findViewById(R.id.editTextEdad);
        editTextNombre = findViewById(R.id.editTextNombre);
        hombre = findViewById(R.id.radH);
        mujer = findViewById(R.id.radM);
        switchHijos = findViewById(R.id.switchHijos);
        txtInfo = findViewById(R.id.txtInfo);
        btnInfo = findViewById(R.id.btnInfo);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        opcionesEC = findViewById(R.id.OpcionesEC);
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    editTextNombre.setText("");
                    editTextApellidos.setText("");
                    editTextEdad.setText("");
                    txtInfo.setText("");
                    hombre.setChecked(true);
                    mujer.setChecked(false);
                    switchHijos.setChecked(false);
                    editTextNombre.requestFocus();
                                }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(!editTextNombre.getText().toString().isEmpty() && !editTextApellidos.getText().toString().isEmpty() && !editTextEdad.getText().toString().isEmpty() )
                {
                    edad = Integer.parseInt(editTextEdad.getText().toString());
                    txtInfo.setTextColor(getResources().getColor(R.color.negro));
                    genero = (hombre.isChecked()) ? getResources().getString(R.string.gen1) : getResources().getString(R.string.gen2) ;
                    hijos = (switchHijos.isChecked()) ? getResources().getString(R.string.hijosi) : getResources().getString(R.string.hijono);
                    menormayor = (edad >= 18) ? getResources().getString(R.string.mayorEdad) : getResources().getString(R.string.menorEdad);
                    txtInfo.setText(editTextApellidos.getText() + ", " + editTextNombre.getText() + ", " +menormayor + ", "+ genero + ", " +  opcionesEC.getSelectedItem() + " " +  getResources().getString(R.string.y) + " " + hijos + "."  );
                }
                else
                {
                    txtInfo.setTextColor(getResources().getColor(R.color.rojo));
                    cadena1 = (editTextNombre.getText().toString().isEmpty()) ? getResources().getString(R.string.error1) : " ";
                    cadena2 = (editTextApellidos.getText().toString().isEmpty()) ? getResources().getString(R.string.error2) : " ";
                    cadena3 = (editTextEdad.getText().toString().isEmpty()) ? getResources().getString(R.string.error3) : " ";
                    txtInfo.setText(cadena1 + " " + cadena2 + " " + cadena3);
                }

            }
        });
    }
}
