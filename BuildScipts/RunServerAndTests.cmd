echo off

powershell -File .\BuildScipts\runAppiumServer.ps1

set CLASSPATH=Lib\*;bin
java org.testng.TestNG testingAll.xml

