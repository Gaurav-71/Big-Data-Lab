package sales;

import java.io.*;
import java.util.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapred.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{
  public void map(LongWritable arg0, Text arg1, OutputCollector<Text, IntWritable> arg2, Reporter r) throws IOException{
    String data[] = arg1.toString().split(",");
    arg2.collect(new Text("Total sales of "+data[7]+" is : "), new IntWritable(Integer.parseInt(data[2])));
    arg2.collect(new Text("Payment mode "+data[3]+" frequency is : "), new IntWritable(1));
  }
}