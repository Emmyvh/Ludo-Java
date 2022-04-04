package ludo.api;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Path("/HallOfFame")
public class HallOfFame {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response initialize(@Context HttpServletRequest request)
            throws ServletException, IOException, SQLException {

        ArrayList<String> newList = new ArrayList<String>();

        try {
            String dbURL = "jdbc:sqlserver://localhost\\sqlexpress;"
                    + "databaseName=Ludo_Winner_Database;" +
                    "encrypt=true;trustServerCertificate=true";
            String user = "Emmy";
            String pass = "123";
            Connection connection = DriverManager.getConnection(dbURL, user, pass);

            if (connection != null) {
                System.out.println("Connected successfully to database");
                Statement statement = connection.createStatement();
                String sql = "SELECT TOP 10 * FROM Winner_Records ORDER BY Date DESC";
                ResultSet updateQuery = statement.executeQuery(sql);

                while (updateQuery.next()) {
                    String date = (updateQuery.getString("Date"));
                    String time = (updateQuery.getString("Time"));
                    String winner = (updateQuery.getString("Winner"));
                    String newLine = date + ", " + time + ", " + winner;
                    newList.add(newLine);
                }
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("error in database connection. Location: HallOfFame.java");
            e.printStackTrace();
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("list", newList);

        var output = newList;
        return Response.status(200).entity(output).build();
    }

}
