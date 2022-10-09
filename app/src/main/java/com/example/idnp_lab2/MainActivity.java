package com.example.idnp_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

class Postulante {
    String nombres;
    String apaterno;
    String amaterno;
    String fecha;
    String colegio;
    String carrera;

    public Postulante(String nombres, String apaterno, String amaterno,
                      String fecha, String colegio, String carrera){
        this.nombres = nombres;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.fecha = fecha;
        this.colegio = colegio;
        this.carrera = carrera;
    }

    public String getPostulante(){
        return nombres+","+apaterno+","+amaterno+","+fecha+","+colegio+","+carrera;
    }
}

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Postulante> info = new ArrayList<>();
        EditText editNombres = findViewById(R.id.editNombres);
        EditText editAPaterno = findViewById(R.id.editAPaterno);
        EditText editAMaterno = findViewById(R.id.editAMaterno);
        EditText editFecha = findViewById(R.id.editFecha);
        EditText editColegio = findViewById(R.id.editColegio);
        EditText editCarrera = findViewById(R.id.editCarrera);
        TextView txtMensaje = findViewById(R.id.textMensaje);

        Button btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombres = editNombres.getText().toString();
                String apaterno = editAPaterno.getText().toString();
                String amaterno = editAMaterno.getText().toString();
                String fecha = editFecha.getText().toString();
                String colegio = editColegio.getText().toString();
                String carrera = editCarrera.getText().toString();

                if(!(TextUtils.isEmpty(nombres) || TextUtils.isEmpty(apaterno) || TextUtils.isEmpty(amaterno)
                || TextUtils.isEmpty(fecha) || TextUtils.isEmpty(colegio) || TextUtils.isEmpty(carrera))) {
                    Log.d(TAG,"Registrado: "+nombres+","+apaterno+","+amaterno+","+fecha+","+colegio+","+carrera);
                    txtMensaje.setText("Registro exitoso");
                    info.add(new Postulante(nombres, apaterno, amaterno, fecha, colegio, carrera));
                } else {
                    txtMensaje.setText("Registro invalido");
                    Log.d(TAG,"Registro invalido");
                }
            }
        });

        Button btnListar = (Button) findViewById(R.id.btnListar);
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0; i<info.size(); i++){
                    String registro = info.get(i).getPostulante();
                    Log.d(TAG,"Registro "+i+":"+registro);
                }
            }
        });
    }
}