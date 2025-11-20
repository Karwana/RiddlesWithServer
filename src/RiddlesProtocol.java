import java.net.*;
import java.io.*;

public class RiddlesProtocol {
    // 0 = start prompt, 1 = yes/no response, 2 = waiting for riddle answer
    private int state = 0;
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
            case 0: // ask if user wants to play
                output = "Do you want to solve riddles? (y/n)";
                state = 1;
                break;

            case 1: // handle yes/no response
                if (input.equalsIgnoreCase("y")) {
                    output = riddles[currentRiddle];
                    state = 2;
                } else {
                    output = "BYE!";
                    state = 0;
                }
                break;

            case 2: // check riddle answer
                if (input.equalsIgnoreCase(answers[currentRiddle])) {
                    currentRiddle++;
                    if (currentRiddle >= riddles.length) {
                        output = "You solved all the riddles! Bye!";
                        state = 0;
                        currentRiddle = 0;
                    } else {
                        output = "Correct! Do you want another riddle? (y/n)";
                        state = 1;
                    }
                } else {
                    output = "Wrong! Here's a clue: " + clues[currentRiddle];
                    // stay in state 2 to retry
                }
                break;
        }

        return output;
    }
}
