package com.listas_encadeadas.exercicios_encadeadas.invertendoLista;

import com.listas_encadeadas.exercicios_encadeadas.invertendoLista.No;
public class ListaEncadeada<T>{
    private No<T> inicio;

    private int tamanho;

    public int getTamanho() {
        return tamanho;
    }

    public void adicionar(T elemento){
        No<T> no = new No<>(elemento);
        inicio = no;


    }

    @Override
    public String toString() {
        return "ListaEncadeada{" +
                "inicio=" + inicio +
                '}';
    }
}
