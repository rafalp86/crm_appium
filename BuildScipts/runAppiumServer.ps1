
#przekazaæ jako parametry
$apkFile='..\resources\mobile.apk'
$EmulatorName='crm'
$resetEmulator=$false

if($args[0] -ne $null) { $EmulatorName=$args[0] ; $EmulatorName }
if($args[1] -ne $null) { $apkFile=$args[1] ; $apkFile}


$appiumProcess='node'
$SeleniumProcess='java'
$emulatorProcess='emulator'
$AppiumProcessCount=(Get-Process | Where {$_.ProcessName -eq $appiumProcess} |measure).Count
$SeleniumProcessCount=(Get-Process | Where {$_.ProcessName -eq $SeleniumProcess} |measure).Count

Write-Host $AppiumProcessCount , $SeleniumProcessCount

if($AppiumProcessCount -eq 0)
{
    "Run Appium server"
    Start-Process -FilePath ($Env:APPIUM+"\..\..\node.exe") -ArgumentList  ($Env:APPIUM+"\lib\server\main.js --address 127.0.0.1 --port 4723 --app "+$apkFile+" --avd "+$EmulatorName+" --log-timestamp --log c:\AppiumForm.txt --platform-name Android --platform-version 19 --automation-name Appium --log-no-color")
}
#else
#{
#    "Stop Appium server"
#    Get-Process | Where {$_.ProcessName -eq $appiumProcess} | foreach{$_.Kill()}
#}

if($SeleniumProcessCount -eq 0)
{
"Run selenium server"
$serwerPATH=$Env:SELENIUM+"\selenium-server-standalone-2.45.0.jar"
$serwerPATH
   #  Start-Process -FilePath java  -ArgumentList ("-jar "+$serwerPATH+"")
}

if($resetEmulator)
{
"Kill emulator"
 Get-Process | Where {$_.ProcessName -eq $emulatorProcess} | foreach{$_.Kill()}
 #Start-Process -FilePath emulator  -ArgumentList ("-avd "+$EmulatorName+" -partition-size 1024 -gpu on -verbose")
  
}

#Start-Process -FilePath "D:\Project\GIT\crm_appium\BuildScipts\runTests.cmd"
