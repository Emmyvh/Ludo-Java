package ludo.api;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import ludo.api.models.*;
import ludo.domain.Board;

@Path("/place")
public class PlaceLudo {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response initialize(@Context HttpServletRequest request)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Board board = (Board) session.getAttribute("board");

        board.placeNewPawn();

        var output = new LudoDTO(board);
        return Response.status(200).entity(output).build();
    }
}
