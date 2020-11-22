package agh.cs.lab6;


import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected Map<Vector2d, Animal> animals;

    protected int width;
    protected int height;

    protected MapVisualizer mapVisualizer;

    protected final Vector2d lowerLeft;
    protected final Vector2d upperRight;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public AbstractWorldMap(int width, int height) {
        this.width = width;
        this.height = height;

        this.animals = new LinkedHashMap<>();
        mapVisualizer = new MapVisualizer(this);
        lowerLeft = new Vector2d(0, 0);
        upperRight = new Vector2d(width - 1, height - 1);
    }

    public boolean canMoveTo(Vector2d position) {

        position = isEndMap(position);
        if (!isOccupied(position)) {
            return true;
        }

        return false;

    }

    @Override
    public String toString() {
        MapVisualizer mv = new MapVisualizer(this);

        return(mv.draw(new Vector2d(0,0), new Vector2d(this.width-1,this.height-1)));

    }


    @Override
    public void place(Animal animal) {
        //check if given coordinates are in the map, then if ths position is occupied
      if (animal.getPosition().getX()>this.width || animal.getPosition().getY()>this.height )
        {

           throw new IllegalArgumentException( animal.getPosition() + " IS NOT VALID DESTINATION");
        }

        if (isOccupied(animal.getPosition())) {
            throw new IllegalArgumentException( animal.getPosition() + " IS NOT VALID DESTINATION");
        }


        this.animals.put(animal.getPosition(), animal);
//return true;





    }

    @Override
    public void run(MoveDirection[] directions) {
        //getting instructions to move


        Collection<Animal> animalsCol=animals.values();
        List<Animal> animalsArray = new ArrayList<Animal>(animalsCol);
        for(int i=0;i<directions.length ;i++) {
            if(directions[i] != null) {

              Animal animalToChange = animalsArray.get(i%animalsArray.size());
              animals.remove(animalToChange.getPosition() );
                animalToChange.move(directions[i]);
             animals.put(animalToChange.getPosition(), animalToChange);

            }
        }

    }

    @Override
    public boolean isOccupied(Vector2d position) {

        return(!Objects.isNull(objectAt(position)));
    }

    @Override
    public Object objectAt(Vector2d position) {

        return animals.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, animal);
    }

    public Vector2d isEndMap(Vector2d position){
        if (position.getX() < 0) position.setX(this.getWidth()-1);
        if (position.getX() > (this.getWidth()-1)) position.setX(0);
        if (position.getY() < 0) position.setY(this.getHeight()-1);
        if (position.getY() > (this.getHeight()-1)) position.setY(0);
        return position;

    }


    }

