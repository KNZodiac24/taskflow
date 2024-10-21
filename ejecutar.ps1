javac -d bin src/modelo/*.java src/vista/*.java src/controlador/*.java
jar cfm TaskFlow.jar MANIFEST.MF -C bin .
java -jar TaskFlow.jar
