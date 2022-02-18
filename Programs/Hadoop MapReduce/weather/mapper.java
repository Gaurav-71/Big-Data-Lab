package weather;

import java.util.*;
import java.io.*;

import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{
    public void map(LongWritable arg0, Text arg1, OutputCollector<Text, IntWritable> arg2, Reporter r) throws IOException{
        String temp = arg1.toString();
        String key = temp.substring(15,19);

        int temperature = 0;

        if(temp.charAt(87) == '+'){
            temperature = Integer.parseInt(temp.substring(88, 92));
        }
        else{
            temperature = Integer.parseInt(temp.substring(87,92));
        }

        arg2.collect(new Text(key), new IntWritable(temperature));
    }
}