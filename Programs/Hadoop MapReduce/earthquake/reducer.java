package earthquake;

import java.io.*;
import java.util.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.fs.*;

public class reducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable> {
    public void reduce(Text arg0, Iterator<DoubleWritable> arg1, OutputCollector<Text, DoubleWritable> arg2, Reporter r) throws IOException{
        double max = Double.MIN_VALUE;
        while(arg1.hasNext()){
            double val = arg1.next().get();
            if(val > max){
                max = val;
            }
        }
        arg2.collect(arg0, new DoubleWritable(max));
    }
}