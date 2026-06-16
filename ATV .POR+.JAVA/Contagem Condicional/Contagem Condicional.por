programa
{
    funcao inicio()
    {
        inteiro matriz[3][4]
        inteiro i, j
        inteiro pares = 0, impares = 0

        para (i = 0; i < 3; i++)
        {
            para (j = 0; j < 4; j++)
            {
                escreva("Digite o valor [", i, "][", j, "]: ")
                leia(matriz[i][j])
            }
        }

        escreva("\nPosicoes dos numeros pares:\n")
        para (i = 0; i < 3; i++)
        {
            para (j = 0; j < 4; j++)
            {
                se (matriz[i][j] % 2 == 0)
                {
                    pares = pares + 1
                    escreva("[", i, "][", j, "] = ", matriz[i][j], "\n")
                }
                senao
                {
                    impares = impares + 1
                }
            }
        }

        escreva("\nTotal de pares: ", pares, "\n")
        escreva("Total de impares: ", impares, "\n")
    }
}