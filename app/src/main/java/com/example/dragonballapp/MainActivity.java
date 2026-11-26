package com.example.dragonballapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String url_api = "https://dragonball-api.com/api/characters?limit=50";
    RecyclerView recycler_personajes;
    PersonajeAdapter adapter;
    ArrayList<Personaje> lista;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_personajes = findViewById(R.id.recycler_personajes);
        recycler_personajes.setLayoutManager(new LinearLayoutManager(this));

        lista = new ArrayList<>();
        adapter = new PersonajeAdapter(MainActivity.this, lista);
        recycler_personajes.setAdapter(adapter);

        queue = Volley.newRequestQueue(this);

        cargarPersonajes();
    }

    private void cargarPersonajes() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url_api, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray items = response.getJSONArray("items");
                            for (int i = 0; i < items.length(); i++) {
                                JSONObject objeto = items.getJSONObject(i);

                                String nombre = objeto.optString("name");
                                String imagen = objeto.optString("image");
                                String raza = objeto.optString("race", "Desconocida");
                                String ki = objeto.optString("ki", "Desconocido");
                                String descripcion = objeto.optString("description", "Sin descripción");
                                String maxKi = objeto.optString("maxKi", "Desconocido");
                                String afiliacion = objeto.optString("affiliation", "Desconocida");

                                lista.add(new Personaje(nombre, imagen, raza, ki, descripcion, maxKi, afiliacion));
                            }
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this, "Error al leer los datos", Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "No se pudo conectar con la API", Toast.LENGTH_LONG).show();
            }
        });

        queue.add(request);
    }
}