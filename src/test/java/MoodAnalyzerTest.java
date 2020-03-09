import com.bridgelabz.moodAnalyzer.MoodAnalyzer;
import com.bridgelabz.moodAnalyzer.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyzerTest {

    @Test
    public void givenHappyMood_whenProper_ShouldReturnHappy() throws MoodAnalyzerException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I'm Happy");
        String mood = moodAnalyzer.createMoodAnalyzer();
        Assert.assertEquals("Happy", mood);
    }

    @Test
    public void givenSadMood_whenProper_ShouldReturnSad() throws MoodAnalyzerException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I'm Sad");
        String mood = moodAnalyzer.createMoodAnalyzer();
        Assert.assertEquals("Sad", mood);
    }

    @Test
    public void givenNullShouldThrowException() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try {
            moodAnalyzer.createMoodAnalyzer();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.ENTERED_NULL,e.exceptiontype);
        }
    }

}
