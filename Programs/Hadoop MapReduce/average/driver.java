package avg;

import java.util.*;
import java.io.IOException;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapred.*;

public class driver {
	public static void main(String args[])throws Exception{
		if(args.length!=2){
			System.out.println("input valid arg");
			System.exit(-1);
		}
		JobConf conf=new JobConf(driver.class);
		conf.setMapperClass(mapper.class);
		conf.setReducerClass(reducer.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(DoubleWritable.class);
		FileInputFormat.addInputPath(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		JobClient.runJob(conf);
		
	}

}