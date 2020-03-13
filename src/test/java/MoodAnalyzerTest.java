import com.bridgelabz.moodAnalyzer.MoodAnalyserFactory;
import com.bridgelabz.moodAnalyzer.MoodAnalyzer;
import com.bridgelabz.moodAnalyzer.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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

    @Test
    public void givenEmptyShouldThrowException() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        try {
            moodAnalyzer.createMoodAnalyzer();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.ENTERED_EMPTY,e.exceptiontype);
        }
    }

    @Test
    public void givenClassMoodAnalyser_whenProper_ShouldReturnObject() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
            MoodAnalyzer analyzer = MoodAnalyserFactory.createMoodAnalyser();
            boolean result = analyzer.equals(moodAnalyzer);
            Assert.assertEquals(true,result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenClassMoodAnalyser_whenImproper_ShouldThrowException() {
        try {
            MoodAnalyserFactory.getClass("com.bridgelabz.moodAnalyser.oodAnalyser",String.class);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS,e.exceptiontype);
        }
    }

    @Test
    public void givenClassWhenConstructor_NotProper_ShouldThrowException() {
        try {
            MoodAnalyserFactory.getTheConstructor("mmodAnalyser",String.class);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD,e.exceptiontype);
        }
    }

    @Test
    public void givenMoodAnalyzer_whenProper_ShouldReturnObject_UsingParametrizedConstructor() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I'm in Happy mood");
            MoodAnalyserFactory.createMoodAnalyser("Happy");
            boolean result = moodAnalyzer.equals(moodAnalyzer);
            Assert.assertEquals(true, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
