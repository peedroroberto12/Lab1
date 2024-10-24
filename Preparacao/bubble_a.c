#include <stdio.h>
#include "vetor_utils.h"

int bubble_sort(int v[], int n) {
    int i, contador;
    int contagem = 0;
    // repetir (n – 1) vezes
    for (contador = 1; contador <= n-1; contador++) {
        // percorrer o vetor
        for (i = 0; i < n-1; i++) {
            // se elemento atual for maior que o próximo
            if (v[i] > v[i+1]) {
                contagem++;
                // troca os elementos entre as 2 posições
                trocar(v, i, i+1);
            }
        }
    }
}

int main(void) {
  int n = 15;  // tente trocar o valor de n...
  int v[n];
  gerar_numeros(v, n);
  imprimir(v, n);
  int contagem  = bubble_sort(v, n);
  imprimir(v, n);
  printf("Contagem: %d",contagem);
}