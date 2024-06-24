package com.listas_encadeadas.exercicios_encadeadas.invertendoLista;

public class InvertendoLista {

    public static void criandoLista(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.adicionar(1);

        System.out.println(lista);
    }
    public static void main(String[] args) {
        criandoLista();
    }
}
