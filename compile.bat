javac -d . src\RMI\Hello\Hello.java
javac -d . src\RMI\Hello\Server.java
javac -d . src\RMI\Hello\Client.java

rem cd \Project\workspace\hwDRMT
rem start rmiregistry
rem java RMI.Hello.Server