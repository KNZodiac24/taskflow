javac -cp "lib/mysql-connector-j-9.1.0.jar" -d bin src/modelo/*.java src/vista/*.java src/controlador/*.java src/bd/*.java
java -cp "lib/mysql-connector-j-9.1.0.jar;bin" modelo/Principal
jar cfm TaskFlow.jar MANIFEST.MF -C bin .
# java -jar TaskFlow.jar
