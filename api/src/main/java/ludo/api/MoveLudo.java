package ludo.api;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import ludo.api.models.*;
import ludo.domain.Board;

@Path("/move")
public class MoveLudo {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response initialize(@Context HttpServletRequest request, MoveDTO move)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        Board board = (Board) session.getAttribute("board");

        board.makeMovePawn(move.getIndex());

        var output = new LudoDTO(board);
        return Response.status(200).entity(output).build();
    }
}
