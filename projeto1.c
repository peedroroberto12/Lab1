#include <stdio.h>

#define MAX_LINES 30
#define MAX_LEN 30

int vetorzao(){}

int main(void)
{
  int k,j,l,m,n;
  char data[MAX_LINES][MAX_LEN];
  

  FILE *file;
  
  file = fopen("palavras.txt", "r");

  
  int line = 0;
  
  while (!feof(file) && !ferror(file))
    if (fgets(data[line], MAX_LEN, file) != NULL)
      line++;
  
  fclose(file);
   
  for (int i = 0; i < line; i++)
    printf("%s", data[i]);

    for(k =0; k < 24; k++){
        printf("%s\n",data[k]);
        for(j =0; j < 24; j++){
            printf("%s %s",data[k],data[j]);
/*
            for(l =0;l<24;l++){
                printf("[%s,%s,%s]\n",data[k],data[j],data[l]);
                for(m=0; m<24;m++){
                    printf("[%s,%s,%s,%s]\n",data[k],data[j],data[l],data[m]);
                    for(n=0;n<24;n++){
                        printf("[%s,%s,%s,%s,%s]\n",data[k],data[j],data[l],data[m],data[n]);
                    }
                }
            }
    */
        }
    }

  return 0;
  }
