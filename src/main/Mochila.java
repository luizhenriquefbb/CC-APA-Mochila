package main;

public class Mochila {

    /**
     * Construtor vazio
     */
    public Mochila() {
    }

    /**
     * Retorna o valor maximo que pode ser colocado em uma mochila
     *
     * <a href = https://dzone.com/articles/knapsack-problem>fonte</a>
     *
     * @param pesoDosObjetos
     * @param valoresDosObjetos
     * @return
     */
    public int mochila(int pesoDosObjetos[], int valoresDosObjetos[], int capacidadeMochila) {

        int numObjetos = pesoDosObjetos.length;

        // matriz de soluções: itens estao em linha, pesos são as colunas e o valor da matriz é o valor carregado
        int[][] matriz = new int[numObjetos + 1][capacidadeMochila + 1];

        // Couluna 0 inicia com 0
        for (int col = 0; col <= capacidadeMochila; col++) {

            matriz[0][col] = 0;

        }

        // linha 0 inicia com 0
        for (int linha = 0; linha <= numObjetos; linha++) {

            matriz[linha][0] = 0;

        }

        // demais elementos
        // para todos os itens
        for (int item = 1; item <= numObjetos; item++) {

            //linha a linha
            for (int peso = 1; peso <= capacidadeMochila; peso++) {

                
                // verifica se a mochila aguenta o novo elemento
                if (pesoDosObjetos[item - 1] <= peso) {
                    // Caso aguente, verifica se o novo valor eh maior ou menor que o valor anterior. Pega o maior
                    matriz[item][peso] = max(valoresDosObjetos[item - 1] + matriz[item - 1][peso - pesoDosObjetos[item - 1]],
                            matriz[item - 1][peso]);

                // se não agunetar, pega o valor anterior
                } else {

                    matriz[item][peso] = matriz[item - 1][peso];

                }

            }

        }

        //Printa matriz
        for (int[] linhas : matriz) {

            for (int col : linhas) {

                System.out.format("%5d", col);

            }

            System.out.println();

        }
        
        // TODO: pegar itens escolhidos
        
        
        
        
        
        

        return matriz[numObjetos][capacidadeMochila];

    }

    /**
     * Funcao auxiliar que retorna o maximo dentre dois valores
     *
     * @param a
     * @param b
     * @return
     */
    static int max(int a, int b) {

        return (a > b) ? a : b;

    }
}
