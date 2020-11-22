package agh.cs.lab6;



public class World {

    public static void main(String[] args) {

        try {

            args = new String[]{"f", "f", "b", "r", "l", "f", "f"};
            MoveDirection[] directions = OptionsParser.parse(args);
            IWorldMap map = new GrassField(10, 5, 5);

            System.out.println(map);
             Animal z1 = new Animal(map, new Vector2d(3, 3));
            System.out.println(map);
            Animal z2 = new Animal(map);
            //Animal z3 = new Animal(map);
            map.run(directions);

            System.out.println(map);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

}
