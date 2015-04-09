
$apkFile='D:\Project\GIT\crm_appium\resources\mobile.apk'
$EmulatorName='crm'


$appiumProcess='node'
$SeleniumProcess='java'
$AppiumProcessCount=(Get-Process | Where {$_.ProcessName -eq $appiumProcess} |measure).Count
$SeleniumProcessCount=(Get-Process | Where {$_.ProcessName -eq $SeleniumProcess} |measure).Count
Write-Host $AppiumProcessCount , $SeleniumProcessCount

if($AppiumProcessCount -eq 0)
{
    "Run Appium server"
    Start-Process -FilePath ($Env:APPIUM+"\..\..\node.exe") -ArgumentList  ($Env:APPIUM+"\lib\server\main.js --address 127.0.0.1 --port 4723 --app "+$apkFile+" --avd "+$EmulatorName+" --log-timestamp --log c:\AppiumForm.txt --platform-name Android --platform-version 18 --automation-name Appium --log-no-color")
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
     Start-Process -FilePath java  -ArgumentList ("-jar "+$serwerPATH+"")
}
