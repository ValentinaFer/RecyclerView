package com.softulp.recyclerview.ui;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softulp.recyclerview.modelo.Pelicula;

public class SegundaActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Pelicula> mutable;
    public SegundaActivityViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<Pelicula> getmutable(){
        if(mutable == null){
            mutable = new MutableLiveData<>();
        }
        return mutable;
    }

    public void recuperarPeli(Intent intent){
        Pelicula pelicula = (Pelicula)intent.getSerializableExtra("pelicula");
        if(pelicula != null){
            mutable.setValue(pelicula);
        }
    }

}
