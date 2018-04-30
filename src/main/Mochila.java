package main;

public class Mochila {

    /**
     * Construtor vazio
     */
    public Mochila(){}



    /**
     * Retorna o valor maximo que pode ser colocado em uma mochila
     * @param wt
     * @param val
     * @return
     */
    public int mochila(int wt[], int val[], int W) {
//        int i, w;
//        int K[][] = new int[n + 1][this.pesoMaximo + 1];
//
//        // Build table K[][] in bottom up manner
//        for (i = 0; i <= n; i++) {
//            for (w = 0; w <= this.pesoMaximo; w++) {
//                if (i == 0 || w == 0)
//                    K[i][w] = 0;
//                else if (wt[i - 1] <= w)
//                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
//                else
//                    K[i][w] = K[i - 1][w];
//            }
//        }
//
//        return K[n][this.pesoMaximo];

//        ========================================

        
        int N = wt.length; // Get the total number of items. Could be wt.length or val.length. Doesn't matter

        int[][] V = new int[N + 1][W + 1]; //Create a matrix. Items are in rows and weight at in columns +1 on each side

        //What if the knapsack's capacity is 0 - Set all columns at row 0 to be 0

        for (int col = 0; col <= W; col++) {

            V[0][col] = 0;

        }

        //What if there are no items at home.  Fill the first row with 0

        for (int row = 0; row <= N; row++) {

            V[row][0] = 0;

        }

        for (int item=1;item<=N;item++){

            //Let's fill the values row by row

            for (int weight=1;weight<=W;weight++){

                //Is the current items weight less than or equal to running weight

                if (wt[item-1]<=weight){

                    //Given a weight, check if the value of the current item + value of the item that we could afford with the remaining weight

                    //is greater than the value without the current item itself

                    V[item][weight]=Math.max (val[item-1]+V[item-1][weight-wt[item-1]], V[item-1][weight]);

                }

                else {

                    //If the current item's weight is more than the running weight, just carry forward the value without the current item

                    V[item][weight]=V[item-1][weight];

                }

            }

        }

        //Printing the matrix

        for (int[] rows : V) {

            for (int col : rows) {

                System.out.format("%5d", col);

            }

            System.out.println();

        }

        return V[N][W];

    }



    /**
     * Funcao auxiliar que retorna o maximo dentre dois valores
     * @param a
     * @param b
     * @return
     */
    static int max(int a, int b) {

        return (a > b)? a : b;

    }
}
