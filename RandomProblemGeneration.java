/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timingexamples;

import java.util.Random;

/**
 *
 * @author Harmeet Bhamra
 */
public class RandomProblemGeneration {
    
    public static double[] generateQuery(int s){
        double[] q=new double[s];
        Random r=new Random();
        for(int i=0;i<s;i++)
            q[i]=r.nextDouble();
        return q;
    }
   public static double[][] generateDataSet(int n){
        double[][] data=new double[n][n];
        Random r=new Random();
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                data[i][j]=r.nextDouble();
        
        return data;
    }
    
}
