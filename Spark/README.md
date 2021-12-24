# Scala & Spark Programs

## Installation Steps

- Download [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) Community Edition

- After successfully installing IntelliJ, install Scala plugin from the plugins section.

## Steps to Create Project

- Create new project

- Select Scala > sbt

- JDK Version : `1.8 ie. Java8`

- sbt version : `1.5.8`

- Scala : `2.11.8`

- Click Finish

## Project setup

Add the following code to `build.sbt` file if required.

- Add spark version

  `val sparkVersion = "2.4.0"`

- Add library dependencies

```
  libraryDependencies ++= Seq(

  "org.apache.spark" %% "spark-core" % sparkVersion,

  "org.apache.spark" %% "spark-sql" % sparkVersion,

  )
```

- Sync this file

## Steps to Execute

- Right Click on `src>main>scala` select new Scala Class

- Add the Buisness Logic to this file

- Build and run the .scala file
