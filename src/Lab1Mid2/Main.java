package Lab1Mid2;

import org.jetbrains.annotations.NotNull;

public class Main {

    public static void main(String[] args){
	// write your code here
        double[][] matrix = {{1,2,3,4},{2,3,4,5},{3,4,5,6},{4,5,6,7}};
        double[][] oneMatrix = {{0,0,0,1},{0,0,1,0},{0,1,0,0},{1,0,0,0}};

        int n = matrix.length;
        double[][] C;
        double[][] CT = new double[n][n];
        try{
            C = mult(matrix, oneMatrix);
            CT = transponate(C);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Initial matrix:");
        outputMatrix(matrix);
        //outputMatrix(C);
        System.out.println("Turned matrix:");
        outputMatrix(CT);

        String str = ".∧＿∧\n"+
            "( ･ω･｡)つ━☆・*。\n"+
        "⊂　 ノ 　　　・゜+.\n"+
        " しーＪ　　　°。+ *´¨)\n"+
        " 　　　　　　　　　.· ´¸.·*´¨)\n"+
        " 　　　　　　　　　　(¸.·´ (¸.·'*)\n";
        System.out.println(str);
    }

    static double[] @NotNull [] mult(double[][] A, double[][] B) throws Exception//A(m*n) B(n*q)
    {
        if (A == null) throw new Exception("Matrix A is null");
        if (B == null) throw new Exception("Matrix B is null");
        int m = A.length;
        int n = B.length;
        if (m == 0) throw new Exception("Matrix A is empty");
        if (n == 0) throw new Exception("Matrix B is empty");

        int q = B[0].length;/*
        m = 4;
        n =4;
        q = 4;*/

        double[][] result = new double[m][q];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < q; j++) {
                result[i][j] = 0;
                for (int k = 0; k < n; k++)
                    result[i][j] += A[i][k] * B[k][j];
            }
        }

        return result;
    }

    static double[][] transponate(double[][] A) throws Exception{ //A(m*n)
        if(A == null) throw new Exception("Matrix A is null");
        int m = A.length;
        int n = A[0].length;
        if(m == 0 || n == 0) throw new Exception("Matrix A is empty");

        double[][] AT = new double[m][n];
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                AT[j][i] = A[i][j];
            }
        }

        return AT;
    }

    static void outputMatrix(double[][] C){
        for (double[] raw : C){
            for (double number : raw){
                System.out.print(number);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
