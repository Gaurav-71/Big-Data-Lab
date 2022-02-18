package insurance;

import java.io.*;
import java.util.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapred.*;

public class reducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{
    public void reduce(Text arg0, Iterator<IntWritable> arg1, OutputCollector<Text, IntWritable> arg2, Reporter r)  throws IOException{
        int count = 0;
        while(arg1.hasNext()){    
            arg1.next();        
            count += 1;
        }
        arg2.collect(arg0, new IntWritable(count));
    }
}