package com.softulp.recyclerview.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softulp.recyclerview.R;
import com.softulp.recyclerview.modelo.Pelicula;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.viewHolderInterno>{

    private List<Pelicula> listaPelis;
    private Context context;
    private LayoutInflater li;

    public AdapterRecyclerView(List<Pelicula> listaPelis, Context context, LayoutInflater li) {
        this.listaPelis = listaPelis;
        this.context = context;
        this.li = li;
    }

    public class viewHolderInterno extends RecyclerView.ViewHolder{

        TextView titulo, resenia;
        ImageView img;

        public viewHolderInterno(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tvTitulo); //
            resenia = itemView.findViewById(R.id.tvResenia); //
            img = itemView.findViewById(R.id.ivFoto); //
        }
    }

    @NonNull
    @Override
    public AdapterRecyclerView.viewHolderInterno onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=li.inflate(R.layout.item,parent,false);
        return new viewHolderInterno(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView.viewHolderInterno holder, int position) {

        Pelicula pelicula = listaPelis.get(position);
        holder.titulo.setText(pelicula.getTitulo());
        holder.resenia.setText(pelicula.getResenia());
        holder.img.setImageResource(pelicula.getImg());

    }

    @Override
    public int getItemCount() {
        return listaPelis.size();
    }
}
