package com.softulp.recyclerview.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softulp.recyclerview.R;
import com.softulp.recyclerview.modelo.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<List<Pelicula>> listaPelis;

    public LiveData<List<Pelicula>> getListaPelis() {
        if (listaPelis == null) {
            listaPelis = new MutableLiveData<>();
        }
        return listaPelis;
    }

    public void setListaPelis(MutableLiveData<List<Pelicula>> listaPelis) { //no es necesario porque se crea el mutable aqui y se destruye aqui tambien
        this.listaPelis = listaPelis;
    }

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public void crearLista(){

        ArrayList<Pelicula> pelis = new ArrayList<>();
        pelis.add(new Pelicula("Alien", R.drawable.alien, "Hay espacio, hay aliens. Esta copada. :)", "Sigourney Weaver", "Ridley Scott"));
        pelis.add(new Pelicula("Barbie", R.drawable.barbie, "Hay muñeca y es todo rosita. Esta copada. :)", "Margot Robin", "Greta Gerwig"));
        pelis.add(new Pelicula("Mas rapidos y mas furiosos", R.drawable.rapido, "Hay autos y es estan todos furiosos. Esta copada. :)", "Vind Diesel, Paul Walker", "John Singleton"));
        pelis.add(new Pelicula("La monja", R.drawable.monja, "No me gusto me dio miedito :( sali llorando, sigo traumado", "Luciana Zalasar, Guido Kasca", "John Singleton"));
        listaPelis.setValue(pelis);
    }
}
