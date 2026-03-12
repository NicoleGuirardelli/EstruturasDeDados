package Listas;

public class MainListaDinamica {
    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();


        lista.adicionarElemento("elemento1");
        lista.adicionarElemento("elemento2");
        lista.adicionarElemento("elemento3");
        lista.adicionarElemento("elemento4");
        lista.adicionarElemento("elemento5");

        lista.exibirElementos();
        System.out.println("--------------------------------------");


        lista.buscarElemento("elemento1");
        lista.removerElemento("elemento0");

        System.out.println("Número de elementos na lista: "+lista.contar());
        System.out.println(lista.obter(4));
        System.out.println("--------------------------------------");


        lista.limpar();

        String [] novosElementos={"a","b","c","d","e","f","g","h","i"};
        System.out.println("elementos adicionados"+lista.adicionarVarios(novosElementos));
        lista.removerPorIndice(3);
        lista.inserir(1,"c");
        lista.exibirElementos();
        System.out.println("--------------------------------------");

        System.out.println(lista.ultimoIndiceDe("c"));
        System.out.println("Numero de ocorrencias do elemento C: "+ lista.contarOcorrencias("c")+
                ", Numero de ocorrencias de r: "+  lista.contarOcorrencias("r"));
        lista.substituir("c","p");


        System.out.println(lista.removerTodas("p"));
        lista.exibirElementos();

    }
}
