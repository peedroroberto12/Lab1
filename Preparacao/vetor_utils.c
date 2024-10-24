#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void trocar(int v[], int i, int j) {
  int tmp = v[i];
  v[i] = v[j];
  v[j] = tmp;
}

void gerar_numeros(int v[], int n) {
  srand(time(NULL));
  int i;
  int a = rand() % 3 + 1;
  int b = rand() % 5 + 1;
  for (i = 0; i < n; i++) v[i] = i * a + b;
  for (i = 0; i < n; i++) {
    int j = rand() % n;
    trocar(v, i, j);
  }
}

void imprimir_indices(int n) {
  int i;
  for (i = 0; i < n; i++) printf(" %2d", i);
  printf("\n");
}

void imprimir_grid(int n) {
  int i;
  for (i = 0; i < n; i++) printf("+--");
  printf("+\n");
}

void imprimir(int v[], int n) {
  int i;
  printf("\n");
  imprimir_indices(n);
  imprimir_grid(n);
  for (i = 0; i < n; i++) {
    printf("|%2d", v[i]);
  }
  printf("|\n");
  imprimir_grid(n);
  printf("\n");
}