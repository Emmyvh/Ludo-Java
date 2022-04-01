# Architecture

## Project overview
In this project you will find a java implementation of the boardgame Ludo.
Ludo is a game you can play with four players in which the first to claim four points wins.
Exact game rules can be found in the file: client/src/Home/Home.jsx

## Project structure
The project consists of a working domain, API and client layer.
Additionally an option has been made to connect to a database (only functional if a database is present locally).

### Domain
The domain layer contains the game logic in domain/src/main/java/ludo/domain.
It is written in Java and build via Gradle.
The main class is Board.java.
This class gathers information from Dice.java, Player.java and Square.java and communicates it to the API layer.

In addition to the game logic the domain contains unit tests for automated testing of each java class file.
These tests can be found under domain/src/test/java/ludo/domain and will prevent a successfull Gradle build if one of them fails.
They are further overseen by the Jacoco plugin, which calculates testCoverage of the entire domain and blocks a successfull build if coverage falls under 95%.
This number can be altered in the build.gradle file of the domain.

The domain is finally checked for style errors via the Checkstyle plugin for Gradle.
This plugin uses the rules declared in checkstyle.xml and suppressions.xml under config/checkstyle.
These rules can be altered by altering the above files, though this will effect how checkstyle performes.
Nevertheless if any style errors are detected during a build that build will fail.
Build reports will be generated though.
To read reports, navigate to the desired report's folder via domain/build/reports and open the "index.html" or "main.html" file in the live server via right mouse click.
This will open the report in the system's standard webbrowser.

### API
The API layer's main code can be found under api/src/main.java/ludo/api.
It is responsible for communication between the domain and client layers and like the domain layer it is written in Java and build via Gradle.
The main API files are StartLudo.java, PlaceLudo.java and MoveLudo.java.
StartLudo.java is the file which can be called to start a new game session by creating a new instance of teh domain Board.java class.
PlaceLudo.java next applies the placePawn() method from the Board.java class to an existing session.
This creates a new pawn on the session's virtual game board that can be move by calling MoveLudo.java to apply the movePawn(index) method of Board.java.
This whole process is finally supported by multiple DTO's which transform the changes applied by Start/Place/MoveLudo.java into JSon files to send to the client layer.
MoveDTO.java specifically supports MoveLudo.java, while GameStatusDTO.java an ActivePlayerDTO.java support all Ludo.java files via LudoDTO.java.

### Client
The client layer's main code can be found under client/src.
It is responsible for the UI and is written in JavaScript and build via Snowpack and the React framework.
The main entrypoint from the client side is a combination of index.html and index.jsx.
Index.jsx next listens to app.jsx which navigates between the projects different webpages.

The main page that users will see is Home.jsx.
This page lists the game rules.
Next they can navigate to PlayLudo.jsx.
This page projects the game itself and lets four players play against one another.
A navigation bar can finally be seen at the top of every page via Header.jsx.

### Database (not necessary to play the game/ not functional if not present locally)
A start has been made to connect this project to a database in MS SQL via its API layer.
This database should register the date and time of each ended game in addition to its winner.

This feature can only work if the database that is refered to is present on the machine that runs the project.
To add a database on your local machine: download MS SQL and build a database in it.
An example of the necessary SQL code can be found in the DatabaseSQLcode.SQL file.
Next alter the url, user, and password variables in api/src/main/java/ludo/api/MoveLudo.java to values applicable to your machine's database.
You cannot use windows authentication for this, it must be a local account with reading and writing rights to the database.

To test if your connection is successful you can use the DatabaseTestFile.java in api/src/main/java/ludo.
Alter the url, user and password like described above and this file will return some statistics on the database upon successfull conntection.

If a database is connected successfully, upon declaring a winner, MoveLudo.java should automatically open a connection to your new database and write down the current date, time and winner.
After writing down the winner the connection is automatically closed again.
