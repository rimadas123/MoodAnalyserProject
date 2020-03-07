import com.bridgelabz.moodAnalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    @Test
    public void givenHappyMood_whenProper_ShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String mood = moodAnalyzer.createMoodAnalyzer();
        Assert.assertEquals("Happy", mood);
    }
}
