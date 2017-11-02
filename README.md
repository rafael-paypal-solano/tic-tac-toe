# tic-tac-toe #
Assessment project for Metro Group.

## Getting Started ##

This version of tic-tac-toe is designed for three players (2 humans player + the bot player). The bot player has no sophisticated AI;
it just randomly selects an empty cells for each move.

### Requirements ###

1. Java Development Kit 1.8 (Oracle or IBM).
2. Apache Maven.
3. Any Debian based Linux or Windows 8, 10.
4. Git Client. Any linux distribution provides proper packages for installing git and windows users can download git CLI from *https://git-scm.com/download/win*

### Building ###

#### The Build Environment ####

After downloading and installing the JDK and Apache Maven make sure that paths to the relevant java and maven binaries (namely *java*, *javac* and *mvn*) are included in your system's **PATH** variable. You can check if everything is setup by just typing the following commands as illustrated:

```
$ java -version
java version "1.8.0_144"
Java(TM) SE Runtime Environment (build 1.8.0_144-b01)
Java HotSpot(TM) 64-Bit Server VM (build 25.144-b01, mixed mode)
```

```
$ javac -version
javac 1.8.0_144
```

```
$ mvn -version
Apache Maven 3.3.9
Maven home: /usr/share/maven
Java version: 1.8.0_144, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-8-oracle/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "4.10.0-33-generic", arch: "amd64", family: "unix"
```

If every command displays its version info similarly to previous examples, then you can proceed to download the sources and build the game.

#### Cloning the Sources ####

Open a shell console (Linux) or a command prompt (Windows) and clone the eclipse workspace from github. You don't actually  need
eclipse to build your project because a pom.xml file is provided.

```
C:\workspaces>git clone https://github.com/rafael-paypal-solano/tic-tac-toe.git
Cloning into 'tic-tac-toe'...
remote: Counting objects: 492, done.
remote: Compressing objects: 100% (284/284), done.
remote: Total 492 (delta 150), reused 378 (delta 39), pack-reused 0
Receiving objects: 100% (492/492), 1.49 MiB | 905.00 KiB/s, done.
Resolving deltas: 100% (150/150), done.
```

Move to the application subfolder inside the eclipse workspace and build the binaries with maven. Notice that the build process
may take some extra seconds the 1st time you run it.

```
C:\workspaces>cd tic-tac-toe\tictactoe
C:\workspaces\tic-tac-toe\tictactoe>mvn package
```

## Playing the Game ###

### Rules ###

### Provided Setups ###

### Sample Games ###

## Design Considerations ##