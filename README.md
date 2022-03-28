# Ludo-java

## Project discription
In this project you will find a java implementation of the boardgame Ludo.

## How to run the project
To run the project open two terminals.
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

To read them, navigate to the desired report's folder and open the "index.html" or "main.html" file in the live server via right mouse click.
This will open the report in the system's standard webbrowser.
