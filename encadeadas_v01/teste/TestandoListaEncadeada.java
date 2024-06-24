package com.listas_encadeadas.encadeadas_v01.teste;

import com.listas_encadeadas.encadeadas_v01.ListaEncadeada;

public class TestandoListaEncadeada {
    public static void iniciandoComListas(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.adicionar(1);

        /*Executando método toString da lista, que por sua vez compôe-se de nós que possuem métodos toString*/
        System.out.println(lista);
        System.out.println("Tamanho = " + lista.getTamanho());

        lista.adicionar(2);
        lista.adicionar(3);
        lista.adicionar(4);

        System.out.println(lista);

        /*
        * lista.limparElementos();
        System.out.println(lista);
        * */

        System.out.println(lista.buscarElementoNaLista(3) != -1 ? "O número 3 foi encontrado na posição: " + lista.buscarElementoNaLista(3) : "O número 3 não foi encontrado");
        System.out.println(lista.buscarElementoNaLista(5) != -1 ? "O número 5 foi encontrado na posição: " + lista.buscarElementoNaLista(5) : "O número 5 não foi encontrado");

        System.out.println(lista.buscarElementoPorPosicao(3));
        //System.out.println(lista.buscarPosicao(10)); Erro de Null Pointer Exception
        //O usuário não deve poder acessar as células: System.out.println(lista.buscarCelula(3))
}
    public static void adicionandoElementosLista(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(4);

        System.out.println(lista);

        lista.adicionarInicio(0);
        lista.adicionar(0, 9);

        System.out.println(lista);

        //lista.adicionar(-1, 0);
        //lista.adicionar(9, 10);

        lista.adicionar(5, 10);
        System.out.println(lista);

        lista.adicionar(3, 99);

        System.out.println(lista);

        lista.limparElementos();
        System.out.println(lista);
        //lista.adicionar(2, 10);
        //System.out.println(lista);
    }

    public static void removendoElementosInicioFinal(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.adicionarInicio(12);
        System.out.println(lista);

        lista.adicionar(3);
        System.out.println(lista.getTamanho());

        lista.adicionar(1, 40);
        System.out.println(lista);

        lista.removerInicio();
        System.out.println(lista);

        lista.removerInicio();
        System.out.println(lista);

        lista.removerFinal(); // [ ]
        //lista.removerFinal();
        System.out.println(lista);

        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(4); // [1, 2, 4]
        System.out.println(lista);

        System.out.println("Elemento removido: " + lista.removerFinal());
        System.out.println(lista);

        System.out.println("Elemento removido: " + lista.removerFinal());
        System.out.println(lista);

        System.out.println("Elemento removido: " + lista.removerFinal());
        System.out.println(lista);
    }

    public static void removendoQualquerPosicao(){
        ListaEncadeada<String> lista = new ListaEncadeada<>();
        lista.adicionar("Cachorro");
        lista.adicionar("Gato");
        lista.adicionar("Elefante");

        lista.removerPosicao(1);
        System.out.println(lista);
        lista.removerPosicao(0);
        System.out.println(lista);

        lista.adicionar("Tartaruga");
        lista.adicionar("Cágado");
        lista.adicionar("Lagarto");
        System.out.println(lista);

        lista.removerPosicao(2);
        System.out.println(lista);

    }

    public static void substituindoElementos(){
        ListaEncadeada<Double> listaDouble = new ListaEncadeada<>();

        listaDouble.adicionar(7.5);
        listaDouble.adicionar(8.5);
        listaDouble.adicionar(9.0);
        listaDouble.adicionarInicio(6.5);

        System.out.println("Substituído: " + listaDouble.substituirElemento(0, 10.0));
        System.out.println(listaDouble);

        System.out.println("Substituído: " + listaDouble.substituirElemento(2, 6.2));
        System.out.println(listaDouble);
    }

    public static void trocandoElementos(){
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adicionarInicio(2);
        lista.adicionar(3);
        lista.adicionar(0, 10);
        lista.adicionar(5);

        System.out.println(lista);

        lista.trocarElementos(0, 2);
        System.out.println(lista);
    }

    public static void main(String[] args) {
        //iniciandoComListas();
        //adicionandoElementosLista();
        //removendoElementosInicioFinal();
        //removendoQualquerPosicao();
        //substituindoElementos();
        trocandoElementos();
    }


}
