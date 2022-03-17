package ludo.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import jakarta.servlet.http.*;
import jakarta.ws.rs.core.*;

import ludo.api.models.*;
import ludo.domain.Dice;

class StartLudoTest {

    @Test
    public void whenAGameIsStartedTheStatusIsOk() {
        var response = StartLudo();
        assertEquals(200, response.getStatus());
    }
}
