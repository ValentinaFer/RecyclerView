package com.softulp.recyclerview;

import android.os.Bundle;

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

    private ActivityMainBinding binding;

    private MainActivityViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        vm.getListaPelis().observe(this, new Observer<List<Pelicula>>() {
            @Override
            public void onChanged(List<Pelicula> peliculas) {
                AdapterRecyclerView ia=new AdapterRecyclerView(peliculas,MainActivity.this,getLayoutInflater());
                GridLayoutManager glm=new GridLayoutManager(MainActivity.this,2,GridLayoutManager.VERTICAL,false);
                RecyclerView rc=binding.rvListaPelis;
                rc.setLayoutManager(glm);
                rc.setAdapter(ia);
            }
        });
        vm.crearLista(); //
    }



}