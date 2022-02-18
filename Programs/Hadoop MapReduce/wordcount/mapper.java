package wordcount;

import java.io.*;
import java.util.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapred.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
    public void map(LongWritable arg0, Text arg1, OutputCollector<Text, IntWritable> arg2, Reporter r) throws IOException {
        String words[] = arg1.toString().split(" ");
        for(String word : words){
            arg2.collect(new Text(word), new IntWritable(1));
        }
    }
}