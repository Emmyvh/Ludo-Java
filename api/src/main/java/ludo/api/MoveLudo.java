package ludo.api;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import ludo.api.models.*;
import ludo.domain.Board;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

@Path("/move")
public class MoveLudo {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response initialize(@Context HttpServletRequest request, MoveDTO input)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        Board board = (Board) session.getAttribute("board");

        // This code moves a pawn.
        board.makeMovePawn(input.getIndex());

        // This code helps write to the database.
        String winner;
        String date = (java.time.LocalDate.now()).toString();
        String time = (java.time.LocalTime.now()).toString();

        try {
            if (board.endOfGameCheck()) {
                if (board.getWinner() == board.getPlayerOne()) {
                    winner = "PlayerOne";
                    recordWinner(date, time, winner);
                } else if (board.getWinner() == board.getPlayerTwo()) {
                    winner = "PlayerTwo";
                    recordWinner(date, time, winner);
                } else if (board.getWinner() == board.getPlayerThree()) {
                    winner = "PlayerThree";
                    recordWinner(date, time, winner);
                } else if (board.getWinner() == board.getPlayerFour()) {
                    winner = "PlayerFour";
                    recordWinner(date, time, winner);
                }
            }
        } catch (SQLException e) {
            System.out.println("error in winner determination in MoveLudo.java");
            e.printStackTrace();
        }

        var output = new LudoDTO(board);
        return Response.status(200).entity(output).build();
    }

    public void recordWinner(String date, String time, String winner) throws SQLException {
        try {
            String dbURL = "jdbc:sqlserver://localhost\\sqlexpress;"
                    + "databaseName=Ludo_Winner_Database;" +
                    "encrypt=true;trustServerCertificate=true";
            String user = "Emmy";
            String pass = "123";
            Connection connection = DriverManager.getConnection(dbURL, user, pass);

            if (connection != null) {
                System.out.println("Connected successfully to database");
                String sql = "INSERT INTO Winner_Records (Date, Time, Winner) VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, date);
                statement.setString(2, time);
                statement.setString(3, winner);

                var updateQuery = statement.execute();
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("error in database connection. Location: MoveLudo.java");
            e.printStackTrace();
        }

    }
}
