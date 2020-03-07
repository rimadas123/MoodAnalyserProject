import com.bridgelabz.moodAnalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenHappyMood_whenProper_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I'm Happy");
        String mood = moodAnalyzer.createMoodAnalyzer();
        Assert.assertEquals("Happy", mood);
    }

    @Test
    public void givenSadMood_whenProper_ShouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I'm Sad");
        String mood = moodAnalyzer.createMoodAnalyzer();
        Assert.assertEquals("Sad", mood);
    }
}
