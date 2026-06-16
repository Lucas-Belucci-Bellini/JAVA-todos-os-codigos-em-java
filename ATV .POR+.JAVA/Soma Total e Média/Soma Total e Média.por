programa
{
    funcao inicio()
    {
        real matriz[4][4]
        inteiro i, j
        real soma = 0.0, media

        para (i = 0; i < 4; i++)
        {
            para (j = 0; j < 4; j++)
            {
                escreva("Digite o valor [", i, "][", j, "]: ")
                leia(matriz[i][j])
                soma = soma + matriz[i][j]
            }
        }

        media = soma / 16.0
        escreva("\nSoma total: ", soma, "\n")
        escreva("Media: ", media, "\n")
    }
}