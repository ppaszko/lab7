package agh.cs.lab6;
import org.junit.Assert;
import org.junit.Test;

public class Vector2dTest {


    @Test
    public void equalsTest() {

        Assert.assertFalse(new  Vector2d(2,3).equals(MapDirection.NORTH));
        Assert.assertFalse(new  Vector2d(2,3).equals(new Vector2d(2,2)));
        Assert.assertTrue(new  Vector2d(2,3).equals(new Vector2d(2,3)));
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals("(2,1)", new Vector2d(2,1).toString());
    }
    @Test
    public void precedesTest(){
        Assert.assertTrue(new Vector2d(2,1).precedes(new Vector2d(3,4)));
        Assert.assertFalse(new Vector2d(4,1).precedes(new Vector2d(3,4)));
    }
    @Test
    public void followsTest(){
        Assert.assertTrue(new Vector2d(5,6).follows(new Vector2d(3,4)));
        Assert.assertFalse(new Vector2d(1,7).follows(new Vector2d(3,4)));
    }
    @Test
    public void upperRightTest(){
        Assert.assertEquals(new Vector2d(2,3),new Vector2d(2,1).upperRight(new Vector2d(1,3)));
        Assert.assertNotEquals(new Vector2d(2,3),new Vector2d(2,1).upperRight(new Vector2d(5,3)));
    }
    @Test
    public void lowerLeftTest(){
        Assert.assertEquals(new Vector2d(1,1),new Vector2d(2,1).lowerLeft(new Vector2d(1,3)));
        Assert.assertNotEquals(new Vector2d(2,3),new Vector2d(2,1).lowerLeft(new Vector2d(5,3)));
    }
    @Test
    public void addTest(){
        Assert.assertEquals(new Vector2d(3,4),new Vector2d(2,1).add(new Vector2d(1,3)));
        Assert.assertNotEquals(new Vector2d(2,3),new Vector2d(2,1).add(new Vector2d(5,3)));
    }
    @Test
    public void subtractTest(){
        Assert.assertEquals(new Vector2d(2,1),new Vector2d(4,3).subtract(new Vector2d(2,2)));
        Assert.assertNotEquals(new Vector2d(2,3),new Vector2d(2,1).subtract(new Vector2d(5,3)));
    }
    @Test
    public void oppostiteTest(){
        Assert.assertEquals(new Vector2d(3,4),new Vector2d(-3,-4).opposite());
        Assert.assertNotEquals(new Vector2d(2,3),new Vector2d(2,3).opposite());
    }
}

