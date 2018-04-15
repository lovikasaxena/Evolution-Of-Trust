import com.twx.eot.inputOutput.InputOutput;
import com.twx.eot.exceptions.WrongInputException;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class InputOutputTest {

    private InputOutput inputOutput = new InputOutput();

    @Test
    public void shouldReturnInputAsCHEAT() throws WrongInputException {
        String input = "CHEAT";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("CHEAT", inputOutput.getInput());
    }

    @Test
    public void shouldReturnInputAsCOOP() throws WrongInputException {
        String input = "COOPERATE";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("COOPERATE", inputOutput.getInput());
    }

}
