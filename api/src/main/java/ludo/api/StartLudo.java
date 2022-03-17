package ludo.api;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import ludo.api.models.*;
import ludo.domain.Dice;

@Path("/start")
public class StartLudo {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response initialize(@Context HttpServletRequest request, LudoDTO dice) throws ServletException, IOException {
        var newDice = new Dice();

        HttpSession session = request.getSession(true);
        session.setAttribute("dice", newDice);

        var output = new LudoDTO(newDice);
        return Response.status(200).entity(output).build();
    }
}
