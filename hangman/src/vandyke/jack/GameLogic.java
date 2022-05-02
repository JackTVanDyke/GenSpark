package vandyke.jack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    //java keywords to use as hangman words
    public static final String[] words = {
            "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE",
            "CASE", "CATCH", "CHAR", "CLASS", "CONST",
            "CONTINUE", "DEFAULT", "DOUBLE", "DO", "ELSE",
            "ENUM", "EXTENDS", "FALSE", "FINAL", "FINALLY",
            "FLOAT", "FOR", "GOTO", "IF", "IMPLEMENTS",
            "IMPORT", "INSTANCEOF", "INT", "INTERFACE",
            "LONG", "NATIVE", "NEW", "NULL", "PACKAGE",
            "PRIVATE", "PROTECTED", "PUBLIC", "RETURN",
            "SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH",
            "SYNCHRONIZED", "THIS", "THROW", "THROWS",
            "TRANSIENT", "TRUE", "TRY", "VOID", "VOLATILE", "WHILE"
    };
    //random to help choose word
    public static final Random random = new Random();
    //maximum # wrong guesses
    public static final int max_wrong = 8;
    //word to find
    private String wordToFind;
    private char[] wordFound;
    //number of wrong guesses
    private int numWrongGuess;
    //letters guessed
    private ArrayList<String> letters = new ArrayList<>();
    //making computer choose next word to find
    private String nextWordToFind() {
        return words[random.nextInt(words.length)];
    }
    //start a new game
    public void newGame() {
        //reset wrong guesses
        numWrongGuess = 0;
        //clear list of letters guessed
        letters.clear();
        //set new word to guess
        wordToFind = nextWordToFind();
        //init word found
        wordFound = new char[wordToFind.length()];
        for (int i = 0; i < wordFound.length; i++) {
            wordFound[i] = '_';
        }
    }
    //determine if word has been found
    public boolean wordFound() {
        return wordToFind.contentEquals(new String(wordFound));
    }
    //bunch of stuff to manage state of word being found
    private String wordFoundContent() {
        StringBuilder yah = new StringBuilder();
        for (int i = 0; i < wordFound.length; i++) {
            yah.append(wordFound[i]);
            //adding readability
            if (i < wordFound.length - 1) {
                yah.append(" ");
            }
        }
        return yah.toString();
    }
    private void guess(String letter) {
        //check if letter has not been guessed
        if (!letters.contains(letter)) {
            //check if word to find contains letter
            if (wordToFind.contains(letter)) {
                //replace blank with letter
                int index = wordToFind.indexOf(letter);
                while (index >= 0) {
                    wordFound[index] = letter.charAt(0);
                    index = wordToFind.indexOf(letter, index + 1);
                }
            } else {
                //letter not in the word
                numWrongGuess++;
            }
            //the letter is now added to list of letters guessed
            letters.add(letter);
        }
    }
    //adding player interaction
    public void play() {
        try (Scanner playerGuess = new Scanner(System.in)) {
            //play while wrong guesses is less than max wrong guesses
            while (numWrongGuess < max_wrong) {
                System.out.println("\nEnter a letter : ");
                //get guess
                String str = playerGuess.next().toUpperCase();
                //only take first letter
                if (str.length() > 1) {
                    str = str.substring(0, 1);
                }
                //update word found
                guess(str);
                //display word state
                System.out.println("\n" + wordFoundContent());
                //check if word is found
                if (wordFound()) {
                    System.out.println("\nYou Win!");
                    break;
                } else {
                    //display number of guesses left
                    System.out.println("\nNumber of tries left until you're hanged : " + (max_wrong - numWrongGuess));
                }
            }
            if (numWrongGuess == max_wrong) {
                //player is done for lmao
                System.out.println("\nYou Lost. The word was : " + wordToFind);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public static void welcomePlayer() {
        System.out.println("Welcome To Hangman! The rules are simple. You have 8 guesses to figure out the word. Can't do it? You lose. Good luck.");
    }
    public void runGame() {
        welcomePlayer();
        newGame();
        play();
    }
    public int getNumWrongGuess() {
        return numWrongGuess;
    }
    public String getWordToFind() {
        return wordToFind;
    }
    public void setNumWrongGuess(int numWrongGuess) {
        this.numWrongGuess = numWrongGuess;
    }
    public void setWordToFind(String wordToFind) {
        this.wordToFind = wordToFind;
    }
}
