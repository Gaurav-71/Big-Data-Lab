customers = LOAD '/home/msrit/Downloads/pig/test/Joining/customer.txt' USING PigStorage(',') as (id:int, name:chararray, age:int, address:chararray, salary:int);
  
orders = LOAD '/home/msrit/Downloads/pig/test/Joining/order.txt' USING PigStorage(',') as (oid:int, date:chararray, customer_id:int, amount:int);

join_result = JOIN customers BY id, orders BY customer_id;

Dump join_result
