package ListaDinamica;
public class ListaDinamica {
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
        if(this.inicio.getConteudo() == null) {
            return false;
        } else {
            return true;
        }
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
            No aux=this.inicio;
            No anterior=null;

            while (aux!=null) {
                if (aux.getConteudo().equals(elemento)) {
                    if(anterior==null) {//verifico se ele é o primero elemento
                         this.inicio=aux.getProx();
                         //não funciona se o elemento for unico
                    }else{//aqui serve para os elementos do meio
                    anterior.setProx(aux.getProx());
                    }

                }else{
                    anterior=aux;
                }

                aux = aux.getProx();

            }
//            //verifica se o ultimo conteudo é igual ao elemento
//            if(aux.getConteudo().equals(elemento)) {
//                anterior.setProx(null);
//            }

        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }
}

