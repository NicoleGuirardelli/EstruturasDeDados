package Listas;
public class ListaDinamica  implements ListaOperacoes{
    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista Dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String conteudo) {
        if (!this.existeInicio()) {
            this.inicio.setConteudo(conteudo);
        } else {
            No novoNo = new No(conteudo);
            No aux = this.inicio;

            while (aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }

    private boolean existeInicio() {
        if (this.inicio.getConteudo() == null) {
            return false;
        } else {
            return true;
        }
    }

    public void exibirElementos() {
        if (existeInicio()) {
            No aux = this.inicio;

            while (aux.getProx() != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
            System.out.println(aux.getConteudo());
        } else {
            System.out.println("Não existem elementos na Lista Dinâmica.");
        }
    }

    public void removerElemento(String elemento) {
        if (existeInicio()) {
            No aux = this.inicio;
            No anterior = null;

            while (aux != null) {
                if (aux.getConteudo().equals(elemento)) {
                    if (anterior == null) {//verifico se ele é o primero elemento
                        this.inicio = aux.getProx();
                        return;
                        //não funciona se o elemento for unico
                    } else {//aqui serve para os elementos do meio
                        anterior.setProx(aux.getProx());
                        return;
                    }

                } else {
                    anterior = aux;
                }
                aux = aux.getProx();
            }
        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    @Override
    public int removerTodas(String elemento) {
        int elementoRemovido=0;
        if (existeInicio()) {
            No aux = this.inicio;
            No anterior = null;

            while (aux != null) {
                if (aux.getConteudo().equals(elemento)) {
                    if (anterior == null) {//verifico se ele é o primero elemento
                        this.inicio = aux.getProx();

                    } else {//aqui serve para os elementos do meio
                        anterior.setProx(aux.getProx());
                    }
                    elementoRemovido++;

                } else {
                    anterior = aux;
                }
                aux = aux.getProx();
            }
        }
        return elementoRemovido;
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
            if (!this.existeInicio()) {
                this.inicio.setConteudo(elemento);
                elementoAdicionado++;
            } else {
                No novoNo = new No(elemento);
                No aux = this.inicio;
                elementoAdicionado++;

                while (aux.getProx() != null) {
                    aux = aux.getProx();
                }
                aux.setProx(novoNo);
            }

        }
        return elementoAdicionado;
    }

    @Override
    public String obter(int indice) {
        String elementoRetorno = null;
        if (existeInicio()) {
            No aux = this.inicio;
            int posicao=0;
            while (aux!= null) {
                if(posicao==indice) {
                    return elementoRetorno = aux.getConteudo();
                }
                aux=aux.getProx();
                posicao++;
            }
        }
        return elementoRetorno;
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        int posicao=0;
        No aux = this.inicio;
        No anterior = null;
        No novoNo = new No(elemento);
        while (aux!= null) {
            if(posicao==indice) {
                if (anterior == null) {//verifico se ele é o primero elemento
                  anterior=aux;
                  this.inicio = novoNo;
                  novoNo.setProx(anterior.getProx());
                }else{
                        anterior.setProx(novoNo);
                        novoNo.setProx(aux);
                        return true;
                }
            }
            anterior = aux;
            aux=aux.getProx();
            posicao++;
        }
        return false;
        //melhorar quando a posição for zero
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
        if (existeInicio()) {
            this.inicio.setConteudo(null);
        }

    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        if (existeInicio()) {
            int ocorrencia=0;
            int posicao = 0;
            No aux = this.inicio;
            while (aux != null) {
                if (aux.getConteudo().equals(elemento)) {
                    ocorrencia++;
                    if (ocorrencia == this.contarOcorrencias(elemento)) {
                        return posicao;
                    }
                }
                posicao++;
                aux = aux.getProx();
            }
        }
        return -1;
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