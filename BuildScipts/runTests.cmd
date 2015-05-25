echo off
cd ..

set CLASSPATH=Lib\*;bin
java org.testng.TestNG .\testingOneTest.xml

