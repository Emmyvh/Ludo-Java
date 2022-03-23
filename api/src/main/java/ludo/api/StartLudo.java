package ludo.api;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import ludo.api.models.*;
import ludo.domain.Board;

@Path("/start")
public class StartLudo {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response initialize(@Context HttpServletRequest request, LudoDTO board)
            throws ServletException, IOException {
        var newBoard = new Board();

        HttpSession session = request.getSession(true);
        session.setAttribute("board", newBoard);

        var output = new LudoDTO(newBoard);
        return Response.status(200).entity(output).build();
    }
}
