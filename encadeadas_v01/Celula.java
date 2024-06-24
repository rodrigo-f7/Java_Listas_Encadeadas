package com.listas_encadeadas.encadeadas_v01;

/*Listas Encadeadas - Célula ou Nó
* Os elementos de uma lista encadeada são chamados de nós ou células, por estarem espalhados na memória, necessitam de ponteiros para poder realizar a referência do próximo elemento;
* */
public class Celula <T>{

    private T elemento;
    private Celula<T> proximo;

    /*
    COnstrutores com genéricos não deve ser especificado o tipo do objeto
     */
    public Celula(T elemento){
        this.elemento = elemento;
        this.proximo = null;
    }

    /*
    Estendendo método para atender ao caso de haver a definição de dois parâmetros para o construtor
    */
    public Celula(T elemento, Celula<T> proximo){
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Celula<T> getProximo(){
        return proximo;
    }
    public void setProximo(Celula <T> proximo){
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "Celula{" +
                "elemento=" + elemento +
                ", proximo=" + proximo +
                '}';
    }
}
