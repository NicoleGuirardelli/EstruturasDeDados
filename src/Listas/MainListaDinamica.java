package Listas;

public class MainListaDinamica {
    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();
        lista.adicionarElemento("50");
        lista.adicionarElemento("51");
        lista.adicionarElemento("52");
        lista.adicionarElemento("53");
        lista.adicionarElemento("50");
        System.out.println("Antes de remover: ");
        lista.exibirElementos();

        String []e={"4","7"};
        System.out.println("Depois de remover: ");
        System.out.println(lista.contarOcorrencias("50"));

        System.out.println(lista.substituir("50","dd"));
        lista.exibirElementos();





    }
}
