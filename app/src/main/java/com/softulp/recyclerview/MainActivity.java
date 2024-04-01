package com.softulp.recyclerview;

import android.os.Bundle;
import android.widget.Adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softulp.recyclerview.databinding.ActivityMainBinding;
import com.softulp.recyclerview.modelo.Pelicula;
import com.softulp.recyclerview.ui.AdapterRecyclerView;
import com.softulp.recyclerview.ui.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mv;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mv.getListaPelis().observe(this, new Observer<List<Pelicula>>() {
            @Override
            public void onChanged(List<Pelicula> peliculas) {
                AdapterRecyclerView adapter = new AdapterRecyclerView(peliculas,MainActivity.this,getLayoutInflater());
                GridLayoutManager gl = new GridLayoutManager(MainActivity.this, 2, GridLayoutManager.VERTICAL,false);
                RecyclerView rv = binding.rvListaPelis;
                rv.setLayoutManager(gl);
                rv.setAdapter(adapter);
            }
        });

        mv.crearLista();
    }



}