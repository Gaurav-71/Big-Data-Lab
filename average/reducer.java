package avg;

import java.util.*;
import java.io.IOException;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.*;

public class reducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable>{
  //last arg is Double


@Override
public void reduce(Text arg0, Iterator<DoubleWritable> arg1, OutputCollector<Text, DoubleWritable> arg2, Reporter arg3)
		throws IOException {
	// TODO Auto-generated method stub
	  try {
		   Double total = (Double) 0.0;
		   int count = 0;
		   while (arg1.hasNext()) {
		    total += arg1.next().get();		    
		    count++;
		   }
		   Double avg = (Double) total / count;
		   String out = "Total: " + total + " :: " + "Average: " + avg;		   
		   arg2.collect(arg0, new DoubleWritable(avg));
		   arg2.collect(arg0, new DoubleWritable(total));
		  } catch (Exception e) {
		   e.printStackTrace();
		  
	
}
}}
