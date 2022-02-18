package average;

import java.io.*;
import java.util.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapred.*;

public class reducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable>{
    public void reduce(Text arg0, Iterator<DoubleWritable> arg1, OutputCollector<Text, DoubleWritable> arg2, Reporter r) throws IOException{
        double count = 0.0;
        double sum = 0.0;
        double avg= 0.0;
        while(arg1.hasNext()){
            double val = arg1.next().get();
            sum += val;
            count += 1.0;
        }
        avg = sum/count;
        String m1 = "No. of " + arg0 + " employess : ";
        String m2 = "Average salary of "+arg0+" employees : ";
        arg2.collect(new Text(m1), new DoubleWritable(count));
        arg2.collect(new Text(m2), new DoubleWritable(avg));        
    }
}