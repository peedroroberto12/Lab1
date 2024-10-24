#include <stdio.h>
#include <stdlib.h>
#include <time.h>


void imprimirarray(int arr[], int tamanho) {
    for (int i = 0; i < tamanho; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n"); 
}

void trocar(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void bubble_sort(int v[], int n) {
    int i, contador;
    for (contador = 1; contador <= n-1; contador++) {
        for (i = 0; i < n-1; i++) {
            if (v[i] > v[i+1]) {
                trocar(v, i, i+1);
            }
        }
    }
}

int valido(int elemento, int vetor[], int n) {
    for (int i = 0; i < n; i++) {
        if (vetor[i] == elemento) {
            return 1;
        }
    }
    return 0; 
}

int main() {   
    int n = 5;
    int vetor[n];
    srand(time(NULL));

    for (int i = 0; i < n; i++) {
        int numero;
        do {
            numero = rand() % 100; 
        } while (valido(numero, vetor, i)); 
        
        vetor[i] = numero;
        printf("Valor %i: %i\n", i + 1, vetor[i]);
    }

    bubble_sort(vetor,n);
    
    imprimirarray(vetor,n);

    return 0;
}