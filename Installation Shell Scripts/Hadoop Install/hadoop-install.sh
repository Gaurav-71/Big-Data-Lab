#!/bin/sh

cd ~/Downloads

echo ""
wget "https://dlcdn.apache.org/hadoop/common/hadoop-3.2.2/hadoop-3.2.2.tar.gz"
echo Downloaded Hadoop-3.2.2 successfully
echo ""
tar -xvf hadoop-3.2.2.tar.gz
echo Unzipped Hadoop-3.2.2 successfully
echo ""

rm hadoop-3.2.2.tar.gz

cd hadoop-3.2.2
HADOOP_HOME=`pwd`
cd ..

echo export HADOOP_HOME=$HADOOP_HOME  >> ~/.bashrc
source ~/.bashrc
echo ""
echo HADOOP_HOME set to $HADOOP_HOME
echo ""

echo ""
echo export JAVA_HOME=/usr/lib/jvm/default-java >> $HADOOP_HOME/etc/hadoop/hadoop-env.sh
echo Hadoop JAVA_HOME set to /usr/lib/jvm/default-java
echo ""

CLASSPATH="$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-core-3.2.2.jar:$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-common-3.2.2.jar:$HADOOP_HOME/share/hadoop/common/hadoop-common-3.2.2.jar:$HADOOP_HOME/lib/*"

echo export CLASSPATH=$CLASSPATH >> ~/.bashrc
source ~/.bashrc

echo ""
echo CLASSPATH set to $CLASSPATH 
echo ""

echo "Installation completed successfully"



