package agh.cs.lab6;

import org.junit.Assert;
import org.junit.Test;

public class MapTest {

    @Test
    public void mapRunPeriodicRectangularTest() {
        String[] args = new String[] {"f","f","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal(map);
        Animal animal2 = new Animal(map,new Vector2d(3,4));
        System.out.println(map);
        map.run(directions);
        System.out.println(map);
        Assert.assertEquals("should be animal1", animal1, map.objectAt(new Vector2d(2,2)));
        Assert.assertEquals("should be animal2", animal2, map.objectAt(new Vector2d(3,4)));
        Assert.assertEquals("should be NORTH", animal2.getOrientation(), MapDirection.NORTH);
        Assert.assertEquals("should be NORTH", animal1.getOrientation(), MapDirection.NORTH);
    }
    @Test
    public void mapRunPeriodicGrassTest() {
        String[] args = new String[] {"f","f","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new GrassField(50,10, 5);
        Animal animal1 = new Animal(map);
        Animal animal2 = new Animal(map,new Vector2d(3,4));
        //System.out.println(map);
        map.run(directions);
        //System.out.println(map);
        Assert.assertEquals("should be animal1", animal1, map.objectAt(new Vector2d(2,2)));
        Assert.assertEquals("should be animal2", animal2, map.objectAt(new Vector2d(3,4)));
        Assert.assertEquals("should be NORTH", animal2.getOrientation(), MapDirection.NORTH);
        Assert.assertEquals("should be NORTH", animal1.getOrientation(), MapDirection.NORTH);
    }
    @Test
    public void mapRunClashingRectangularTest() {
        String[] args = new String[] {"r", "b", "f","b" };;
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal(map);
        Animal animal2 = new Animal(map,new Vector2d(3,4));

        map.run(directions);
        Assert.assertEquals("should be anmal2", animal1, map.objectAt(new Vector2d(3,2)));
        Assert.assertEquals("should be animal2", animal2, map.objectAt(new Vector2d(3,3)));
        Assert.assertEquals("should be NORTH", animal2.getOrientation(), MapDirection.NORTH);
        Assert.assertEquals("should be EAST", animal1.getOrientation(), MapDirection.EAST);
    }
    @Test
    public void mapRunClashingGrassTest() {
        String[] args = new String[] {"r", "b", "f","b" };;
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new GrassField(50,10, 5);
        //System.out.println(map);
        Animal animal1 = new Animal(map);
        Animal animal2 = new Animal(map,new Vector2d(3,4));
        //System.out.println(map);

        map.run(directions);
        Assert.assertEquals("should be anmal2", animal1, map.objectAt(new Vector2d(3,2)));
        Assert.assertEquals("should be animal2", animal2, map.objectAt(new Vector2d(3,3)));
        Assert.assertEquals("should be NORTH", animal2.getOrientation(), MapDirection.NORTH);
        Assert.assertEquals("should be EAST", animal1.getOrientation(), MapDirection.EAST);
    }

    @Test
    public void mapSpawningTest() {
        IWorldMap map = new RectangularMap(10, 5);
        try {
            Animal animal1 = new Animal(map);
            Animal animal2 = new Animal(map);
            Assert.fail();

        } catch (Exception e) {
            final String expected = "(2,2) IS NOT VALID DESTINATION";
            Assert.assertEquals(expected, e.getMessage());

        }

    }


    @Test
    public void grassMapRunTest() {
        String[] args = new String[] {"f","f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new GrassField(50, 10, 5);
        System.out.println(map);
        Animal animal = new Animal(map,new Vector2d(3,4));
        //System.out.println(map);
        map.run(directions);
        //System.out.println(map);
        Assert.assertEquals("should return animal", animal, map.objectAt(new Vector2d(3,1)));
        Assert.assertEquals("should be NORTH", animal.getOrientation(), MapDirection.NORTH);
        Assert.assertTrue("should be grass", map.objectAt(new Vector2d(0, 1)) instanceof Grass);
    }

}

