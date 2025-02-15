package assignmentOne;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class MorseTest {

    private MorseLogic morseLogic;
    private MorseMain morseMain;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream orginalOutPut = System.out;

    TestInfo testInfo;
    TestReporter testReporter;


    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter; 
        morseLogic = new MorseLogic();
        morseMain = new MorseMain();


        testReporter.publishEntry("Kör: " + testInfo.getDisplayName() + " med tagen: " + testInfo.getTags());

        System.setOut(new PrintStream(outContent, true));
    }


    @AfterEach
    public void restoreStreams() {
        System.setOut(orginalOutPut);
    }

    @Test
    @Tag("Logic")
    @DisplayName("Testar morse -> Engelska")
     void testMorseTillEngelska() {

        String morse = ".... . .-.. .-.. --- .-- --- .-. .-.. -..";
        String expected = "HELLOWORLD";
        String actual = morseLogic.morseTillEngelska(morse);
        assertEquals(expected, actual);

    }

    @Test
    @Tag("Logic")
    @DisplayName("Testar Engelska -> Morse")
    void testEngelskaTillMorse() {

        String engelska = "SOS";
        String expected = "... --- ...";
        String actual = morseLogic.engelskaTillMorse(engelska);
        assertEquals(expected, actual);

    }

    @Test
    @Tag("Logic")
    @DisplayName("Testar Engelska -> Morse med små bokstäver")
    void testEngelskaTillMorseMedLowerCase() {
        String engelska = "Hello";
        String expected = ".... . .-.. .-.. ---";
        String actual = morseLogic.engelskaTillMorse(engelska);
        assertEquals(expected, actual);
    }

    //  TODO: Fråga Staffan om hjälp!
    @Test
    @Tag("Main")
    @DisplayName("Testar skrivMeny()")
    void testSkrivMeny() {
        MorseMain.skrivMeny();
        String expected = """
                Välj konverteringstyp
                1. Morsekod till engelska
                2. Engelska till morsekod
                3. Avsluta
                """;
        String actual = outContent.toString();
        assertEquals(expected, actual);


    }


}