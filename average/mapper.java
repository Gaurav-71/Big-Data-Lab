package avg;

import java.io.IOException;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.*;
 
public class mapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,DoubleWritable>{	
	public void map(LongWritable key, Text empRecord, OutputCollector<Text , DoubleWritable> values1, Reporter r) throws IOException {
		 String[] word = empRecord.toString().split("\\t");
		 String sex = word[3];
		 Double salary = Double.parseDouble(word[8]);
		 values1.collect(new Text(sex), new DoubleWritable(salary));
	}
}


