package _ADLLGenerics;

// Classe _ADLLGenerics: encarregada de executar alguns 
// testes/funcionalidades com a estrutura de dados lista circular duplamente encadeada
// e ordenada. A chave de comparação é interna ao objeto fazendo uso da interface
// Comparable e do método compareTo.
//
//Autor 1: Ivan Carlos Alcântara de Oliveira.
//Data da Criação: 10/10/2024. 15h.
public class _ADLLGenerics {
    public static void main(String[] args) {	
        DLL<Integer> lista = new DLL<>();

        // Adicionando elementos à lista duplamente ligada circular
        for (int i = 1; i <= 10; i++) {
            lista.insertAscending(i);
        }

        System.out.println("Lista original:");
        System.out.println(lista);

        // Remover posições ímpares
        lista.remove2(1);
        System.out.println("Após remover posições ímpares:");
        System.out.println(lista);

        // Recriar a lista e remover posições pares
        lista.clear();
        for (int i = 1; i <= 10; i++) {
            lista.insertAscending(i);
        }
        lista.remove2(2);
        System.out.println("Após remover posições pares:");
        System.out.println(lista);
    }
}
