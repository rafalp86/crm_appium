echo off
cd /d %APPIUM%

..\..\node.exe lib\server\main.js --address 127.0.0.1 --port 4723 --app D:\Project\GIT\crm_appium\resources\mobile.apk --avd crm --log-timestamp --log c:\AppiumForm.txt --platform-name Android --platform-version 18 --automation-name Appium --log-no-color
