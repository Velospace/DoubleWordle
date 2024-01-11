import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Objects
        Words library = new Words();
        Functions utility = new Functions();
        Scanner scanner = new Scanner(System.in);

        // Variables
        String[] words = library.getWords();
        String word1 = words[utility.randomNum(0,words.length)];
        String word2 = words[utility.randomNum(0,words.length)];
        String guess1 = "_____", guess2 = "_____"; while (word2.equals(word1)) { word2 = words[utility.randomNum(0,words.length)]; }
        int wordlength = 5; // will be able to choose later
        int tries = 15;
        int attempts = 0;

        // Introduction to the gam
        System.out.print("\n\nWelcome to my game of Wordle, but with a unique twist!\nIn this version, rather than guessing just one word, you'll have a few extra attempts to unravel the mystery of two words simultaneously!\nAllow me to introduce to you... ");
        utility.wait(1.0);
        utility.printSpecial("Double Wordle!", "blue", true, true, true);
        utility.wait(5.0);
        System.out.println("The rules and gameplay are as follows...");
        utility.wait(1.0);
        utility.printSpecial("• You must enter an authentic/real 5 letter word (not enforced yet!)", "red", true, true, false);
        utility.wait(1.5);
        utility.printSpecial("• You're given hints as to what letters you got incorrect.", "red", true, true, false);
        utility.wait(1.5);
        utility.printSpecial("• You can use friends to help you guess both words", "red", true, true, false);
        utility.wait(1.5);
        utility.printSpecial("• And finally, this program isn't case sensitive to make it easier for users!", "red", true, true, false);
        utility.wait(1.5);
        System.out.println("\nNow, give it a shot!");
        utility.wait(0.75);

        // Game implementation
        while (tries > 0) {
            System.out.println("~===================~ " + tries + " Tries Left ~===================~\nEnter a 5 letter word as your guess...\n");

            String userinput = scanner.next().toUpperCase();
            if (userinput.length() > 5 || userinput.matches(".*\\d.*")) { System.out.println("Please enter a valid response, you have not lost a turn."); continue; }
            attempts++; tries --;
            guess1 = utility.match(guess1, utility.construct(userinput, word1, guess1));
            guess2 = utility.match(guess2, utility.construct(userinput, word2, guess2));
            char[] misplaced1 = utility.getMisplaced(userinput, word1, guess1);
            char[] misplaced2 = utility.getMisplaced(userinput, word2, guess2);


            //Debugging code I used below
            //System.out.println("Guess1: " + guess1 + "\nWord1: " + word1 + "\nGuess2: " + guess2 + "\nWord2: "+word2 + "\nChars1");
            //for (char i : misplaced1) { System.out.print(i);}
            //System.out.print("\nChars2");
            //for (char i : misplaced2) { System.out.print(i);}
            //System.out.print("\n\n\n");


            if (guess1.equals(word1) && guess2.equals(word2)) {
                System.out.println("It seems you've figured out both words in " + attempts + " attempts! It was " + word1 + " and " + word2 + "!");
                break;
            } else if (userinput.equals(word1) || guess1.equals(word1)) {
                System.out.println("Word 1 progress: [" + word1 + "!]\nWord 2 progress: " + guess2);
            } else if (userinput.equals(word2) || guess2.equals(word2)) {
                System.out.println("Word 1 progress: " + guess1 + "\nWord 2 progress: [" + guess2 + "!]");
            } else if (tries == 0) {
                System.out.println("Dang, you ran out of attempts! The words were " + word1 + " and " + word2 +"!");
                break;
            } else System.out.println("Word 1 progress: " + guess1 + "\nWord 2 progress: " + guess2);
            
            System.out.println();

            if (misplaced1.length > 0 || misplaced2.length > 0) {
                if (misplaced1.length > 0) {
                    utility.printSpecial("The letter" + utility.makePresentable(misplaced1) + " can be found in word 1, just in another place.", "blue", true, true, false);
                }
                if (misplaced2.length > 0) {
                    utility.printSpecial("The letter" + utility.makePresentable(misplaced2) + " can be found in word 2, just in another place.", "blue", true, true, false);
                }
            } else {
                System.out.println("None of the letters in the guess are correct for either word.");
            }
        }
    }
}
