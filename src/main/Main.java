package main;

import fileManager.FileManager;

public class Main {
/* fonte https://ide.geeksforgeeks.org/index.php*/

    public static void main(String args[])
    {
        //ler arquivo de entrada
        String DIRETORIO = "instancias_mochila/";
       // String entrada = FileManager.readFromFile(DIRETORIO+"entrada.txt");
        String entrada = FileManager.readFromFile(DIRETORIO+"mochila01.txt.txt");
        String[] linhas = entrada.split("\n");

       // primeira linha
        String[] temp1 = linhas[0].split(" ");
        int qntObjetos = Integer.parseInt(temp1[0]);
        int pesoMaximo = Integer.parseInt(temp1[1]);


       // objetos
        int valores[] = new int[qntObjetos];
        int wt[] = new int[qntObjetos];
        for (int i = 1; i < linhas.length; i++) {
            String[] temp2 = linhas[i].split(" ");
            valores[i-1] = Integer.parseInt(temp2[0]);
            wt[i-1] = Integer.parseInt(temp2[1]);

         }

        // run mochila!!
        Mochila mochila = new Mochila();
        System.out.println(mochila.mochila(wt, valores, pesoMaximo));
    }
}


