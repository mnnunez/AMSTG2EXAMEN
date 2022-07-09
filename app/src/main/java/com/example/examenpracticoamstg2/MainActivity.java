package com.example.examenpracticoamstg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.filament.View;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RequestQueue mQueue = null;
    private String URL = "https://superheroapi.com/api/725568518702609";
    private EditText textoSearch;
    private Button btnBuscar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoSearch=(EditText) findViewById(R.id.heroeBuscar);
        btnBuscar=(Button) findViewById(R.id.button);

        btnBuscar.setOnClickListener(view ->{
            Intent pasarAHeroes= new Intent(this, ResultadosHeroes.class);
            pasarAHeroes.putExtra("heroeUsuario", textoSearch.getText().toString());
            startActivity(pasarAHeroes);
        } );
    }



}