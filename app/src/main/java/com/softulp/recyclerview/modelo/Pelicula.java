package com.softulp.recyclerview.modelo;

import java.io.Serializable;

public class Pelicula implements Serializable {

    private String titulo;
    private int img;
    private String resenia;
    private String actores;
    private String directores;

    public Pelicula(String titulo, int img, String resenia, String actores, String directores) {
        this.titulo = titulo;
        this.img = img;
        this.resenia = resenia;
        this.actores = actores;
        this.directores = directores;
    }

    public Pelicula(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getResenia() {
        return resenia;
    }

    public void setResenia(String resenia) {
        this.resenia = resenia;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getDirectores() {
        return directores;
    }

    public void setDirectores(String directores) {
        this.directores = directores;
    }
}
