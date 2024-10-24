#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void imprimirarray(int arr[], int tamanho) {
    for (int i = 0; i < tamanho; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n"); 
}

int valido(int elemento, int vetor[], int n) {
    for (int i = 0; i < n; i++) {
        if (vetor[i] == elemento) {
            return 1;
        }
    }
    return 0; 
}
int gerador(int vetor[],int n){
    srand(time(NULL));
    for (int i = 0; i < n; i++) {
        int numero;
        do {
            numero = rand() % 100; 
        } while (valido(numero, vetor, i)); 
        
        vetor[i] = numero; 
        printf("Valor %i: %i\n", i + 1, vetor[i]);
    }

}
int main() {   

    int n = 5;
    int vetor[n];
    gerador(vetor,n);
    imprimirarray(vetor,n);
    return 0;
}
