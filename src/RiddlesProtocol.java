import java.net.*;
import java.io.*;

public class RiddlesProtocol {
    private int state = 0; // 0 = waiting, 1 = asking riddle, 2 = waiting for answer
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

        switch (state) {
            case 0: // initial prompt
                output = "Do you want to solve riddles? (y/n)";
                state = 1;
                break;

            case 1: // waiting for yes/no to start or continue
                if (input.equalsIgnoreCase("y")) {
                    output = riddles[currentRiddle];
                    state = 2; // now waiting for the answer
                } else {
                    output = "BYE!";
                    state = 0;
                }
                break;

            case 2: // waiting for answer
                if (input.equalsIgnoreCase(answers[currentRiddle])) {
                    currentRiddle++;
                    if (currentRiddle >= riddles.length) {
                        output = "You solved all the riddles! Bye!";
                        state = 0;
                        currentRiddle = 0;
                    } else {
                        output = "Correct! Do you want another riddle? (y/n)";
                        state = 1; // go back to asking if user wants another
                    }
                } else {
                    output = "Wrong! Here's a clue: " + clues[currentRiddle];
                    // stay in state 2 to let user try again
                }
                break;
        }

        return output;
    }
}
