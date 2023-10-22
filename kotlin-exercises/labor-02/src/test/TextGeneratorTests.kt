package test
import main.TextGenerator
import org.testng.AssertJUnit.assertEquals
import org.testng.AssertJUnit.assertTrue
import org.testng.annotations.Test
class TextGeneratorTests {
    @Test
    fun learnedWordsTest(){
        val textGenerator = TextGenerator()
        val testString = "Now is not the time for sleep, now is the time for party!"
        val testKey = Pair("Now", "is")
        val testValue = mutableListOf("not")
        textGenerator.learnWords(testString)
        assertEquals(testKey, textGenerator.learnedPairs.keys.first())
        assertEquals(testValue, textGenerator.learnedPairs[testKey])
    }
    @Test
    fun generatedTextTest(){
        val textGenerator = TextGenerator()
        textGenerator.learnWords("Now is not the time for sleep, now is the time for party!")
        assertTrue(textGenerator.generateText().contains("Now is not the time"))
    }
}