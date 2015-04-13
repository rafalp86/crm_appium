
#przekazaæ jako parametry
$apkFile='D:\Project\GIT\crm_appium\resources\mobile.apk'
$EmulatorName='crm'
$deviceName="05a897ce0fa2f571"
$runInDevice=$False

$resetEmulator=$false

if($args[0] -ne $null) { $EmulatorName=$args[0] ; $EmulatorName }
if($args[1] -ne $null) { $apkFile=$args[1] ; $apkFile}
if($args[2] -ne $null) { $runInDevice=$args[2] ; "Run in device :"+$runInDevice }


$appiumProcess='node'
$SeleniumProcess='java'
$emulatorProcess='emulator'
$AppiumProcessCount=(Get-Process | Where {$_.ProcessName -eq $appiumProcess} |measure).Count
$SeleniumProcessCount=(Get-Process | Where {$_.ProcessName -eq $SeleniumProcess} |measure).Count

Write-Host $AppiumProcessCount , $SeleniumProcessCount


    "Stop Appium server"
     Get-Process | Where {$_.ProcessName -eq $appiumProcess} | foreach{$_.Kill()}

    "Run Appium server"
    "Appium dir:"+$Env:APPIUM
     $EnDevComand="--avd "+$EmulatorName

     if($runInDevice) {$EnDevComand="--device-name "+$deviceName }

    Start-Process -FilePath ($Env:APPIUM+"\..\..\node.exe") -ArgumentList  ($Env:APPIUM+"\lib\server\main.js --address 127.0.0.1 --port 4723 --app "+$apkFile+" "+$EnDevComand+ " --log-timestamp --log c:\AppiumForm.txt --platform-name Android --platform-version 19 --automation-name Appium --log-no-color")
    

   sleep(8)
  "Appium proces started: "+ (Get-Process | Where {$_.ProcessName -eq $appiumProcess} |measure).Count

if($resetEmulator)
{
"Kill emulator"
 Get-Process | Where {$_.ProcessName -eq $emulatorProcess} | foreach{$_.Kill()}
 #Start-Process -FilePath emulator  -ArgumentList ("-avd "+$EmulatorName+" -partition-size 1024 -gpu on -verbose")
  
}

#Start-Process -FilePath "D:\Project\GIT\crm_appium\BuildScipts\runTests.cmd"


