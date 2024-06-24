package com.listas_encadeadas.encadeadas_v01;

/*
* RODRIGO PEREIRA FARIA
* 07/06/24
* CRIANDO UMA LISTA ENCADEADA
* */

/*Listas encadeadas em Java
*
* São listas cujos elementos. de mesmo tipo, estão ligados entre si por meio de ponteiros, em realidade seus valores estão espalhados na memória, o que justifica ser necessário um apontador para cada elemento
*
* É diferente das listas implementadas por arranjo pois não há a delimitação anterior de quantidade de elementos e alocação de memória.
*
* Os elementos dessa lista são chamados de nós ou células
*
* Em Java não possuímos ponteiros, por isso trabalhamos com a referência dos elementos na memória.
*
* O operador de atribuição "=" no Java, nesse contexto, não possui o significado de armazenar valores, mas sim de referenciar valores ao endereço na memória
* Um exemplo disso é quando fazemos referẽncia inicialmente ao "inicio" e "ultimo" ao mesmo elemento "celula"
* */
public class ListaEncadeada<T> {

    private Celula<T> inicio;
    //Por padrão já é inicializado como zero
    private Celula<T> ultimo;
    private int tamanho;
    private static final int NAO_ENCONTRADO = -1;
    private final String LISTA_VAZIA = "Lista está vazia";
    private final String POS_NAO_EXISTE = "Posição Inválida";
    public void adicionar(T elemento){
        /*Adicionando o primeiro elemento, o próximo será nulo pois foi designado o construtor com somente um parâmetro*/
        Celula<T> celula = new Celula<>(elemento);
        if(this.tamanho == 0) {
            /*Somente com inicio não realiza adição de elementos, mas somente define que o primeiro elemento será determinado elemento*/
            this.inicio = celula;
        } else{
            //Define o próximo elemento de último ou início
            this.ultimo.setProximo(celula);
        }
        //No início, "inicio" e "ultimo" apontam para o mesmo elemento
        //Ultimo assume o valor do próximo elemento se tamanho > 0
        this.ultimo = celula;
        this.tamanho++;
    }

    /*Adicionando no Início
    Esta função realiza a inserção dos dados no início da lista
    * */
    public void adicionarInicio(T elemento){
        /*Se a lista estiver vazia, executa o algoritmo de definir o início e o último elemento da lista*/

        if(this.tamanho == 0){
            Celula<T> novaCelula = new Celula<>(elemento);
            this.inicio = novaCelula;
            this.ultimo = novaCelula;


        } else{ /*Cria uma célula com o elemento e atribui seu próximo elemento ao início*/
            Celula<T> novaCelula = new Celula<>(elemento, inicio);
            //Essa nova célula passa a ser o novo início, o inicio anterior se tornou seu próximo
            this.inicio = novaCelula;
        }
        //Aumenta o tamanho da lista
        this.tamanho++;
    }

    /*Adicionando no meio da lista
    * Para adicionar no meio da lista é necessário colocar a posição e o elemento a ser buscado
    * Para adicionar no meio, é necessário percorrer até a posiçao anterior àquela em questão
    * Finalmente, atribua essa variável à função que busca célula
    * Variável auxiliar próximo
    * */
private void adicionarMeioLista(int posicao, T elemento){
    //No da posição anterior àquela a ser inserida
    Celula<T> noAtual = buscarCelula(posicao - 1);
    //Captura o proximo elemento para não perder a referência
    Celula<T> noProximo = noAtual.getProximo();
    //Criando novo nó para poder fazer referência
    Celula<T> novoNo = new Celula<>(elemento, noProximo);
    //Define que o nó da posição anterior possuirá como próximo nó o novo Nó criado
    noAtual.setProximo(novoNo);
    //Aumenta o tamanho da lista
    this.tamanho++;
}

    /*
    * Adicionando elementos em posição N da lista
    * */
    public void adicionar(int posicao, T elemento){
        //Verifica se o valor da posição digitado é valido
        if(posicao < 0 || posicao > tamanho)
            //Gera uma exceção se o valor não for válido
            throw new IllegalArgumentException("Posição Inválida");

        //Se a posição digitada for igual a zero, executa a operação de adicionar elementos no início
        if(posicao == 0){
            this.adicionarInicio(elemento);
        //Se a posição for igual ao tamanho executa o método de adicionar no final
        } else if(posicao == this.tamanho){
            this.adicionar(elemento);
        //Se a posição não for de acordo com os casos acima
        } else {
            adicionarMeioLista(posicao, elemento);
        }
    }

    private boolean verificaPosicaoNaoExiste(int posicao){
        return !(posicao >= 0 && posicao <= tamanho);
    }
    private boolean verificaListaVazia(){
        return(this.tamanho == 0);
    }

    /*Removendo do ínicio*/
    public T removerInicio(){
        /*Se a lista estiver vazia gera uma exceção*/
        if(verificaListaVazia()){
            throw new RuntimeException(LISTA_VAZIA);
        }

        /*Recebe o proximo elemento de auxiliar*/
        Celula<T> proximo = inicio.getProximo();

        T removido = inicio.getElemento();

        /*Atribui nulo para o elemento atual e o próximo nó*/
        inicio.setElemento(null);

        /*Inicio recebe o próximo, removendo o nó antigo*/
        inicio = proximo;
        //Reduz 1 do tamanho
        this.tamanho--;

        //Se ao final disso a lista ficar vazia, atribui ultimo para ser nulo
        if(verificaListaVazia()) {
            this.ultimo = null;
        }
        return removido;
    }

    /*Método Remove no Final
    * Esse é um método que sempre remove o último elemento da lista*/
    public T removerFinal(){
        /*Se a lista está vazia, exibe uma exceção*/
        if(verificaListaVazia()){
            throw new RuntimeException(LISTA_VAZIA);
        }

        Celula<T> it = inicio;

        /*Se o inicio for igual ao ultimo, ou seja, a lista possui tamanho igual a 1*/
        if(inicio.equals(this.ultimo)){
            /*Executa a função de remover do início*/
            return removerInicio();
        }

        /*Algoritmo de remoção de nó em qualquer posição:*/
        //Primeiro capture o penúltimo nó para poder atribuir ao último
        Celula<T> penultimoNo = buscarCelula(this.tamanho - 2);

        //Capturando valor do elemento a ser removido
        T removido = penultimoNo.getProximo().getElemento();

        //Apaga a referência do último elemento na lista
        penultimoNo.setProximo(null);

        //Último é referenciado ao penúltimo nó
        this.ultimo = penultimoNo;
        /*

        * while(it.getProximo() != null){
            if(it.getProximo().equals(this.ultimo)){
                this.ultimo = it;
                break;
            }
            it = it.getProximo();
        }
        * */

        //Reduz 1 do tamanho
        this.tamanho--;

        //Retorna o elemento removido
        return removido;
    }

    /*Método de remover em qualquer posição*/
    public T removerPosicao(int posicao){
        /*Se a posição digitada não existe: */
        if(verificaPosicaoNaoExiste(posicao)){
            throw new IllegalArgumentException(POS_NAO_EXISTE);
        }

        /*Se a posição é zero, executa o método de remover do início*/
        if(posicao == 0)
            return removerInicio();

        /*Se a posição for o último elemento, ou seja, o tamanho - 1, executa o método de remover no final*/
        if(posicao == tamanho - 1) {
            return removerFinal();
        }

        /*Se não for nada disso:*/
        //Captura o nó anterior ao da remoção
        Celula<T> noAnteriorRemocao = buscarCelula(posicao - 1);
        //Captura o próximo nó da célula a ser removida
        Celula<T> noSubstituicao = noAnteriorRemocao.getProximo().getProximo();

        //Caputra o elemento a ser removido para retornar na função
        T removido = noAnteriorRemocao.getProximo().getElemento();

        //Removendo a referência ao próximo nó da remoção, está armazenado na váriavel nóSubstituição
        noAnteriorRemocao.getProximo().setProximo(null);

        //Removendo próximo nó (nó da remoção)
        noAnteriorRemocao.setProximo(null);

        //Substituindo o nó da remoção pelos restantes
        noAnteriorRemocao.setProximo(noSubstituicao);

        //Reduz 1 do tamanho
        this.tamanho--;

        //Retorna o valor que foi removido
        return removido;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    /*Método toString
    *
    * É um método muito utilizado para visualização de elementos no Java.
    *
    * Faz parte da classe Object, a superclasse em Java que contém todas as outras classes
    *
    * A classe original exibe em String o objeto com seu código hex
    *
    * Com o polimorfismo, podemos substituir seu comportamento para atender a outros casos,
    * como a exibição de um vetor ou uma lista
    *  */
    @Override
    public String toString() {
        if(verificaListaVazia()){
            return "[ ]";
        }

        StringBuilder builder = new StringBuilder("[");

        Celula<T> it = this.inicio;
        /*Iterador com For
        it sempre começa com inicio
        Utilizando um i para complementar, enquanto o i for menor que o tamanho da lista, vai passando em cada um dos elementos com
        it.getElemento(), retorna o valor do elemento atual
        it.getProximo(), retorna o valor do próximo elemento
        * */
        for(int i = 0; i < this.tamanho; i++){
            if(i == this.tamanho - 1){
                builder.append(it.getElemento()).append("]");
            } else{
                builder.append(it.getElemento()).append(",");
            }
            it = it.getProximo();
        }

        /*Método com while
        builder.append(it.getElemento()).append(",");
        while(it.getProximo() != null){
            it = it.getProximo();
            builder.append(it.getElemento()).append(",");
        }

        Builder.delete = apaga um conjunto de caracteres especificado entre um intervalo
        builder.deleteCharAt = apaga um caracter na posição N

        builder.deleteCharAt(builder.length() - 1).append("]");*/
        return builder.toString();
    }

    public void limparElementos(){
        Celula<T> it;
        Celula<T> proximo;
        /*Outra forma de executar um loop for
        Declara o inicio com it = inicio, enquanto que o it for diferente de nulo executa as instruções
        *
        * */
        /*for(it = inicio; it != null;){*/
            /*Proximo é uma variável auxiliar para armazenar o proximo elemento sem perder a referências de seus sucessores*/
            /*proximo = it.getProximo();
            it.setElemento(null);
            it.setProximo(null);
            it = proximo;
        } */
        it = inicio;
        for(int i = 0; i < this.tamanho; i++){
            proximo = it.getProximo();
            it.setElemento(null);
            it.setProximo(null);
            it = proximo;
        }

        /* Não faz com que o objeto celula fique nulo:
        * while(it.getProximo() != null){
            it.setElemento(null);
            it = it.getProximo();
        }*/
        this.tamanho = 0;
    }

    /*public void inserirNumerosAleatorios(){
        Random aleatorizador = new Random (2024);
        for(int i = 0; i < 10; i++) {
            this.adicionar(aleatorizador.nextInt(10));
        }
    }*/

    /*Buscando a célula do elemento na posição x*/
    private Celula<T> buscarCelula(int posicao){

        /*Primeiro, verifica se posição não está de acordo com o tamanho da lista, isto é,
        * se posição é menor que 0 ou maior que tamanho da lista
        * */
        if(verificaPosicaoNaoExiste(posicao)){
            //Gerando erro: throw new Exception("Passou do limite");
            //Gera um erro no algoritmo
            throw new IllegalArgumentException("Erro de posição passar do limite");
        }

        /*Se tudo estiver nos conformes, executa um loop for iterando até a posição em questão*/
        Celula<T> it = inicio;
        int pos = 0;
        while(it.getProximo() != null){
            if(pos == posicao){
                /*Retorna toda a célula na função*/
                break;
            }
            it = it.getProximo();
            pos++;

        }
        return it;
    }
    public T buscarElementoPorPosicao(int posicao){
        /*Executando a função acima, retorna a célula do elemento. Esta função está acessando o elemento da célula*/
        return this.buscarCelula(posicao).getElemento();
    }

    /*Buscando Elementos presentes Na Lista
    Este algoritmo realiza a verificação de um elemento na lista, retornando a posição do elemento
    * */
    public int buscarElementoNaLista(T elemento){
        Celula<T> it;
        int posicao = 0;
        /*Criando for com it começando em início; Verificando se o próximo é nulo e incrementando a posição de 1 em 1*/
        for(it = inicio; it.getProximo() != null; posicao++){
            /*Se o elemento do nó atual é igual ao elemento do parâmetro, retorna a posição onde ele se encontra*/
            if(it.getElemento().equals(elemento)){
                return posicao;
            }
            /*Passa para o próximo elemento*/
            it = it.getProximo();
        }
        /*Se não for encontrado, retorna -1*/
        return NAO_ENCONTRADO;
    }

    public T substituirElemento(int posicao, T elemento){
        if(verificaPosicaoNaoExiste(posicao)){
            throw new RuntimeException(POS_NAO_EXISTE);
        }

        if(verificaListaVazia()){
            throw new RuntimeException(LISTA_VAZIA);
        }

        Celula<T> it;
        if(posicao == 0){
            it = inicio;
        } else if(posicao == tamanho - 1){
            it = ultimo;
        } else{
            it = buscarCelula(posicao);
        }
        T substituido = it.getElemento();
        it.setElemento(elemento);
        return substituido;
    }

    private boolean verificaPosicaoInicio(int posicao){
        return (posicao == 0);
    }

    private boolean verificaPosicaoFinal(int posicao){
        return (posicao == tamanho - 1);
    }

    public void trocarElementos(int posicao01, int posicao02){
        if(verificaPosicaoNaoExiste(posicao01) || verificaPosicaoNaoExiste(posicao02)){
            throw new RuntimeException(POS_NAO_EXISTE);
        }

        if(tamanho < 2){
            throw new IllegalArgumentException("Tamanho insuficiente para executar o método");
        }

        Celula<T> celula01;
        Celula<T> celula02;

        if(verificaPosicaoInicio(posicao01)){
            celula01 = inicio;
        } else if(verificaPosicaoFinal(posicao01)){
            celula01 = ultimo;
        } else{
            celula01 = buscarCelula(posicao01);
        }

        if(verificaPosicaoInicio(posicao02)){
            celula02 = inicio;
        } else if(verificaPosicaoFinal(posicao02)){
            celula02 = ultimo;
        } else{
            celula02 = buscarCelula(posicao02);
        }

        T elementoAuxiliar = celula01.getElemento();
        celula01.setElemento(celula02.getElemento());
        celula02.setElemento(elementoAuxiliar);

    }
}

