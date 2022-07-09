package com.example.examenpracticoamstg2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultadosHeroes extends AppCompatActivity {
    private RequestQueue mQueue;
    private String token="725568518702609";
    //private TextView resultadosCaja;
    RecyclerView recyclerDatos;
    ArrayList<String> ListDatos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_heroes);
        String heroeAbuscar = getIntent().getStringExtra("heroeUsuario");
        System.out.println("PRUEBA LLEGA "+heroeAbuscar);

        mQueue= Volley.newRequestQueue(this);
        recyclerDatos=(RecyclerView) findViewById(R.id.recyclerDatos);
        recyclerDatos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        ListDatos=new ArrayList<String>();


        //AdaptadordeDatos adapter = new AdaptadordeDatos(ListDatos);
        //recyclerDatos.setAdapter(adapter);


        //resultadosCaja=(TextView) findViewById(R.id.viewResultados);
        //resultadosMostrar=(ScrollView) findViewById(R.id.viewResultados);


        Map<String, String> params = new HashMap<String, String>();
        String urlSearch= "https://superheroapi.com/api/725568518702609/search/"+heroeAbuscar;
        JsonObjectRequest request_SearchID = new JsonObjectRequest(Request.Method.GET,
                urlSearch, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void
                    onResponse(JSONObject response) {

                        try {
                            //getJSONObject("LabelData").getString("slogan");
                            JSONArray dict_response= response.getJSONArray("results");
                            for(int i=0; i<dict_response.length(); i++ ){
                                JSONObject object = dict_response.getJSONObject(i);
                                //resultadosCaja.setText(object.getString("name"));
                                //System.out.println("object");
                                System.out.println(object.getString("name"));

                                ListDatos.add(i+". "+object.getString("name"));
                                AdaptadordeDatos adapter = new AdaptadordeDatos(ListDatos);
                                recyclerDatos.setAdapter(adapter);

                            }


//                            System.out.println(prueba1);
                            //resultadosCaja.setText("hp");
//                            resultadosCaja.setText(prueba1.getString(
//                                    "id")+ " %");
                        } catch
                        (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void
            onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {
                Map<String, String>
                        params = new HashMap<String, String>();

                params.put("Authorization", "JWT " +
                        "12345");

                System.out.println("12345");
                return params;
            }
        };;
        mQueue.add(request_SearchID);



    }
}