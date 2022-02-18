package odd_even;

import java.io.*;
import java.util.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapred.*;

public class reducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{
  public void reduce(Text arg0, Iterator<IntWritable> arg1, OutputCollector<Text, IntWritable> arg2, Reporter r) throws IOException{
      int sum = 0;
      int count = 0;
      while(arg1.hasNext()){
        int val = arg1.next().get();
        sum += val;
        count += 1;
      }
      String m1 = arg0 + " Count : ";
      String m2 = arg0 + " Sum : ";
      arg2.collect(new Text(m1), new IntWritable(count));
      arg2.collect(new Text(m2), new IntWritable(sum));      
  }
}