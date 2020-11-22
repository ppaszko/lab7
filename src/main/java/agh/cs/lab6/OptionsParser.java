package agh.cs.lab6;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {

    static public MoveDirection[] parse(String[] commands){
        List <MoveDirection> moves= new ArrayList<>();

        for (String command : commands) {
            switch (command) {
                case "f":
                case "forward":
                    moves.add(MoveDirection.FORWARD);
                    break;
                case "b":
                case "backward":
                    moves.add(MoveDirection.BACKWARD);
                    break;
                case "r":
                case "right":
                    moves.add(MoveDirection.RIGHT);
                    break;
                case "l":
                case "left":
                    moves.add(MoveDirection.LEFT);
                    break;
                default:
                    throw new IllegalArgumentException( command + " is not legal move specification");
            }
        }
    return(moves.toArray(new MoveDirection[0]));

    }
}
