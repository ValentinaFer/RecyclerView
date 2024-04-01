package com.softulp.recyclerview.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softulp.recyclerview.R;
import com.softulp.recyclerview.modelo.Pelicula;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolderMio>{

    private List<Pelicula> listaPeliculas;
    private Context contexto;

    private LayoutInflater li;

    public AdapterRecyclerView(List<Pelicula> listaPeliculas, Context contexto, LayoutInflater li) {
        this.listaPeliculas = listaPeliculas;
        this.contexto = contexto;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolderMio onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item, parent, false);
        return new ViewHolderMio(view);
}

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMio holder, int position) {
        Pelicula pelicula = listaPeliculas.get(position);
        holder.titulo.setText(pelicula.getTitulo());
        holder.resumen.setText(pelicula.getResenia());
        holder.imagen.setImageResource(pelicula.getImg());

        holder.boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contexto, SegundaActivity.class);
                intent.putExtra("pelicula", pelicula);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                contexto.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listaPeliculas.size();
    }

    public class ViewHolderMio extends RecyclerView.ViewHolder{
        TextView titulo, resumen;
        ImageView imagen;
        Button boton;

        public ViewHolderMio(@NonNull View itemView) {
            super(itemView);
            titulo=itemView.findViewById(R.id.tvTitulo);
            resumen = itemView.findViewById(R.id.tvResumen);
            imagen = itemView.findViewById(R.id.ivImagen);
            boton = itemView.findViewById(R.id.btnDetalle);

        }
    }
}
