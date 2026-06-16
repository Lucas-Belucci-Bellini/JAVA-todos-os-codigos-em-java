programa
{
    funcao inicio()
    {
        inteiro matriz[3][3]
        inteiro i, j
        inteiro maior, colMaior

        para (i = 0; i < 3; i++)
        {
            para (j = 0; j < 3; j++)
            {
                escreva("Digite o valor [", i, "][", j, "]: ")
                leia(matriz[i][j])
            }
        }

        escreva("\n")
        para (i = 0; i < 3; i++)
        {
            maior = matriz[i][0]
            colMaior = 0
            para (j = 1; j < 3; j++)
            {
                se (matriz[i][j] > maior)
                {
                    maior = matriz[i][j]
                    colMaior = j
                }
            }
            escreva("Linha ", i, ": maior valor = ", maior,
                    " na posicao [", i, "][", colMaior, "]\n")
        }
    }
}