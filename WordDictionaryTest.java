
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordDictionaryTest {
    WordDictionary words;

    @Before
    public void setUp() {
        words = new WordDictionary();
    }

    @Test
    public void insertAndRetrieveWordTest() {
        words.insertWord("Keyboard", "Typing device");
        Assert.assertEquals("Typing device",words.findDefinition("Keyboard"));
    }

    @Test
    public void retrievingBlankDefinition() {
        Assert.assertEquals("No Definition", words.findDefinition("Keyboard"));
    }
    
    @Test
    public void partialSearchForMultipleElements() {
        words.insertWord("Keyboard", "Typing device");
        words.insertWord("Key", "A tool used to unlock locks");
        words.insertWord("Keys", "More than 1 key");

        List <String> result=words.partialSearch("Key");

        Assert.assertEquals("Typing device", result.get(0));
        Assert.assertEquals("A tool used to unlock locks", result.get(1));
        Assert.assertEquals("More than 1 key", result.get(2));
    }

    @Test
    public void addThenRemoveElementTest() {
        words.insertWord("Yes", "An agreement");
        Assert.assertEquals("An agreement", words.findDefinition("Yes"));
        words.remove("Yes");
        Assert.assertEquals("No Definition", words.findDefinition("Yes"));
    }

    @Test
    public void addThenModifyWordTest() {
        words.insertWord("Yes", "An agreement");
        Assert.assertEquals("An agreement", words.findDefinition("Yes"));
        words.insertWord("Yes", "A new definition-> definite agreement");
        Assert.assertEquals("A new definition-> definite agreement", words.findDefinition("Yes"));
    }

    @Test
    public void checkIfCapitalizationAffectsRetrieval() {
        words.insertWord("Yes", "An agreement");
        Assert.assertEquals("An agreement", words.findDefinition("yES"));
    }

    @Test
    public void checkIfCapitalizationAffectsDeletion() {
        words.insertWord("Yes", "An agreement");
        Assert.assertEquals("An agreement", words.findDefinition("Yes"));
        words.remove("yES");
        Assert.assertEquals("No Definition", words.findDefinition("Yes"));
    }

    @Test
    public void checkIfCapitalizationAffectsPartialRetrieval() {
        words.insertWord("Keyboard", "Typing device");
        words.insertWord("Key", "A tool used to unlock locks");
        words.insertWord("Keys", "More than 1 key");

        List <String> result=words.partialSearch("kEY");

        Assert.assertEquals("Typing device", result.get(0));
        Assert.assertEquals("A tool used to unlock locks", result.get(1));
        Assert.assertEquals("More than 1 key", result.get(2));
    }
}