package Listas;

public class MainListaSimples {

    public static void main(String[] args) {
        ListaSimples listaSimples = new ListaSimples(5);

        listaSimples.adicionarElemento("elemento1");
        listaSimples.adicionarElemento("elemento2");
        listaSimples.adicionarElemento("elemento3");
        listaSimples.adicionarElemento("elemento4");
        listaSimples.adicionarElemento("elemento5");

        listaSimples.exibirElementos();
        System.out.println("--------------------------------------");
        listaSimples.alterarElemento("elemento1", "elemento0");

        listaSimples.buscarElemento("elemento1");
        listaSimples.removerElemento("elemento0");

        System.out.println("Número de elementos na lista: "+listaSimples.contar());
        System.out.println(listaSimples.obter(4));
        System.out.println("--------------------------------------");


        listaSimples.limpar();

        String [] novosElementos={"a","b","c","d","e","f","g","h","i"};
        System.out.println("elementos adicionados"+listaSimples.adicionarVarios(novosElementos));
        listaSimples.removerPorIndice(3);
        listaSimples.inserir(1,"c");
        listaSimples.exibirElementos();
        System.out.println("--------------------------------------");

        System.out.println(listaSimples.ultimoIndiceDe("c"));
        System.out.println("Numero de ocorrencias do elemento C: "+ listaSimples.contarOcorrencias("c")+
              ", Numero de ocorrencias de r: "+  listaSimples.contarOcorrencias("r"));
        listaSimples.substituir("c","p");


        System.out.println(listaSimples.removerTodas("p"));
        listaSimples.exibirElementos();

    }

}
