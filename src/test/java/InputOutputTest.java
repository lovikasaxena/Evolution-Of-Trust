import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class InputReaderTest {
    @Test
    public void shouldReturnInput(){
        InputReader inputOutput= new InputReader();
        String input = "CHEAT";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("CHEAT", inputOutput.getInput());
    }



}
