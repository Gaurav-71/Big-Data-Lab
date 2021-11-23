# Big Data Lab

7th Sem Big Data Lab Programs

## Hadoop Download

- [Website](https://www.apache.org/dyn/closer.cgi/hadoop/common/hadoop-3.2.2/hadoop-3.2.2.tar.gz)

- [Direct Download](https://dlcdn.apache.org/hadoop/common/hadoop-3.2.2/hadoop-3.2.2.tar.gz)

## Terminal Setup

- Set Hadoop Home

  `export HADOOP_HOME="hadoop folder path"`

- Set Java Path for Hadoop

  - `gedit $HADOOP_HOME/etc/hadoop/hadoop-env.sh`

  - `export JAVA_HOME=/usr/lib/jvm/default-java`

- Set Classpath

  ```
  export CLASSPATH="$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-common-3.2.2.jar:$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-core-3.2.2.jar:$HADOOP_HOME/share/hadoop/common/hadoop-common-3.2.2.jar"
  ```

  Jar Files Needed for Classpath :-

  - Base Path : $HADOOP_HOME > share > hadoop

  - Base Path > mapreduce > client-common & client-core

  - Base Path > common > hadoop-common

## Execution Steps

- Compile all java files

  `javac -d . *.java`

- Set driver class in manifest

  `echo Main-Class: package.driver > Manifest.txt`

- Create executable jar file

  `jar cfm jarname.jar Manifest.txt packageFolder/*.class`

- Run the jar file

  `$HADOOP_HOME/bin/hadoop jar jarname.jar inputfile output`

- View Output

  `cat output/*`
