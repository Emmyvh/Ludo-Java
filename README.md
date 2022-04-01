# Ludo-java

## Project discription
In this project you will find a Java implementation of the boardgame Ludo.
Ludo is a game you can play with four players in which the first to claim four points wins.
Exact game rules can be found in the file: client/src/Home/Home.jsx

## How to run the project
Before running this project make sure both Java and Gradle are installed on your machine (the gradle wrapper does not work).

To run the project, open two terminals.
In one terminal navigate to the root folder of the project and enter the command: Gradle run.
The domain will now listen on port 8080.
To change this port alter its number in: "api/main.ludo/java/jettyserver.java" & "client/snowpack.config.mjs"

In the other terminal navigate to the client folder of the project and enter the command: npm run start.
The client side will now listen on port 3000 and open in the live server in the browser.
To change this port alter its number in "client/snowpack.config.mjs".

If the live server does not open the browser automatically, navigate to http://localhost:3000 in the browser searchbar.

## CI/CD
Build reports are available for the domain of this project under "domain/build/reports".
These reports include test reports, test coverage via Jacoco, and style rules via Checkstyle.
To view a report, navigate to the project's root folder via terminal and run the command "Gradle build".
Be advised that the build will fail if: any test fails, test coverage of the domain is lower than 95%, or Checkstyle detects style errors.
Even if the build fails reports will become available though.

To read reports, navigate to the desired report's folder and open the "index.html" or "main.html" file in the live server via right mouse click.
This will open the report in the system's standard webbrowser.

## Database (not necessary to play the game/ not functional if not present locally)
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
