#include <stdio.h>
#include <stdlib.h>

int main()
{
    int tam;
    char *str;
    printf("Defina o tamanho da string: ");
    scanf("%d", &tam);

    str = (char *) malloc(tam * sizeof(char));

    printf("Insira a string: ");
    setbuf(stdin, NULL);
    scanf("%[^\n]%*c", str);

    for(int i = 0; i < tam; i++){
        if(str[i] != 'a' && str[i] != 'e' && str[i] != 'i' && str[i] != 'o' && str[i] != 'u' &&
           str[i] != 'A' && str[i] != 'E' && str[i] != 'I' && str[i] != 'O' && str[i] != 'U'){
            printf("%c", str[i]);
           }
    }

    return 0;
}
