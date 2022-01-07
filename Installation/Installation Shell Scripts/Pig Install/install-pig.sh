#!/bin/sh

cd ~/Downloads

echo ""
wget "https://downloads.apache.org/pig/pig-0.17.0/pig-0.17.0.tar.gz"
echo Downloaded pig-0.17.0 successfully
echo ""

tar -xvf pig-0.17.0.tar.gz
echo Unzipped pig-0.17.0 successfully
echo ""

rm pig-0.17.0.tar.gz

cd pig-0.17.0

PIG_PATH=`pwd`

cd ..

echo export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64 >> ~/.bashrc
source ~/.bashrc

echo ""
echo JAVA_HOME set to /usr/lib/jvm/java-8-openjdk-amd64
echo ""

echo export PIG_HOME=$PIG_PATH >> ~/.bashrc
source ~/.bashrc

echo ""
echo PIG_HOME set to $PIG_PATH
echo ""

echo export PATH=$PATH:$PIG_PATH/bin >> ~/.bashrc
source ~/.bashrc

echo ""
echo PATH set to $PATH:$PIG_PATH/bin
echo ""

echo export PIG_CLASSPATH=$HADOOP_HOME/conf >> ~/.bashrc
source ~/.bashrc

echo ""
echo PIG_CLASSPATH set to $HADOOP_HOME/conf
echo ""

echo "Installation completed successfully"