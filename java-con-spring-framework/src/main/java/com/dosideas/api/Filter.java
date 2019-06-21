package com.dosideas.api;

import java.io.Serializable;

public class Filter implements Serializable {


    private String palabra;

    public Filter() {
    }

    public Filter(String palabra) {
        this.palabra = palabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}
