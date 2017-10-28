# tic-tac-toe #
Assessment project for Metro Group.

# Table of Contents #

* [Getting Started](#getting-started)
  * [Requirements](#requirements)
  * [Building](#building)
    * [The Build Environment](#the-build-environment)
    * [Cloning the Sources](#cloning-the-sources)
    * [Compiling and Packaging](#compiling-and-packaging)
* [How to Play](#how-to-play)
  * [Rules](#rules)
  * [Provided Setups](#provided-setups)
  * [Sample Games](#sample-games)
* [Design Considerations](#design-considerations)

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

Open a shell console (Linux) or a command prompt (Windows) and clone the eclipse workspace from github. You don't actually need
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

#### Compiling and Packaging ####

Move to the application subfolder inside the eclipse workspace and build the binaries with maven. Notice that the build process
may take some extra seconds the 1st time you run it.

```
C:\workspaces>cd tic-tac-toe\tictactoe
C:\workspaces\tic-tac-toe\tictactoe>mvn package
```

## How to Play ##

Two​ users​​ will​​ play​ against​​ each​ other​ and​ against​ the​ computer.​ Who is​ starting​​ is​ random.​

After​ each move,​ the new state​ of​ the​ grid is​ displayed​ and the player​s can enter the next position of their character one after another.

The size of the grid is configurable between 3x3 and 10x10. The symbols (usually **O**, **X** and **+**) are also configurable.

### Rules ###

The three players take turns marking the spaces in a **n×n** grid. The player who succeeds in placing **n** of his/her marks in a horizontal, vertical, or diagonal row wins the game.

### Provided Setups ###

Two sample setups are provided in the config folder (namely **config/config-3x3.properties** and **config/config-4x4.properties**). You can either use those setups for quick testing or create your own. 

### Sample Games ###

#### Sample Game With a 3x3 setup ####

In this case the Player 2 is the winner.

```
C:\workspaces\tic-tac-toe\tictactoe>java -jar target\tictactoe-1.0.0.jar config\config-3x3.properties
    | 1 | 2 | 3 |
----+---+---+---|
 1  |   |   |   |
----+---+---+---|
 2  |   |   |   |
----+---+---+---|
 3  |   |   |   |
----+---+---+---+

What's your choice Human Player 2 (O)?
1,1
    | 1 | 2 | 3 |
----+---+---+---|
 1  | O |   |   |
----+---+---+---|
 2  |   |   |   |
----+---+---+---|
 3  |   |   |   |
----+---+---+---+

Bot Player (aka 'the computer') made this random choice : (3, 2)
    | 1 | 2 | 3 |
----+---+---+---|
 1  | O |   |   |
----+---+---+---|
 2  |   |   |   |
----+---+---+---|
 3  |   | X |   |
----+---+---+---+

What's your choice Human Player 1 (+)?
2,2
    | 1 | 2 | 3 |
----+---+---+---|
 1  | O |   |   |
----+---+---+---|
 2  |   | + |   |
----+---+---+---|
 3  |   | X |   |
----+---+---+---+

What's your choice Human Player 2 (O)?
1,3
    | 1 | 2 | 3 |
----+---+---+---|
 1  | O |   | O |
----+---+---+---|
 2  |   | + |   |
----+---+---+---|
 3  |   | X |   |
----+---+---+---+

Bot Player (aka 'the computer') made this random choice : (2, 1)
    | 1 | 2 | 3 |
----+---+---+---|
 1  | O |   | O |
----+---+---+---|
 2  | X | + |   |
----+---+---+---|
 3  |   | X |   |
----+---+---+---+

What's your choice Human Player 1 (+)?
2,3
    | 1 | 2 | 3 |
----+---+---+---|
 1  | O |   | O |
----+---+---+---|
 2  | X | + | + |
----+---+---+---|
 3  |   | X |   |
----+---+---+---+

What's your choice Human Player 2 (O)?
1,2
    | 1 | 2 | 3 |
----+---+---+---|
 1  | O | O | O |
----+---+---+---|
 2  | X | + | + |
----+---+---+---|
 3  |   | X |   |
----+---+---+---+

We have a winner !!! Human Player 2 (O)

C:\workspaces\tic-tac-toe\tictactoe>
```
#### Sample Game With a 3x3 setup ####

This game is a tied up one (nobody wins).

```
C:\workspaces\tic-tac-toe\tictactoe>java -jar target\tictactoe-1.0.0.jar config\config-4x4.properties
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  |   |   |   |   |
----+---+---+---+---|
 2  |   |   |   |   |
----+---+---+---+---|
 3  |   |   |   |   |
----+---+---+---+---|
 4  |   |   |   |   |
----+---+---+---+---+

What's your choice Human Player 2 (O)?
1,1
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  | O |   |   |   |
----+---+---+---+---|
 2  |   |   |   |   |
----+---+---+---+---|
 3  |   |   |   |   |
----+---+---+---+---|
 4  |   |   |   |   |
----+---+---+---+---+

Bot Player (aka 'the computer') made this random choice : (2, 2)
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  | O |   |   |   |
----+---+---+---+---|
 2  |   | X |   |   |
----+---+---+---+---|
 3  |   |   |   |   |
----+---+---+---+---|
 4  |   |   |   |   |
----+---+---+---+---+

What's your choice Human Player 1 (+)?
1,4
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  | O |   |   | + |
----+---+---+---+---|
 2  |   | X |   |   |
----+---+---+---+---|
 3  |   |   |   |   |
----+---+---+---+---|
 4  |   |   |   |   |
----+---+---+---+---+

What's your choice Human Player 2 (O)?
4,3
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  | O |   |   | + |
----+---+---+---+---|
 2  |   | X |   |   |
----+---+---+---+---|
 3  |   |   |   |   |
----+---+---+---+---|
 4  |   |   | O |   |
----+---+---+---+---+

Bot Player (aka 'the computer') made this random choice : (2, 3)
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  | O |   |   | + |
----+---+---+---+---|
 2  |   | X | X |   |
----+---+---+---+---|
 3  |   |   |   |   |
----+---+---+---+---|
 4  |   |   | O |   |
----+---+---+---+---+

What's your choice Human Player 1 (+)?
3,3
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  | O |   |   | + |
----+---+---+---+---|
 2  |   | X | X |   |
----+---+---+---+---|
 3  |   |   | + |   |
----+---+---+---+---|
 4  |   |   | O |   |
----+---+---+---+---+

What's your choice Human Player 2 (O)?
4,1
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  | O |   |   | + |
----+---+---+---+---|
 2  |   | X | X |   |
----+---+---+---+---|
 3  |   |   | + |   |
----+---+---+---+---|
 4  | O |   | O |   |
----+---+---+---+---+

Bot Player (aka 'the computer') made this random choice : (4, 2)
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  | O |   |   | + |
----+---+---+---+---|
 2  |   | X | X |   |
----+---+---+---+---|
 3  |   |   | + |   |
----+---+---+---+---|
 4  | O | X | O |   |
----+---+---+---+---+

What's your choice Human Player 1 (+)?
3,1
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  | O |   |   | + |
----+---+---+---+---|
 2  |   | X | X |   |
----+---+---+---+---|
 3  | + |   | + |   |
----+---+---+---+---|
 4  | O | X | O |   |
----+---+---+---+---+

What's your choice Human Player 2 (O)?
2,1
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  | O |   |   | + |
----+---+---+---+---|
 2  | O | X | X |   |
----+---+---+---+---|
 3  | + |   | + |   |
----+---+---+---+---|
 4  | O | X | O |   |
----+---+---+---+---+

Bot Player (aka 'the computer') made this random choice : (3, 2)
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  | O |   |   | + |
----+---+---+---+---|
 2  | O | X | X |   |
----+---+---+---+---|
 3  | + | X | + |   |
----+---+---+---+---|
 4  | O | X | O |   |
----+---+---+---+---+

What's your choice Human Player 1 (+)?
1,2
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  | O | + |   | + |
----+---+---+---+---|
 2  | O | X | X |   |
----+---+---+---+---|
 3  | + | X | + |   |
----+---+---+---+---|
 4  | O | X | O |   |
----+---+---+---+---+

What's your choice Human Player 2 (O)?
1,3
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  | O | + | O | + |
----+---+---+---+---|
 2  | O | X | X |   |
----+---+---+---+---|
 3  | + | X | + |   |
----+---+---+---+---|
 4  | O | X | O |   |
----+---+---+---+---+

Bot Player (aka 'the computer') made this random choice : (4, 4)
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  | O | + | O | + |
----+---+---+---+---|
 2  | O | X | X |   |
----+---+---+---+---|
 3  | + | X | + |   |
----+---+---+---+---|
 4  | O | X | O | X |
----+---+---+---+---+

What's your choice Human Player 1 (+)?
2,4
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  | O | + | O | + |
----+---+---+---+---|
 2  | O | X | X | + |
----+---+---+---+---|
 3  | + | X | + |   |
----+---+---+---+---|
 4  | O | X | O | X |
----+---+---+---+---+

What's your choice Human Player 2 (O)?
3,4
    | 1 | 2 | 3 | 4 |
----+---+---+---+---|
 1  | O | + | O | + |
----+---+---+---+---|
 2  | O | X | X | + |
----+---+---+---+---|
 3  | + | X | + | O |
----+---+---+---+---|
 4  | O | X | O | X |
----+---+---+---+---+

Tied up game. ):

C:\workspaces\tic-tac-toe\tictactoe>
```
## Design Considerations ##