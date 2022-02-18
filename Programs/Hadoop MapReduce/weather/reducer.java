package weather;

import java.io.*;
import java.util.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapred.*;

public class reducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{
    public void reduce(Text arg0, Iterator<IntWritable> arg1, OutputCollector<Text, IntWritable> arg2, Reporter r ) throws IOException{
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while(arg1.hasNext()){
            int val = arg1.next().get();
            if(min > val ){
                min = val;
            }
            if(val > max){
                max = val;
            }
        }
        arg2.collect(new Text("For the year " + arg0 + ", the Max temp is : "), new IntWritable(max));
        arg2.collect(new Text("For the year " + arg0 + ", the Min temp is : "), new IntWritable(min));

    }
}