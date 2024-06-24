package com.listas_encadeadas.exercicios_encadeadas.invertendoLista;

public class No<T> {
    private T elemento;
    private No<T> proximo;

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public No(T elemento){
        this.elemento = elemento;
    }

    public No(T elemento, No<T> proximo){
        this.elemento = elemento;
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("No{elemento = ").append(elemento);
        builder.append(", proximo = {").append(proximo);
        builder.append("}");

        return builder.toString();
    }
}
