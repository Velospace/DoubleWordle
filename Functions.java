import java.util.Random;
import java.util.ArrayList;
public class Functions {
    Random random = new Random();

    public String match(String old, String current) {
        char[] characters = old.toCharArray();

        for (int i = 0 ; i < 5 ; i++) {
            char currentOldChar = old.charAt(i);
            char currentNewChar = current.charAt(i);

            if ((currentOldChar != currentNewChar) && currentOldChar == '_') {
                characters[i] = currentNewChar;
            }
        } return new String(characters);
    }

    public String construct(String guess, String correctWord, String currentProgress) {
        char[] characters = new char[5];

        for (int i = 0 ; i < 5 ; i++) {
            if (guess.charAt(i) == correctWord.charAt(i)) {
                characters[i] = correctWord.charAt(i);
            } else {
                characters[i] = currentProgress.charAt(i);
            }
        } return new String(characters);
    }

    public char[] getMisplaced(String guess, String correctWord, String currentProgress) {
        ArrayList<Character> misplacedList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            char currentChar = Character.toUpperCase(guess.charAt(i));
            char correctChar = Character.toUpperCase(correctWord.charAt(i));

            if (
            (currentChar != correctChar) &&
            (correctWord.indexOf(currentChar) != -1) &&
            (!(currentProgress.contains(String.valueOf(currentChar)))) &&
            (!misplacedList.contains(currentChar)))
            {
                misplacedList.add(currentChar);
            }
        }

        char[] misplaced = new char[misplacedList.size()];
        for (int i = 0; i < misplacedList.size(); i++) {
            misplaced[i] = misplacedList.get(i);
        }

        return misplaced;
    }


    public String makePresentable(char[] array) {
        if (array.length == 1) {
            return " " + array[0];
        } else {
            StringBuilder result = new StringBuilder("s ");
            for (int i = 0; i < array.length - 1; i++) {
                result.append(array[i]).append(", ");
            }
            result.append("and ").append(array[array.length - 1]).append(" ");
            return result.toString();
        }
    }

    public int randomNum(int max) {
        return random.nextInt(max);
    }
    public int randomNum(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public double randomDouble(double max) {
        return random.nextDouble(max);
    }
    public double randomDouble(double min, double max) {
        return (max - min + 1) * random.nextDouble() + min;
    }

    public void printSpecial(String text, String color, boolean bold, boolean italic, boolean sameLine) {
        String colorCode = (
            color.equalsIgnoreCase("red") ? "\u001B[31m" :
            color.equalsIgnoreCase("green") ? "\u001B[32m" :
            color.equalsIgnoreCase("blue") ? "\u001B[34m" : ""
        );
        String boldCode = bold ? "\u001B[1m" : "";
        String italicCode = italic ? "\u001B[3m" : "";
        String resetCode = "\u001B[0m";

        if (sameLine) {
            System.out.print(colorCode + boldCode + italicCode + text + resetCode);
            System.out.println();
        } else {
            System.out.println(colorCode + boldCode + italicCode + text + resetCode);
        }
    }

    public void wait(double n) {
        try {
            Thread.sleep((long) (n * 1000));
        } catch (InterruptedException e) {
            return;
        }
    }
}
