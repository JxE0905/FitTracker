package com.example.fittracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EntrenamientoAdapter extends RecyclerView.Adapter<EntrenamientoAdapter.ViewHolder> {

    private ArrayList<Entrenamiento> listaEntrenamientos;

    public EntrenamientoAdapter(ArrayList<Entrenamiento> listaEntrenamientos) {
        this.listaEntrenamientos = listaEntrenamientos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_entrenamiento, parent, false);

        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Entrenamiento entrenamiento = listaEntrenamientos.get(position);

        holder.txtTipo.setText(entrenamiento.getTipo());
        holder.txtIntensidad.setText(
                "Intensidad: " + entrenamiento.getIntensidad()
        );

        holder.txtAspectos.setText(
                "Completado: " + entrenamiento.getAspectos()
        );

        holder.txtProgreso.setText(
                "Progreso: " + entrenamiento.getProgreso() + "%"
        );

        holder.txtEsfuerzo.setText(
                "Esfuerzo: " + entrenamiento.getEsfuerzo() + " estrellas"
        );
    }

    @Override
    public int getItemCount() {
        return listaEntrenamientos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTipo;
        TextView txtIntensidad;
        TextView txtAspectos;
        TextView txtProgreso;
        TextView txtEsfuerzo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTipo = itemView.findViewById(R.id.txtTipo);
            txtIntensidad = itemView.findViewById(R.id.txtIntensidad);
            txtAspectos = itemView.findViewById(R.id.txtAspectos);
            txtProgreso = itemView.findViewById(R.id.txtProgreso);
            txtEsfuerzo = itemView.findViewById(R.id.txtEsfuerzo);
        }
    }
}