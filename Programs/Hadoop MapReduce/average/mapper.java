package average;

import java.io.*;
import java.util.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapred.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable> {	
	public void map(LongWritable arg0, Text arg1, OutputCollector<Text, DoubleWritable> arg2, Reporter r) throws IOException {
        String data[] = arg1.toString().split("\t");
        arg2.collect(new Text(data[3]), new DoubleWritable(Double.parseDouble(data[8])));
    }
}