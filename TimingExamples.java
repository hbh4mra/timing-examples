package timingexamples;

import java.text.DecimalFormat;

/**
 *
 * @author Harmeet Bhamra
 */
public class TimingExamples {

//Some n^2 experiment
public static void someExperiment(double[][] d, int n){
    double s=0;
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
                    s+=d[i][j]+i+j;  //One operation  
  
}    
//Record mean and std deviation of performing an operation reps times       
    public static void meanAndStandardDeviation(int n, int reps){
        double sum=0,s=0;
        double[][] d=new double[n][n];
        double sumSquared=0;
        for(int i=0;i<reps;i++){
            long t1=System.nanoTime();
                someExperiment(d,n);
            long t2=System.nanoTime()-t1;
//Recording it in milli seconds to make it more interprettable
            sum+=(double)t2/1000000.0;
            sumSquared+=(t2/1000000.0)*(t2/1000000.0);
        }
        double mean=sum/reps;
        double variance=sumSquared/reps-(mean*mean);
        double stdDev=Math.sqrt(variance);
        DecimalFormat df=new DecimalFormat("###.####");
 //       System.out.println("n="+n+" Mean ="+df.format(mean)+" stdDev="+df.format(stdDev));
       System.out.println(df.format(mean));
        
    }
    public static void main(String[] args) {
        

            for(int n=100;n<=4200;n+=100)
                meanAndStandardDeviation(n,100);
    }
    
}
