package agh.cs.lab6;



import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class GrassField extends AbstractWorldMap {



    private final Map<Vector2d,Grass> grass;

    public GrassField(int grassFieldsNo, int width, int height) {
        super(width, height);
        this.grass = new LinkedHashMap<>();
        randomGenerator(grassFieldsNo, width, height);

    }

   @Override
    public boolean isOccupied(Vector2d position) {

        return(!Objects.isNull(animals.get(position)));
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object grass = this.grass.get(position);


       if (!Objects.isNull(animals.get(position))){
           return (animals.get(position));
       }
           else {

               return grass;
           }

    }


    private void randomGenerator( int grassFieldsNo, int x, int y){
        for (int i=0; i<grassFieldsNo; i++){

            int randomX = ThreadLocalRandom.current().nextInt(0, x );
            int randomY = ThreadLocalRandom.current().nextInt(0,y);

            while (this.grass.containsKey(new Vector2d(randomX, randomY))){
                randomX=ThreadLocalRandom.current().nextInt(0, x );
                randomY=ThreadLocalRandom.current().nextInt(0, y);
            }

            this.grass.put(new Vector2d(randomX, randomY), new Grass(new Vector2d(randomX, randomY)));
            }


        }

}




