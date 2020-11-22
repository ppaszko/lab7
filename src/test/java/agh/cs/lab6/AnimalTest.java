package agh.cs.lab6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnimalTest {

   private Animal example = new Animal(new RectangularMap(4,4));

    @Test
    public void movingTest() {


        assertEquals( new Vector2d(2,2), example.getPosition());
        example.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, example.getOrientation());
        example.move(MoveDirection.BACKWARD);

        assertEquals( new Vector2d(1,2), example.getPosition());


    }

}
