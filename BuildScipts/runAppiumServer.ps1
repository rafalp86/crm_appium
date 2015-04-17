
#przekazaæ jako parametry
$apkFile='D:\Project\GIT\crm_appium\resources\mobile.apk'
$lofFile="C:\AppiumForm.txt"
$EmulatorName='crm'
$deviceName="05a897ce0fa2f571"
$runInDevice=$True

$resetEmulator=$false

if($args[0] -ne $null) { $EmulatorName=$args[0] ; $EmulatorName }
if($args[1] -ne $null) { $apkFile=$args[1] ; $apkFile}
if($args[2] -ne $null) { $runInDevice=$False ; "Run in device :"+$runInDevice }
if($args[3] -ne $null) { $lofFile=$args[3] ; "Appium log  :"+$lofFile }


$appiumProcess='node'
$SeleniumProcess='java'
$emulatorProcess='emulato*'
$AppiumProcessCount=(Get-Process | Where {$_.ProcessName -like $appiumProcess} |measure).Count
$SeleniumProcessCount=(Get-Process | Where {$_.ProcessName -like $SeleniumProcess} |measure).Count

Write-Host $AppiumProcessCount , $SeleniumProcessCount


    "Stop Appium server"
     Get-Process | Where {$_.ProcessName -like $appiumProcess} | foreach{$_.Kill()}

    "Run Appium server"
    "Appium dir:"+$Env:APPIUM
     $EnDevComand="--avd "+$EmulatorName

     if($runInDevice) {$EnDevComand="--device-name "+$deviceName }

    Start-Process -FilePath ($Env:APPIUM+"\..\..\node.exe") -ArgumentList  ($Env:APPIUM+"\lib\server\main.js --address 127.0.0.1 --port 4723 --session-override --app "+$apkFile+" "+$EnDevComand+ " --log-timestamp --log "+$lofFile+" --platform-name Android --platform-version 19 --automation-name Appium --log-no-color")
    
    $sleeptime=0
    if($runInDevice) { $sleeptime=5} else {$sleeptime=10}
	"Wait"+$sleeptime
	sleep($sleeptime)
  "Appium proces started: "+ (Get-Process | Where {$_.ProcessName -eq $appiumProcess} |measure).Count

if($resetEmulator)
{
"Kill emulator"
 Get-Process | Where {$_.ProcessName -like $emulatorProcess} | foreach{$_.Kill()}
 #Start-Process -FilePath emulator  -ArgumentList ("-avd "+$EmulatorName+" -partition-size 1024 -gpu on -verbose")
  
}

#Start-Process -FilePath "D:\Project\GIT\crm_appium\BuildScipts\runTests.cmd"


