package agh.cs.lab6;


import java.util.LinkedList;
import java.util.List;

public class Animal {


    private MapDirection orientation;
    private Vector2d position;
    private final IWorldMap map;
    private final List<IPositionChangeObserver> observers = new LinkedList<>();


    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setOrientation(MapDirection orientation) {
        this.orientation = orientation;
    }

    public Animal(IWorldMap map) {
        // constructor placing animal in (2,2) position
        this.map = map;

        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
        map.place(this);
    }

    Animal(IWorldMap map, Vector2d initialPosition) {
        // constructor placing animal in given position
        this.map = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
        map.place(this);
    }


    @Override
    public String toString() {
        switch (this.orientation) {
            case NORTH:
                return "N";
            case SOUTH:
                return "S";
            case WEST:
                return "W";
            case EAST:
                return "E";
            default:
                throw new IllegalStateException("Unexpected value: " + this.orientation);
        }

    }



    public void move(MoveDirection direction) {
        // moving one field in the map. it uses hypotetical position vector
        Vector2d hypo;
        switch (direction) {
            case FORWARD: {
                switch (this.orientation) {
                    case NORTH:

                        hypo = this.position.add(new Vector2d(0, 1));
                        if (this.map.canMoveTo(hypo)) {
                            this.position = hypo;
                        }
                        break;
                    case SOUTH:

                        hypo = this.position.add(new Vector2d(0, -1));
                        if (this.map.canMoveTo(hypo)) {
                            this.position = hypo;
                        }
                        break;

                    case WEST:
                        hypo = this.position.add(new Vector2d(-1, 0));
                        if (this.map.canMoveTo(hypo)) {
                            this.position = hypo;
                        }
                        break;

                    case EAST:
                        hypo = this.position.add(new Vector2d(1, 0));

                        if (this.map.canMoveTo(hypo)) {
                            this.position = hypo;
                        }
                        break;
                }
                break;
            }
            case BACKWARD: {

                switch (this.orientation) {
                    case NORTH:
                        hypo = this.position.subtract(new Vector2d(0, 1));

                        if (this.map.canMoveTo(hypo)) {
                            this.position = hypo;
                        }
                        break;
                    case SOUTH:
                        hypo = this.position.subtract(new Vector2d(0, -1));
                        if (this.map.canMoveTo(hypo)) {
                            this.position = hypo;
                        }
                        break;
                    case WEST:
                        hypo = this.position.subtract(new Vector2d(-1, 0));
                        if (this.map.canMoveTo(hypo)) {
                            this.position = hypo;
                        }
                        break;
                    case EAST:
                        hypo = this.position.subtract(new Vector2d(1, 0));
                        if (this.map.canMoveTo(hypo)) {
                            this.position = hypo;
                        }
                        break;
                }
                break;
            }
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
        }

    }
    void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }


    void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }
    void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver o : this.observers) {
            o.positionChanged(oldPosition, newPosition);
        }
    }

}
