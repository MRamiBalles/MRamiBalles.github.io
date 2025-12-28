java -jar uriumc.jar -I ../include -L ../libIntel64 -o App -i64
PATH="C:\Program Files (x86)\Microsoft Visual Studio\2019\Enterprise\VC\Tools\MSVC\14.29.30133\bin\Hostx64\x64"
ml64.exe App.s /link /subsystem:console /defaultlib:kernel32.lib  /entry:Start
App.exe
pause
