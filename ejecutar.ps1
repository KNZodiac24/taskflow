javac -cp "lib/JDBC/mysql-connector-j-9.1.0.jar;lib/JCalendar/jcalendar-1.4.jar" -d bin src/modelo/*.java src/vista/*.java src/controlador/*.java src/bd/*.java src/utils/*.java
cd lib/JDBC
jar xf mysql-connector-j-9.1.0.jar
cd ..
cd JCalendar
jar xf jcalendar-1.4.jar
cd ../..
java -cp "lib/JDBC/mysql-connector-j-9.1.0.jar;lib/JCalendar/jcalendar-1.4.jar;bin" modelo/Principal
jar cfm TaskFlow.jar MANIFEST.MF -C bin . -C lib/JDBC . -C lib/JCalendar .
cd lib/JDBC
Remove-Item -Recurse -Force com
Remove-Item -Recurse -Force META-INF
Get-ChildItem -File | Where-Object { $_.Name -notin "mysql-connector-j-9.1.0.jar" } | Remove-Item
cd ..
cd JCalendar
Remove-Item -Recurse -Force com
Remove-Item -Recurse -Force META-INF
cd ../..
