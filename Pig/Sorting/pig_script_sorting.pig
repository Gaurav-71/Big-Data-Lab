student = LOAD '/home/msrit/Downloads/pig/test/Sorting/student_details.txt' USING PigStorage(',') as (id:int, firstname:chararray, lastname:chararray, age:int, phone:chararray, city:chararray);

student_order = ORDER student BY age DESC;
  
student_limit = LIMIT student_order 4;
  
Dump student_limit;
