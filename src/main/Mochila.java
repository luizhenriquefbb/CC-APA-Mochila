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
	 * @param pesoDosObjetos
	 * @param valoresDosObjetos
	 * @return
	 */
	public int mochila(int pesoDosObjetos[], int valoresDosObjetos[], int capacidadeMochila) {



		int numObjetos = pesoDosObjetos.length;

//        matriz de soluções: itens estao em linha, pesos são as colunas e o valor da matriz é o valor carregado
		int[][] matriz = new int[numObjetos + 1][capacidadeMochila + 1];


//      Couluna 0 inicia com 0
		for (int col = 0; col <= capacidadeMochila; col++) {

			matriz[0][col] = 0;

		}

//        linha 0 inicia com 0
		for (int linha = 0; linha <= numObjetos; linha++) {

			matriz[linha][0] = 0;

		}

//		demais elementos
		for (int item = 1; item <= numObjetos; item++) {

			//linha a linha

			for (int peso = 1; peso <= capacidadeMochila; peso++) {

				//Is the current items weight less than or equal to running weight

				if (pesoDosObjetos[item - 1] <= peso) {
					// verifica se a mochila aguenta o novo elemento

					matriz[item][peso] = Math.max(valoresDosObjetos[item - 1] + matriz[item - 1][peso - pesoDosObjetos[item - 1]],
							matriz[item - 1][peso]);

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
