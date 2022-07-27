/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question1;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Harmeet Bhamra
 */
public class FindElementP {

    public static void main(String[] args) {

        //~~~|========== question 1 (a) ========== |~~~
        int[][] A = {
            {1, 3, 7, 8, 8, 9, 12},
            {2, 4, 8, 9, 10, 30, 38},
            {4, 5, 10, 20, 29, 50, 60},
            {8, 10, 11, 30, 50, 60, 61},
            {11, 12, 40, 80, 90, 100, 111},
            {13, 15, 50, 100, 110, 112, 120},
            {22, 27, 61, 112, 119, 138, 153},}; //2d array

        //the length of square 2d array, this wont change for 
        // as long as the array remains to be square
        int n = A.length; // currently 7
        // if some row was different e.x the first one then it's
        // length would be int n = A[0].length;       

        // array containing the values to be searched in the array A
        int[] pVals = {4, 12, 110, 5, 6, 111};

        System.out.println("~~~|========== question 1 (a) ========== |~~~\n");

        // iterate through all the values to be searched
        for (int i = 0; i < pVals.length; i++) {

            int p = pVals[i]; // element to search            

            // call method to find the value
            boolean found = FindElement_D(A, n, p);

            //Display results
            if (found) {
                System.out.println("Element: " + p + " was found!!!");
            } else {
                System.out.println("Element: " + p + " not found!");
            }
        }

        //~~~|========== question 1 (b) ========== |~~~
        System.out.println("\n~~~|========== question 1 (b) ========== |~~~\n");

        // iterate through all the values to be searched
        for (int i = 0; i < pVals.length; i++) {

            int p = pVals[i]; // element to search            

            // call method to find the value
            int a = FindElement_D1(A, n, p);

            //Display results
            if (a != -1) {
                System.out.println("Element: " + p + " was found!!!");
                System.out.println("Return from array: " + a + "\n");
            } else {
                System.out.println("Element: " + p + " not found!");
                System.out.println("Return from method: " + a + "\n");
            }
        }

        //~~~|========== question 1 (c) ========== |~~~
        System.out.println("\n~~~|========== question 1 (c) ========== |~~~\n");

        // iterate through all the values to be searched
        for (int i = 0; i < pVals.length; i++) {

            int p = pVals[i]; // element to search            

            // call method to find the value
            boolean a = FindElement_D2(A, n, p);

            //Display results
            if (a) {
                System.out.println("Element: " + p + " was found!!!");
                System.out.println("Return from array: " + a + "\n");
            } else {
                System.out.println("Element: " + p + " not found!");
                System.out.println("Return from method: " + a + "\n");
            }
        }

        /*test generateDataSet method
        System.out.println("data from method:   ");

        int[][] data = generateDataSet(10);
        for (int s = 0; s < n; s++) {
            System.out.println(Arrays.toString(data[s]));
        }

        System.out.println("======================================");
        
        */
        
        //~~~|========== question 3 ========== |~~~
        System.out.println("\n~~~|========== question 1 (3) ========== |~~~\n");
        System.out.println("=============== Algorithm 1 ==================\n");                
        Random r = new Random();
        int p = r.nextInt(); // find a random element p
        if (p == 0) {
            p++;
        }
        int reps = 100;
        int size_n = 10;
        while (size_n <= 4000) {
            meanAndStandardDeviation_D(size_n, p, reps);
            if (size_n < 100) {
                size_n += 10;
            } else if (size_n < 1000) {
                size_n += 100;
            } else if (size_n <= 4000) {
                size_n += 1000;
            }
        }
        System.out.println("\n=============== Algorithm 2 ==================\n");
        Random r2 = new Random();
        int p2 = r2.nextInt(); // find a random element p
        if (p2 == 0) {
            p2++;
        }
        int reps2 = 100;
        int size_n2 = 10;
        while (size_n2 <= 4000) {
            meanAndStandardDeviation_D2(size_n2, p2, reps2);
            if (size_n2 < 100) {
                size_n2 += 10;
            } else if (size_n2 < 1000) {
                size_n2 += 100;
            } else if (size_n2 <= 4000) {
                size_n2 += 1000;
            }
        }
        System.out.println("\n=============== Algorithm 3 ==================\n");
        Random r3 = new Random();
        int p3 = r3.nextInt(); // find a random element p
        if (p3 == 0) {
            p3++;
        }
        int reps3 = 100;
        int size_n3 = 10;
        while (size_n3 <= 4000) {
            meanAndStandardDeviation_D2(size_n3, p, reps);
            if (size_n3 < 100) {
                size_n3 += 10;
            } else if (size_n3 < 1000) {
                size_n3 += 100;
            } else if (size_n3 <= 4000) {
                size_n3 += 1000;
            }
        }
    }

    /**
     *
     * @param A the square 2D array given, to be searched
     * @param n the size of the square array A
     * @param p the element to be searched in the array
     * @return returns true if the given element p was found inside the array,
     * else returns false
     */
    public static boolean FindElement_D(int[][] A, int n, int p) {
        // go through all of the arrays elements one by one 
        // and check if the given value exists in the array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (p == (A[i][j])) {
                    return true; //value was found
                }
            }
        }
        return false; // value was not found
    }

    /**
     *
     * @param A the square 2D array given, to be searched
     * @param n the size of the square array A
     * @param p the element to be searched in the array
     * @return returns the element of the array if found else it returns -1
     */
    public static int FindElement_D1(int[][] A, int n, int p) {
        //use divide and conquer method for every row fo the array A
        for (int i = 0; i < n; i++) {
            //pointer to first element of array to be searched
            int low = 0;
            //pointer to last element of array to be searched
            int high = n - 1;
            // used to split array of search in middle, (divide into sub array)
            int mid = 0;
            //split array as long as the pointers do not meet
            while (low <= high) {
                mid = (low + high) / 2;
                if (A[i][mid] > p) {
                    //if bigger, split array and search first part of array
                    high = mid - 1; //last element becomes current middle - 1
                } else if (A[i][mid] < p) {
                    //if smaller, split array and serach second part of array
                    low = mid + 1;//first element becomes curent middle + 1
                } else {
                    // if comparison is not < or > then element found (==)
                    return A[i][mid]; // return the element found
                }
            }
        }
        return -1; // if value not found, return false index
    }

    /**
     *
     * @param A the square 2D array given, to be searched
     * @param n the size of the square array A
     * @param p the element to be searched in the array
     * @return returns true if element found else it returns false
     */
    public static boolean FindElement_D2(int[][] A, int n, int p) {
        //Start from the top right most element of the array A
        //that way anything to the right is definetelly smaller
        //and anything below is definatelly bigger.
        //when comparisons are made move as appropriate
        int i = 0; // first row
        int j = n - 1; // last column
        // above the coordinances for the top right most element
        while (i < n && j >= 0) {
            if (A[i][j] == p) {
                //element found
                return true;
            }
            if (A[i][j] < p) {
                //p is bigger than element, eliminate first row
                // we do that because we ar definatelly sure that
                // the elements on that row are smaller
                //(or equal but this would be checked in top if statement)
                i++;
            } else {
                //p is smaller than element, eliminate last column
                // we do that because we ar definatelly sure that
                // the elements on that column are smaller
                //(or equal but this would be checked in top if statement)                
                j--;
            }
        }
        return false; //element was not found
    }

    /**
     *
     * creates an array with the elements in a non-decreasing order to perform
     * the timing experiments
     *
     * @param n the size of an n x n matrix
     * @return an n x n matrix in which every row and column elements are in a
     * non-decreasing order.
     */
    public static int[][] generateDataSet(int n) {
        int[][] data = new int[n][n];
        Random r = new Random();
        int t;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t = r.nextInt(n + (i * n)); //random value for array
                if (t == 0) {
                    t++;//values are positive integers
                }
                if ((i > 0) && (t < data[i - 1][n - 1])) {
                    //to have the non-decreasing property(columns), minimum element 
                    //is bigger than or equal to the last element of the previous row
                    t = t + data[i - 1][n - 1];
                }
                data[i][j] = t;
            }
            //after each row is completed make sure to sort it
            //so that we keep the non decreasing property
            Arrays.sort(data[i]); 
        }

        return data;
    }

    /**
     * Record mean and std deviation of performing an operation reps times 
     * @param n size of n x n matrix
     * @param p element p to be searched
     * @param reps repeats
     */
    public static void meanAndStandardDeviation_D2(int n, int p, int reps) {
        double sum = 0, s = 0;
        int[][] A;
        A = generateDataSet(n);
        double sumSquared = 0;
        for (int i = 0; i < reps; i++) {
            long t1 = System.nanoTime();
            FindElement_D2(A, n, p);
            long t2 = System.nanoTime() - t1;
//Recording it in milli seconds to make it more interprettable
            sum += (double) t2 / 1000000.0;
            sumSquared += (t2 / 1000000.0) * (t2 / 1000000.0);
        }
        double mean = sum / reps;
        double variance = sumSquared / reps - (mean * mean);
        double stdDev = Math.sqrt(variance);
        DecimalFormat df = new DecimalFormat("###.####");
        System.out.println("n=" + n + " Mean ="
                + df.format(mean)
                + " stdDev=" + df.format(stdDev));

    }
    
    /**
     * Record mean and std deviation of performing an operation reps times 
     * @param n size of n x n matrix
     * @param p element p to be searched
     * @param reps repeats
     */
    public static void meanAndStandardDeviation_D1(int n, int p, int reps) {
        double sum = 0, s = 0;
        int[][] A;
        A = generateDataSet(n);
        double sumSquared = 0;
        for (int i = 0; i < reps; i++) {
            long t1 = System.nanoTime();            
            FindElement_D1(A, n, p);
            long t2 = System.nanoTime() - t1;
//Recording it in milli seconds to make it more interprettable
            sum += (double) t2 / 1000000.0;
            sumSquared += (t2 / 1000000.0) * (t2 / 1000000.0);
        }
        double mean = sum / reps;
        double variance = sumSquared / reps - (mean * mean);
        double stdDev = Math.sqrt(variance);
        DecimalFormat df = new DecimalFormat("###.####");
        System.out.println("n=" + n + " Mean ="
                + df.format(mean)
                + " stdDev=" + df.format(stdDev));

    }
    
    /**
     * Record mean and std deviation of performing an operation reps times 
     * @param n size of n x n matrix
     * @param p element p to be searched
     * @param reps repeats
     */
    public static void meanAndStandardDeviation_D(int n, int p, int reps) {
        double sum = 0, s = 0;
        int[][] A;
        A = generateDataSet(n);
        double sumSquared = 0;
        for (int i = 0; i < reps; i++) {
            long t1 = System.nanoTime();            
            FindElement_D(A, n, p);
            long t2 = System.nanoTime() - t1;
//Recording it in milli seconds to make it more interprettable
            sum += (double) t2 / 1000000.0;
            sumSquared += (t2 / 1000000.0) * (t2 / 1000000.0);
        }
        double mean = sum / reps;
        double variance = sumSquared / reps - (mean * mean);
        double stdDev = Math.sqrt(variance);
        DecimalFormat df = new DecimalFormat("###.####");
        System.out.println("n=" + n + " Mean ="
                + df.format(mean)
                + " stdDev=" + df.format(stdDev));

    }
}
