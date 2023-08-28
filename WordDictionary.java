import java.util.ArrayList;
import java.util.List;

public class WordDictionary {
    private List<String> words;
    private List<String> definitions;

    public WordDictionary() {
        // initializes the WordDictionary
        words = new ArrayList<String>();
        definitions = new ArrayList<String>();
    }

    public void insertWord(String word, String definition) {
        // Inserts the word and corresponding definition into the dictionary, if the
        // word already exists, it will override the word and definition
        word = word.toLowerCase();
        if (words.indexOf(word) != -1) {
            definitions.set(words.indexOf(word), definition);
        } else {
            words.add(word);
            definitions.add(definition);
        }
    }

    public String findDefinition(String word) {
        // Returns the definition for the word
        word = word.toLowerCase();
        if (words.indexOf(word) != -1) {
            return definitions.get(words.indexOf(word));
        } else {
            return "No Definition";
        }
    }

    public List<String> partialSearch(String partialWord) {
        partialWord = partialWord.toLowerCase();
        // Returns the definitions for the words that are matched partially
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).startsWith(partialWord)) {
                result.add(definitions.get(i));
            }
        }
        return result;
    }

    public void remove(String word) {
        word = word.toLowerCase();
        // Removes the word with definition from the dictionary
        if (words.indexOf(word) != -1) {
            definitions.remove(words.indexOf(word));
            words.remove(words.indexOf(word));
        }
    }

    public static void main(String[] args) {
    }
}
