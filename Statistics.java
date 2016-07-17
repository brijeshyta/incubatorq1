package knight;

import java.util.Arrays;

public class Statistics 
{
    int[] data;
    int size;   

    public Statistics(int[] data) 
    {
        this.data = data;
        size = data.length;
    }
    
    double getSum() {
    	double sum = 0.0;
        for(double a : data)
            sum += a;
    	return sum;
    	
    }

    double getMean()
    {
        double sum = getSum();
        return sum/size;
    }

    double getVariance()
    {
        double mean = getMean();
        double temp = 0;
        for(double a :data)
            temp += (mean-a)*(mean-a);
        return temp/size;
    }

    double getStdDev()
    {
        return Math.sqrt(getVariance());
    }

    
}