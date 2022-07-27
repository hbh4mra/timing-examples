/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question2;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 *
 * @author Harmeet Bhamra
 */
public class FunctionG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //~~~|========== question 2 (1) ========== |~~~
        System.out.println("~~~|========== question 2 (1) ========== |~~~\n");

        //be carefull with n2 because big values will cause a stack over flow
        int n2 = 15; //2d array size
        double[][] g2 = new double[n2][n2]; //create space to save it
        g2 = computeFunctionG(g2, n2, 0, 0); //get the array from the method

        for (int j = 0; j < n2; j++) {//print the array
            System.out.println(Arrays.toString(g2[j]));
        }
        
        System.out.println();
        int size_n;
        int reps = 100;
        for (size_n = 10; size_n <= 15; size_n++) {
            meanAndStandardDeviationRecursiveF(size_n, reps);
        }

        //~~~|========== question 2 (2) ========== |~~~
        System.out.println("\n~~~|========== question 2 (2) ========== |~~~\n");

        int n = 100; //2d array size        
        double[][] g = new double [n][n]; //create array g to save the function array
        g = computeFunctionGefficient(g,n); //get the array from the method

        for (int j = 0; j < n; j++) {//print the array
            System.out.println(Arrays.toString(g[j]));
        }
        
        //~~~|========== question 2 (3) ========== |~~~
        System.out.println("\n~~~|========== question 2 (3) ========== |~~~\n");
        
        int size_n2 = 10;
        int r = 6;
        int end = (int) Math.pow(size_n2, r);
        int reps2 = 100;
        for (size_n2 = 10; size_n2 <= end; size_n2 = size_n2*size_n2) {
            meanAndStandardDeviationIterativeF(size_n2, reps2);
        }
    }

    /**
     * Method implemented recursively, large numbers of n will cause a stack
     * overflow
     *
     * @param g a preinitialised 2d array of space n x n
     * @param n the size of array g n x n
     * @param i the starting row to compute function g (use 0)
     * @param j the starting column to compute function g(use 0)
     * @return returns the computed function inside 2d array g
     */
    public static double[][] computeFunctionG(double[][] g, int n, int i, int j) {
        //base case, when reaching the end of array return(will stop with i==n)
        if ((i == n) || (j == n)) {
            return g;//return the 2d array
        }
        int r = i;//save current row
        int c = j;//save current column

        c++;//increment column to go through array
        if (c == n - 1) {
            // if we reached the end of a row, reset to next row
            //and set column to zero
            c = 0;
            r++;
        }

        if ((i == 0) && (j == 0)) {//first element is 0
            g[i][j] = 0;
            computeFunctionG(g, n, r, c);//recurse with different row and column
        } else if (((j == 0) && (i > 0)) || ((i == 0) && (j > 0))) {
            //first row and column is set to 1
            g[i][j] = 1;
            computeFunctionG(g, n, r, c);//recurse with different row and column
        } else {
            //every other element from (1,1) to (n-1,n-1)
            //is the average of three previous elements
            //the top, the top left and the one on the left
            g[i][j] = ((g[i - 1][j]) + (g[i - 1][j - 1]) + (g[i][j - 1])) / 3;
            computeFunctionG(g, n, r, c);//recurse with different row and column
        }
        return g;
    }

    /**
     *
     * @param n the size of the 2d n x n array
     * @return returns a 2d array that is populated via the function g(n) =
     * f(n,n)
     */
    public static double[][] computeFunctionGefficient(double [][] g, int n) {
        //this is more efficient than the recursive, because 
        //we dont use the stack to store elements in the recursive calls
        //which speeds up the process.
        //Algorithm will be n^2 because we have to write these elements
        //in the array and the best way to do this will still require
        //us to write n^2 elements.        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if ((i == 0) && (j == 0)) {//first element is 0
                    g[i][j] = 0;
                } else if (((j == 0) && (i > 0)) || ((i == 0) && (j > 0))) {
                    //first row and column is set to 1
                    g[i][j] = 1;
                } else {
                    //every other element from (1,1) to (n-1,n-1)
                    //is the average of three previous elements
                    //the top, the top left and the one on the left
                    g[i][j] = ((g[i - 1][j]) + (g[i - 1][j - 1]) + (g[i][j - 1])) / 3;
                }
            }
        }
        //after creating the array return it
        return g;
    }

    /**
     * Record mean and std deviation of performing an operation reps times
     *
     * @param n size of n x n matrix
     * @param reps repeats
     */
    public static void meanAndStandardDeviationRecursiveF(int n, int reps) {
        //be carefull with n because big values will cause a stack over flow        
        double[][] g2 = new double[n][n]; //create space to save it        
        double sum = 0, s = 0;        
        double sumSquared = 0;
        for (int i = 0; i < reps; i++) {
            long t1 = System.nanoTime();
            g2 = computeFunctionG(g2, n, 0, 0);
            long t2 = System.nanoTime() - t1;
//Recording it in milli seconds to make it more interprettable
            sum += (double) t2 / 1000000.0;
            sumSquared += (t2 / 1000000.0) * (t2 / 1000000.0);
        }
        double mean = sum / reps;
        double variance = sumSquared / reps - (mean * mean);
        double stdDev = Math.sqrt(variance);
        DecimalFormat df = new DecimalFormat("###.####");
        System.out.println("n="+n+" Mean ="+df.format(mean)+" stdDev="+df.format(stdDev));
        
    }
    
    /**
     * Record mean and std deviation of performing an operation reps times
     *
     * @param n size of n x n matrix
     * @param reps repeats
     */
    public static void meanAndStandardDeviationIterativeF(int n, int reps) {
        double sum = 0, s = 0;
        double[][] d = new double[n][n];
        double sumSquared = 0;
        for (int i = 0; i < reps; i++) {
            long t1 = System.nanoTime();
            d = computeFunctionGefficient(d,n);
            long t2 = System.nanoTime() - t1;
//Recording it in milli seconds to make it more interprettable
            sum += (double) t2 / 1000000.0;
            sumSquared += (t2 / 1000000.0) * (t2 / 1000000.0);
        }
        double mean = sum / reps;
        double variance = sumSquared / reps - (mean * mean);
        double stdDev = Math.sqrt(variance);
        DecimalFormat df = new DecimalFormat("###.####");
        System.out.println("n="+n+" Mean ="+df.format(mean)+" stdDev="+df.format(stdDev));
        
    }
}
