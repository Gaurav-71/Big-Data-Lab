package insurance;

import java.io.*;
import java.util.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapred.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{
    public void map(LongWritable arg0, Text arg1, OutputCollector<Text, IntWritable> arg2, Reporter r) throws IOException{
        String data[] = arg1.toString().split(",");
        arg2.collect(new Text("Construction Building Name : "+data[16]+", Building Count : "), new IntWritable(1));
        arg2.collect(new Text("County Name : "+data[2]+", Payment Frequency : "), new IntWritable(1));
    }
}