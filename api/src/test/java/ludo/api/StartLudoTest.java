package ludo.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.ws.rs.core.*;

import ludo.api.models.*;

class StartLudoTest {

    @Test
    public void whenAGameIsStartedTheStatusIsOk() throws ServletException, IOException {
        var response = startLudo();
        assertEquals(200, response.getStatus());
    }

    private Response startLudo() throws ServletException, IOException {
        var servlet = new StartLudo();
        var request = createRequestContext();
        var input = input();
        return servlet.initialize(request, input);
    }

    private HttpServletRequest request;
    private HttpSession session;

    private HttpServletRequest createRequestContext() {
        request = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);
        when(request.getSession(true)).thenReturn(session);
        return request;
    }

    private LudoDTO input() {
        var input = new LudoDTO();
        input.getDiceThrow();
        return input;
    }
}
