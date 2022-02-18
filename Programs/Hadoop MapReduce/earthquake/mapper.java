package earthquake;

import java.io.*;
import java.util.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*; 
import org.apache.hadoop.fs.*;

public class mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable>{
    public void map(LongWritable arg0, Text arg1, OutputCollector<Text, DoubleWritable> arg2, Reporter r) throws IOException{
        String data[] = arg1.toString().split(",", 12);
        if(data.length != 12){
            System.out.println("- " + data.length);
            return;
        }
        arg2.collect(new Text("\nEarthquake magnitude at "+data[11]+" is : "), new DoubleWritable(Double.parseDouble(data[8]))); // magnitude data[8]
        arg2.collect(new Text("\nEarthquake depth at "+data[11]+" is : "), new DoubleWritable(Double.parseDouble(data[9]))); // depth data[9]
        arg2.collect(new Text("\nEarthquake longitude at "+data[11]+" is : "), new DoubleWritable(Double.parseDouble(data[7]))); // longitude data[7]
        arg2.collect(new Text("\nEarthquake latitude at "+data[11]+" is : "), new DoubleWritable(Double.parseDouble(data[6]))); // latitude data[6]
    }
}