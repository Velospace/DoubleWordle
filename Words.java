import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Words {
    private final ArrayList<String> words = new ArrayList<>();
    public Words() throws FileNotFoundException {
        File file = new File("allwords.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            if (word.length() != 0) {words.add(word.toUpperCase());}
        }
    }
    public String[] getWords(int length) {
        ArrayList<String> toReturn = new ArrayList<>();
        for (int i = 0; i<words.size(); i++) {
            if (words.get(i).length() == length) { toReturn.add(words.get(i));}
        }
        return toReturn.toArray(new String[0]);
    }

    public String[] getWords() {
        ArrayList<String> toReturn = new ArrayList<>();
        for (int i = 0; i<words.size(); i++) {
            if (words.get(i).length() == 5) { toReturn.add(words.get(i));}
        }
        return toReturn.toArray(new String[0]);
    }
}
