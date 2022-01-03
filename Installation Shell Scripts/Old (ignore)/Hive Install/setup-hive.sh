user=`whoami`


echo TEST22222
 sleep 0.2
 sleep 0.2

cd /home/$user/Downloads/hadoop-3.2.2/sbin
./stop-all.sh

cd /home/$user/Downloads/hadoop-3.2.2/bin
 sleep 0.2
sudo -u ./hdfs hdfs dfsadmin -safemode leave
 sleep 0.2
./hdfs namenode -format
 sleep 0.2
cd /home/$user/Downloads/hadoop-3.2.2/sbin
 sleep 0.2
./start-dfs.sh
 sleep 0.2
./start-yarn.sh
 sleep 0.2
jps
 sleep 0.2
cd /home/$user/Downloads/hadoop-3.2.2/bin
 sleep 0.2
./hdfs dfs -mkdir /tmp
 sleep 0.2
./hdfs dfs -chmod g+w /tmp
 sleep 0.2
./hdfs dfs -ls /
 sleep 0.2
./hdfs dfs -mkdir -p /user/hive/warehouse
 sleep 0.2
./hdfs dfs -chmod g+w /user/hive/warehouse
 sleep 0.2
./hdfs dfs -ls /user/hive
 sleep 0.2
cd $HIVE_HOME/conf
 sleep 0.2
cp hive-default.xml.template hive-site.xml
 sleep 0.2
cat /home/$user/Downloads/hive-site.xml > hive-site.xml
 sleep 0.2
$HIVE_HOME/bin/schematool -dbType derby -initSchema
 sleep 0.2
ls $HIVE_HOME/lib
 sleep 0.2
rm $HIVE_HOME/lib/guava-19.0.jar
 sleep 0.2
cp $HADOOP_HOME/share/hadoop/hdfs/lib/guava-27.0-jre.jar $HIVE_HOME/lib/
 sleep 0.2
$HIVE_HOME/bin/schematool -dbType derby -initSchema
 sleep 0.2
rm -rf metastore_db
 sleep 0.2
schematool -dbType derby -initSchema
 sleep 0.2
cd $HIVE_HOME/bin
 sleep 0.2
mv metastore_db metastore_db.tmp

schematool -initSchema -dbType derby

hive
 sleep 0.2
echo EOF
 sleep 0.2
 