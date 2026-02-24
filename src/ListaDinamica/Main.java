package ListaDinamica;

public class Main {
    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();
        lista.adicionarElemento("50");
        lista.adicionarElemento("51");
        lista.adicionarElemento("52");
        lista.adicionarElemento("53");
        lista.adicionarElemento("54");
        System.out.println("Antes de remover: ");
        lista.exibirElementos();

        System.out.println("Depois de remover: ");
        lista.removerElemento("50");
        lista.removerElemento("51");
        lista.adicionarElemento("13");
        lista.exibirElementos();


    }
}
