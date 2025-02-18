package assignmentOne;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


class MorseTest {

    static int count;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream orginalOutput = System.out;
    private final InputStream orginalInput = System.in;
    TestInfo testInfo;
    TestReporter testReporter;
    private MorseLogic morseLogic;
    private MorseMain morseMain;
    private ByteArrayInputStream testInput;

    @BeforeAll
    public static void beforeClass() {
        count = 0;
    }

    private void input(String data) {
        testInput = new ByteArrayInputStream(data.getBytes());
        System.setIn(testInput);
    }

    @BeforeEach
    public void counter() {
        count++;
    }

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
        System.setOut(orginalOutput);
        System.setIn(orginalInput);
    }

    @AfterAll
    public static void printCounter() {
        System.out.println(count + " tests.");
    }

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

    @Test
    @Tag("Main")
    @DisplayName("Testar så att skrivMeny faktiskt skriver något")
    void testSkrivMeny2() {
        MorseMain.skrivMeny();
        String output = outContent.toString();
        assertFalse(output.isEmpty());
        System.err.print(output);
    }

    @Test
    @Tag("Main")
    @DisplayName("Testar korrekt input i menyVal")
    void testMenyValKorrektInput() {
        input("""
                1
                2
                3""");
        Scanner scanner = new Scanner(System.in);

        //  Test 1
        int expected1 = 1;
        int actual1 = MorseMain.läsMenyVal(scanner);
        assertEquals(expected1, actual1);

        //  Test 2
        int expected2 = 2;
        int actual2 = MorseMain.läsMenyVal(scanner);
        assertEquals(expected2, actual2);

        //  Test 3
        int expected3 = 3;
        int actual3 = MorseMain.läsMenyVal(scanner);
        assertEquals(expected3, actual3);
        scanner.close();
    }

    @Test
    @Tag("Main")
    @DisplayName("Testar inkorrekt input i menyVal")
    void testMenyValInkorrektInput() {
        input("""
                4
                a
                ö
                @
                1""");
        Scanner scanner = new Scanner(System.in);

        int actual = MorseMain.läsMenyVal(scanner);
        int expected = 1;

        assertEquals(expected, actual);
        scanner.close();
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
        String engelska = "hello";
        String expected = ".... . .-.. .-.. ---";
        String actual = morseLogic.engelskaTillMorse(engelska);
        assertEquals(expected, actual);
    }

    @Test
    @Tag("Logic")
    @DisplayName("Testar Engelska -> Morse Skriver SOS 100x")
    void testLångInputEngelskaTillMorse() {
        String engelska = "SOS".repeat(100);
        String expected = "... --- ... ".repeat(100).stripTrailing();
        String actual = morseLogic.engelskaTillMorse(engelska);
        assertEquals(expected, actual);
    }

    @Test
    @Tag("Logic")
    @DisplayName("Testar Felmeddelandet i engelskaTillMorse")
    void testEngelskaTillMorseFelmeddelande(){
        // Test för null input
        assertThrows(IllegalArgumentException.class, () -> morseLogic.engelskaTillMorse(null));

        // Test för tom sträng
        assertThrows(IllegalArgumentException.class, () -> morseLogic.engelskaTillMorse(""));

        // Test för ogiltigt tecken
        assertThrows(IllegalArgumentException.class, () -> morseLogic.engelskaTillMorse("SOS!"));

    }

    @Test
    @Tag("Logic")
    @DisplayName("Testar Felmeddelandet i morseTillEngelska")
    void testMorseTillEngelskaFelmeddelande(){
        // Test för null input
        assertThrows(IllegalArgumentException.class, () -> morseLogic.morseTillEngelska(null));

        // Test för tom sträng
        assertThrows(IllegalArgumentException.class, () -> morseLogic.morseTillEngelska(""));

        // Test för ogiltigt tecken
        assertThrows(IllegalArgumentException.class, () -> morseLogic.morseTillEngelska("... --- ... @!1"));

    }
}