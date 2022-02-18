package odd_even;

import java.io.*;
import java.util.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapred.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {	
	public void map(LongWritable arg0, Text arg1, OutputCollector<Text, IntWritable> arg2, Reporter r) throws IOException {
        String numbers[] = arg1.toString().split(" ");
        for(int i=0;i<numbers.length;i++){
            if(Integer.parseInt(numbers[i]) % 2 == 0){
                arg2.collect(new Text("Even"), new IntWritable(Integer.parseInt(numbers[i])));
            }
            else{
                arg2.collect(new Text("Odd"), new IntWritable(Integer.parseInt(numbers[i])));
            }
        }
    }
}