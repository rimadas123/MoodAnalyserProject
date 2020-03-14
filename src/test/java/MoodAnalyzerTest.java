import com.bridgelabz.moodAnalyzer.MoodAnalyserFactory;
import com.bridgelabz.moodAnalyzer.MoodAnalyzer;
import com.bridgelabz.moodAnalyzer.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

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
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
            moodAnalyzer.createMoodAnalyzer();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.ENTERED_NULL,e.exceptiontype);
        }
    }

    @Test
    public void givenEmptyShouldThrowException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(" ");
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
            MoodAnalyserFactory.getConstructor("com.bridgelabz.moodAnalyser.oodAnalyser",String.class);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS,e.exceptiontype);
        }
    }

    @Test
    public void givenClassWhenConstructor_NotProper_ShouldThrowException() {
        try {
            MoodAnalyserFactory.getConstructor("mmodAnalyser",String.class);
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

    @Test
    public void givenMoodAnalyzerWithParameterizedConstructor_whenImproper_ShouldThrowException() throws MoodAnalyzerException {
        try {
            MoodAnalyserFactory.getConstructorWithParameter("com.bridgelabz.moodAnalyser.oodAnalser",String.class,"Happy");
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS, e.exceptiontype);
        }
    }

    @Test
    public void givenClassWhenConstructor_notProper_ShouldThrowException() throws MoodAnalyzerException {
        try {
            MoodAnalyserFactory.getConstructorWithParameter("mmoAnalyser",String.class,"Happy");
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD,e.exceptiontype);
        }
    }

    @Test
    public void givenHappyMessage_whenProper_ShouldReturnHappyMood() throws MoodAnalyzerException{
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("com.bridgelabz.moodAnalyzer.MoodAnalyzer",String.class);
            Object obj = constructor.newInstance("I am in a Happy mood");
            String analyser = MoodAnalyserFactory.invokeMethod((MoodAnalyzer) obj,"createMoodAnalyzer");
            Assert.assertEquals("Happy",analyser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMessage_whenImproperMethod_ShouldThrowException() throws MoodAnalyzerException{
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("com.bridgelabz.moodAnalyzer.MoodAnalyzer",String.class);
            Object obj = constructor.newInstance("I am in a Happy mood");
            MoodAnalyserFactory.invokeMethod((MoodAnalyzer) obj,"creMoodAnalyzer");
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD,e.exceptiontype);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setHappyMessage_withReflector_ShouldReturnHappy() {
        try {
            Constructor constructor = MoodAnalyserFactory.getConstructor("com.bridgelabz.moodAnalyzer.MoodAnalyzer",String.class);
            Object obj = constructor.newInstance("I m in a Happy mood");
            MoodAnalyserFactory.modifyMood((MoodAnalyzer) obj,"message","Happy");
            String mood = MoodAnalyserFactory.invokeMethod((MoodAnalyzer) obj,"createMoodAnalyzer");
            Assert.assertEquals("Happy",mood);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setField_whenImproper_ShouldThrowException() throws MoodAnalyzerException {
        try{
            Constructor constructor = MoodAnalyserFactory.getConstructor("com.bridgelabz.moodAnalyzer.MoodAnalyzer",String.class);
            Object obj = constructor.newInstance("I m in a Happy mood");
            MoodAnalyserFactory.modifyMood((MoodAnalyzer) obj,"msg","Happy");
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_FIELD,e.exceptiontype);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setNullMessage_withReflector_ShouldThrowException() throws MoodAnalyzerException{
        try {
         Constructor constructor = MoodAnalyserFactory.getConstructor("com.bridgelabz.moodAnalyzer.MoodAnalyzer",String.class);
         Object obj = constructor.newInstance("I m in a Happy mood");
         MoodAnalyserFactory.modifyMood((MoodAnalyzer) obj,"message","null");
        } catch (MoodAnalyzerException e) {
         Assert.assertEquals(MoodAnalyzerException.ExceptionType.ENTERED_NULL,e.exceptiontype);
        } catch (Exception e) {
         e.printStackTrace();
        }
    }
}
