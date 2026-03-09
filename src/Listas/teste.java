package Listas;

public class teste implements ListaOperacoes {

    String[] lista;

    public teste(int tamanho) {
        this.lista = new String[tamanho];
    }

    public void exibirElementos() {
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }

    public void adicionarElemento(String elemento) {
        if (!estaCheia()) {
            this.lista[encontrarPosicaoVazia()] = elemento;
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        }
    }


    private boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("A lista está cheia!");
        return true;
    }

    private boolean estaVazio() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        System.out.println("A lista está vazia!");
        return true;
    }

    private int encontrarPosicaoVazia() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return i;
            }
        }
        return i;
    }

    public void removerElemento(String elemento) {
        if (!estaVazio()) {
            if (this.buscarElemento(elemento) >= 0) {
              //  this.lista[this.buscarElemento(elemento)] = null;
                reenfilerar(this.buscarElemento(elemento));
                System.out.println("Elemento " + elemento + " removido com sucesso!");
            }
        }
    }

    public int buscarElemento(String elemento){
        int i;
        if (!estaVazio()) {
            for (i = 0; i < this.lista.length; i++) {
                if (this.lista[i].equals(elemento)) {
                    return i;
                }
            }
        }
        System.out.println("Elemento não encontrado na lista.");
        return -1;
    }

    public void alterarElemento(String elementoASerAlterado, String alteracao) {
        if(buscarElemento(elementoASerAlterado) >= 0) {
            this.lista[buscarElemento(elementoASerAlterado)] = alteracao;
            System.out.println("Elemento " + elementoASerAlterado + " alterado com sucesso para " + alteracao);
        }
    }

    public void quantidadeElementos() {
        int cont = 0;
        if(!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null) {
                    cont++;
                }
            }
        }
        System.out.println("A lista possui " + cont + " elementos!");
    }
    @Override
    public int removerTodas(String elemento) {
        if (!estaVazio()) {
            int elementoRemovido=0;
            for( int i=0; i< lista.length;i++) {
                if ( lista[i]!=null &&lista[i].equals(elemento)) {
                    elementoRemovido++;
                    lista[i] = null;
                    System.out.println("Elemento " + elemento + " removido com sucesso");
                }
            }
            return  elementoRemovido;
        }
        return 0;
    }

    @Override
    public int contar() {
        int conta = 0;
        if(!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null) {
                    conta++;
                }
            }
        }
        return conta;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int espacoLivre= lista.length-contar();
        int indiceElemento =0;
        if(espacoLivre<elementos.length) {
            System.out.println("Existe "+ espacoLivre);
            for(int i=0; i< lista.length;i++) {
                if(lista[i]==null) {
                    lista[i]=elementos[indiceElemento];
                    indiceElemento++;
                }
            }
        }

        return indiceElemento;
    }

    @Override
    public String obter(int indice) {
        if(indice<lista.length) {
            return lista[indice];
        }
        return null;
        //lançar exceção
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if(!estaCheia()) {
            for (int i = contar(); i > indice; i--) {
                lista[i] = lista[i - 1];
            }

            lista[indice] = elemento;
            return true;
            //não funciona quando tem null no meio, ou seja quando um elemento é removido
        }
        return false;

    }


    @Override
    public String removerPorIndice(int indice) {
        if(indice<lista.length) {
            String removido = lista[indice];
            reenfilerar(indice);

            return "Elemento ["+removido+" ] removido com sucesso";
        }
        return null;
    }
    private void reenfilerar(int indice){
        for (int i = indice; i < lista.length-1; i++) {
            lista[i] = lista[i + 1];
        }
        lista[lista.length - 1] = null;//deixa o ultimo elemento null, pra não ocorrer a repetição do ultimo element
    }


    @Override
    public void limpar() {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = null;
        }
        System.out.println("Lista limpa com sucesso");
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        //se percorrer do final para o começo a primeira ocorrencia seria o ultimo caso exista mais de um
        for (int i= lista.length-1; i>=0; i--) {
            if(lista[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int ocorrencias=0;
        for(int i=0; i< lista.length;i++) {
            if(lista[i].equals(elemento)){
                ocorrencias++;
            }
        }
        return ocorrencias;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int substiruicoes=0;
        for(int i=0; i< lista.length;i++) {
            if(lista[i].equals(antigo)){
                lista[i]=novo;
                substiruicoes++;
            }
        }

        return substiruicoes;
    }

}

class Main2{
    public static void main(String[] args) {
        teste teste = new teste(5);

        teste.adicionarElemento("Elemento1");
//        teste.adicionarElemento("Elemento2");
//        teste.adicionarElemento("Elemento1");
//        teste.adicionarElemento("Elemento4");
//        teste.adicionarElemento("Elemento5");

        //teste.removerPorIndice(2);
        String[] t={"Elemento1","Elemento2","Elemento3","Elemento4","Elemento5","Elemento6"};
        System.out.println( teste.adicionarVarios(t));
        teste.exibirElementos();

    }
}