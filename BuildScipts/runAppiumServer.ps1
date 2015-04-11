
#przekaza� jako parametry
$apkFile='D:\Project\GIT\crm_appium\resources\mobile.apk'
$EmulatorName='crm'
$deviceName="05a897ce0fa2f571"
$runInDevice=$false

$resetEmulator=$false

if($args[0] -ne $null) { $EmulatorName=$args[0] ; $EmulatorName }
if($args[1] -ne $null) { $apkFile=$args[1] ; $apkFile}
if($args[3] -ne $null) { $runInDevice=$args[3] ; "Run in device :"+$runInDevice }


$appiumProcess='node'
$SeleniumProcess='java'
$emulatorProcess='emulator'
$AppiumProcessCount=(Get-Process | Where {$_.ProcessName -eq $appiumProcess} |measure).Count
$SeleniumProcessCount=(Get-Process | Where {$_.ProcessName -eq $SeleniumProcess} |measure).Count

Write-Host $AppiumProcessCount , $SeleniumProcessCount

# chyba trzeba zresetowac noda przy ka�dym uruchomieniu 
#if($AppiumProcessCount -eq 0)
#{

    "Stop Appium server"
     Get-Process | Where {$_.ProcessName -eq $appiumProcess} | foreach{$_.Kill()}

    "Run Appium server"
    "Appium dir:"+$Env:APPIUM
     $EnDevComand="--avd "+$EmulatorName
     if($runInDevice) {$EnDevComand="--device-name "+$deviceName }

    Start-Process -FilePath ($Env:APPIUM+"\..\..\node.exe") -ArgumentList  ($Env:APPIUM+"\lib\server\main.js --address 127.0.0.1 --port 4723 --app "+$apkFile+" "+$EnDevComand+ " --log-timestamp --log c:\AppiumForm.txt --platform-name Android --platform-version 19 --automation-name Appium --log-no-color")
    $AppiumProcessCount=(Get-Process | Where {$_.ProcessName -eq $appiumProcess} |measure).Count
#}
#else
#{
#    "Stop Appium server"
#    Get-Process | Where {$_.ProcessName -eq $appiumProcess} | foreach{$_.Kill()}
#}

<#if($SeleniumProcessCount -eq 0)

"Run selenium server"


$selPATH=($Env:SELENIUM+"\selenium-server-standalone-2.45.0.jar")
"Selenium Dir :"+$selPATH
   Start-Process -FilePath java  -ArgumentList ("-jar "+$selPATH+"")
   #>
   sleep(5)

if($resetEmulator)
{
"Kill emulator"
 Get-Process | Where {$_.ProcessName -eq $emulatorProcess} | foreach{$_.Kill()}
 #Start-Process -FilePath emulator  -ArgumentList ("-avd "+$EmulatorName+" -partition-size 1024 -gpu on -verbose")
  
}

#Start-Process -FilePath "D:\Project\GIT\crm_appium\BuildScipts\runTests.cmd"


