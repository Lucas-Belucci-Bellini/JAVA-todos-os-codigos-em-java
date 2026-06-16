programa
{
    funcao inicio()
    {
        inteiro matriz[3][3]
        inteiro i, j

        para (i = 0; i < 3; i++)
        {
            para (j = 0; j < 3; j++)
            {
                escreva("Digite o valor [", i, "][", j, "]: ")
                leia(matriz[i][j])
            }
        }

        escreva("\nMatriz:\n")
        para (i = 0; i < 3; i++)
        {
            para (j = 0; j < 3; j++)
            {
                escreva(matriz[i][j], "\t")
            }
            escreva("\n")
        }
    }
}