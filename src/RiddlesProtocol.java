import java.net.*;
import java.io.*;

public class RiddlesProtocol {
    private int state = 0; // 0 = waiting, 1 = asking riddle, 2 = asking another
    private int currentRiddle = 0;

    private String[] riddles = {
            "I travel the world but always stay in one corner.",
            "What has to be broken before you can use it?",
            "What goes up but never comes down?"
    };

    private String[] answers = {
            "stamp",
            "egg",
            "age"
    };

    private String[] clues = {
            "It's something you stick on an envelope.",
            "You usually eat it in the morning.",
            "It increases every year."
    };


    public String processInput(String input) {
        String output = null;

        if (state == 0) {
            output = "Do you want to solve riddles? (y/n)";
            state = 1;
        } else if (state == 1) {
            if (input.equalsIgnoreCase("y")) {
                output = riddles[currentRiddle];
            } else {
                output = "BYE!";
                state = 0;
            }


    }
}