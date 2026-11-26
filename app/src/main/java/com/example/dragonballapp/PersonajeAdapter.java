package com.example.dragonballapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import android.content.Intent;
public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.ViewHolder> {

    Context context;
    ArrayList<Personaje> lista;

    public PersonajeAdapter(Context context, ArrayList<Personaje> lista) {
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_personaje, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Personaje personaje = lista.get(position);
        holder.txt_nombre.setText(personaje.getNombre());
        holder.txt_especie.setText("Raza: " + personaje.getEspecie());
        holder.txt_ocupacion.setText("Ki: " + personaje.getOcupacion());
        Glide.with(context).load(personaje.getImagen()).into(holder.img_personaje);
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetalleActivity.class);
                i.putExtra("nombre", personaje.getNombre());
                i.putExtra("imagen", personaje.getImagen());
                i.putExtra("raza", personaje.getEspecie());
                i.putExtra("ki", personaje.getOcupacion());
                i.putExtra("descripcion", personaje.getDescripcion());
                i.putExtra("maxKi", personaje.getMaxKi());
                i.putExtra("afiliacion", personaje.getAfiliacion());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_personaje;
        TextView txt_nombre, txt_especie, txt_ocupacion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_personaje = itemView.findViewById(R.id.img_personaje);
            txt_nombre = itemView.findViewById(R.id.txt_nombre);
            txt_especie = itemView.findViewById(R.id.txt_especie);
            txt_ocupacion = itemView.findViewById(R.id.txt_ocupacion);
        }
    }
}