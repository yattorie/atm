@echo off
setlocal
set JAVA_HOME=C:\Users\andre\.jdks\corretto-17.0.11
set CLASSPATH=C:\Users\andre\IdeaProjects\atm\target\classes
%JAVA_HOME%\bin\java -classpath %CLASSPATH% atm.App
endlocal
pause
