package agh.cs.lab6;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Assert;
import org.junit.Test;

public class OptionParserTest {
    @Test
    public void parsingStringTableValidTest() {
        assertArrayEquals(new MoveDirection[] {MoveDirection.LEFT,MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD,MoveDirection.RIGHT},
                OptionsParser.parse(new String[] {"left", "f", "forward","b","r"}));
    }
    @Test
    public void parsingStringTableInvalidTest() {
       try{

           assertArrayEquals(new MoveDirection[] {MoveDirection.LEFT,MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD,MoveDirection.RIGHT},
                OptionsParser.parse(new String[] {"left", "fkk", "forward","b","r"}));
           Assert.fail();
    }


    catch (Exception e) {
        final String expected = "fkk is not legal move specification";
        Assert.assertEquals(expected, e.getMessage());

    }
    }
}

