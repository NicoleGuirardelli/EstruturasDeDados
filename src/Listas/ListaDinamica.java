package Listas;
public class ListaDinamica  implements ListaOperacoes{
    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista Dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String conteudo) {
        if(!this.existeInicio()) {
            this.inicio.setConteudo(conteudo);
        } else {
            No novoNo = new No(conteudo);
            No aux = this.inicio;
            while(aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }

    private boolean existeInicio() {
        return this.inicio.getConteudo() != null;
    }

    public void exibirElementos() {
        if(existeInicio()) {
            No aux = this.inicio;
            while(aux.getProx() != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
            System.out.println(aux.getConteudo());
        } else {
            System.out.println("Não existem elementos na Lista Dinâmica.");
        }
    }

    public void removerElemento(String elemento) {
        if(existeInicio()) {
            if(buscarElemento(elemento)) {

                //removendo primeiro
                if(this.inicio.getConteudo().equals(elemento)) {
                    this.inicio = this.inicio.getProx();
                } else if(this.inicio.getProx() != null) {
                    No aux = this.inicio;
                    do {
                        // removendo intermediario
                        if(aux != null && aux.getProx().getConteudo().equals(elemento)) {
                            aux.setProx(aux.getProx().getProx());
                            return;
                        }
                        aux = aux.getProx();

                    } while (aux != null);
                } else {
                    this.inicio = null;
                }
            }

        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public boolean buscarElemento(String elemento) {
        No aux = this.inicio;

        do {
            if(aux.getConteudo().equals(elemento)) {
                System.out.println("Elemento " + elemento + " encontrado.");
                return true;
            }
            aux = aux.getProx();
        } while(aux != null);
        System.out.println("Elemento " + elemento + " não encontrado!");
        return false;
    }

    @Override
    public int removerTodas(String elemento) {
        int qtdRemocao = 0;

        while (existeInicio() && this.inicio.getConteudo().equals(elemento)){
            if (this.inicio.getProx() == null){
                System.out.println("Não existem mais elementos a serem removidos nessa lista"); }
            this.inicio = this.inicio.getProx();
            qtdRemocao++;
        }
        No aux = this.inicio;
        while (aux != null && aux.getProx() != null){
            if (aux.getProx().getConteudo().equals(elemento)){
                aux.setProx(aux.getProx().getProx());
                qtdRemocao++;
            } else { aux = aux.getProx(); }
        }
        return qtdRemocao;
    }



    @Override
    public int contar() {
        No aux = this.inicio;
        int contar = 0;

        while (aux != null) {
            contar++;
            aux = aux.getProx();
        }

        return contar;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int elementoAdicionado=0;

          for(String  elemento: elementos){
              adicionarElemento(elemento);
              elementoAdicionado++;

        }
        return elementoAdicionado;
    }

    @Override
    public String obter(int indice) {

        if (!existeInicio()){
            return "A lista está vazia";
        } else if (indice < 0){
            return null;
        }

        No aux = this.inicio;
        int contarIndice = 0;

        while (aux != null){
            if (contarIndice == indice){
                return "Elemento: " + aux.getConteudo() + "está no indice: " + indice;
            }
            aux = aux.getProx();
            contarIndice++;
        }

        return null;
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        No novoNo  = new No(elemento);

        if (indice == 0){
            novoNo.setProx(this.inicio);
            this.inicio = novoNo;
            return true;
        }

        No aux = this.inicio;
        int contarIndice = 0;

        while (aux != null && contarIndice < indice -1){ // pq quer segurar a mao do indice-1 para ficar na posicao de indice
            aux = aux.getProx();
            contarIndice++;
        }

        if (aux == null){
            return false;
        }

        novoNo.setProx(aux.getProx());
        aux.setProx(novoNo);

        return true;
    }

    @Override
    public String removerPorIndice(int indice) {
        int posicao=0;
        No aux = this.inicio;
        No anterior = null;
        while (aux!= null) {
            if(posicao==indice) {
                if (anterior == null) {//verifico se ele é o primero elemento
                    this.inicio = aux.getProx();

                } else {//aqui serve para os elementos do meio
                    anterior.setProx(aux.getProx());

                }
                return aux.getConteudo();
            }
            posicao++;
            anterior = aux;
            aux=aux.getProx();

        }
        return null;
    }

    @Override
    public void limpar() {
        this.inicio = new No(null);

    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        No aux = this.inicio;
        int posicao = 0;
        int indice = -1;

        while (aux != null){
            if (aux.getConteudo().equals(elemento)){
                indice = posicao;
            }

            aux = aux.getProx();
            posicao++;
        }

        return indice;
    }


    @Override
    public int contarOcorrencias(String elemento) {
        int ocorrencias=0;
        No aux = this.inicio;
        while (aux != null) {
            if (aux.getConteudo().equals(elemento)) {
                ocorrencias++;
            }
            aux = aux.getProx();
        }
        return ocorrencias;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int substituicoes=0;
        if(existeInicio()) {
           No aux = this.inicio;
           while (aux != null) {
               if (aux.getConteudo().equals(antigo)) {
                   aux.setConteudo(novo);
                   substituicoes++;
               }
               aux=aux.getProx();
           }

        }
        return substituicoes;
    }
}