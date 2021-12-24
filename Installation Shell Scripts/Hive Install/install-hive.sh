#!/bin/sh

cd /home/msrit/Downloads

java -version
sudo apt update
sudo apt install openjdk-8-jdk -y
sudo update-alternatives --config java

echo export JAVA_HOME==/usr/lib/jvm/java-8-openjdk-amd64 > java8.sh

echo export PATH=$PATH:$JAVA_HOME >> java8.sh

bash java8.sh

readlink -f /usr/bin/javac

wget "https://dlcdn.apache.org/hadoop/common/hadoop-3.2.2/hadoop-3.2.2.tar.gz"
echo Downloaded Hadoop-3.2.2 successfully
echo ""
tar -xvf hadoop-3.2.2.tar.gz
echo Unzipped Hadoop-3.2.2 successfully
echo ""

rm hadoop-3.2.2.tar.gz

wget "https://dlcdn.apache.org/hive/hive-3.1.2/apache-hive-3.1.2-bin.tar.gz"

echo Downloaded Hive-3.1.2 successfully

echo ""

tar -xvf apache-hive-3.1.2-bin.tar.gz
echo Unzipped Hadoop-3.2.2 successfully
echo ""

rm apache-hive-3.1.2-bin.tar.gz

sudo apt install openssh-server openssh-client -y

ssh-keygen -t rsa -P '' -f ~/.ssh/id_rsa

cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys

chmod 0600 ~/.ssh/authorized_keys

ssh localhost

HADOOP_HOME=/home/msrit/Downloads/hadoop-3.2.2
HIVE_HOME=/home/msrit/Downloads/apache-hive-3.1.2-bin

echo export HADOOP_HOME=/home/msrit/Downloads/hadoop-3.2.2 >> ~/.bashrc
echo export HADOOP_INSTALL=$HADOOP_HOME >> ~/.bashrc
echo export HADOOP_MAPRED_HOME=$HADOOP_HOME >> ~/.bashrc
echo export HADOOP_COMMON_HOME=$HADOOP_HOME >> ~/.bashrc
echo export HADOOP_HDFS_HOME=$HADOOP_HOME >> ~/.bashrc
echo export YARN_HOME=$HADOOP_HOME >> ~/.bashrc
echo export HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOP_HOME/lib/native >> ~/.bashrc
echo export PATH=$PATH:$HADOOP_HOME/sbin:$HADOOP_HOME/bin >> ~/.bashrc
echo export HADOOP_OPTS="-Djava.library.path=$HADOOP_HOME/lib/native" >> ~/.bashrc
echo export HIVE_HOME=/home/msrit/Downloads/apache-hive-3.1.2-bin >> ~/.bashrc
echo export PATH=$PATH:$HIVE_HOME/bin >> ~/.bashrc

source ~/.bashrc

echo export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64 >> $HADOOP_HOME/etc/hadoop/hadoop-env.sh

echo `pwd`

cat /home/msrit/Downloads/core-site.xml > $HADOOP_HOME/etc/hadoop/core-site.xml

cat /home/msrit/Downloads/hdfs-site.xml > $HADOOP_HOME/etc/hadoop/hdfs-site.xml

cat /home/msrit/Downloads/mapred-site.xml > $HADOOP_HOME/etc/hadoop/mapred-site.xml

cat /home/msrit/Downloads/yarn-site.xml > $HADOOP_HOME/etc/hadoop/yarn-site.xml

hdfs namenode -format

cd hadoop-3.2.2/sbin

./start-dfs.sh

./start-yarn.sh

jps

cd

echo export HADOOP_HOME=/home/msrit/Downloads/hadoop-3.2.2 >  $HIVE_HOME/bin/hive-config.sh

hdfs dfs -mkdir /tmp

hdfs dfs -chmod g+w /tmp

hdfs dfs -ls /

hdfs dfs -mkdir -p /user/hive/warehouse

hdfs dfs -chmod g+w /user/hive/warehouse

hdfs dfs -ls /user/hive

cd $HIVE_HOME/conf

cp hivedefault.xml.template hive-site.xml

cat /home/msrit/Downloads/hive-site.xml > hive-site.xml

$HIVE_HOME/bin/schematool -dbType derby -initSchema

ls $HIVE_HOME/lib

rm $HIVE_HOME/lib/guava-19.0.jar

cp $HADOOP_HOME/share/hadoop/hdfs/lib/guava-27.0-jre.jar $HIVE_HOME/lib/

$HIVE_HOME/bin/schematool -dbType derby -initSchema

rm -rf metastore_db

schematool -dbType derby -initSchema

cd $HIVE_HOME/bin

hive





















