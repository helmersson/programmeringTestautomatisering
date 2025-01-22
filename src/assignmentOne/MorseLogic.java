package assignmentOne;

import java.util.HashMap;
import java.util.Map;

public class MorseLogic {
    //  Skapar två HashMaps för engelska och morsekod
    private static final Map<String, String> morseToEnglish = new HashMap<>();
    private static final Map<String, String> englishToMorse = new HashMap<>();

    //  Mappar morse till A-Z
    // TODO Dra ner på dessa kodrader
    static {
        morseToEnglish.put(".-", "A");
        morseToEnglish.put("-...", "B");
        morseToEnglish.put("-.-.", "C");
        morseToEnglish.put("-..", "D");
        morseToEnglish.put(".", "E");
        morseToEnglish.put("..-.", "F");
        morseToEnglish.put("--.", "G");
        morseToEnglish.put("....", "H");
        morseToEnglish.put("..", "I");
        morseToEnglish.put(".---", "J");
        morseToEnglish.put("-.-", "K");
        morseToEnglish.put(".-..", "L");
        morseToEnglish.put("--", "M");
        morseToEnglish.put("-.", "N");
        morseToEnglish.put("---", "O");
        morseToEnglish.put(".--.", "P");
        morseToEnglish.put("--.-", "Q");
        morseToEnglish.put(".-.", "R");
        morseToEnglish.put("...", "S");
        morseToEnglish.put("-", "T");
        morseToEnglish.put("..-", "U");
        morseToEnglish.put("...-", "V");
        morseToEnglish.put(".--", "W");
        morseToEnglish.put("-..-", "X");
        morseToEnglish.put("-.--", "Y");
        morseToEnglish.put("--..", "Z");

        //Omvänd map för engelska till Morse
        for (Map.Entry<String, String> entry : morseToEnglish.entrySet()){
            englishToMorse.put(entry.getValue(), entry.getKey());
        }
    }

    //  Metod för morse till engelska
    public String morseToEnglish(String morse) {
        //  Kollar så att input inte är null/tom
        if (morse == null || morse.isEmpty()) {
            throw new IllegalArgumentException("Morsekoden får inte vara tom");
        }

        //  Stringbuilder är en modulär sträng som är lätt att manipulera
        StringBuilder sb = new StringBuilder();
        // Delar morse till enskilda tecken
        String[] words = morse.split(" ");

        //  Går igenom arrayen med input
        for (String word : words) {
            // Kollar efter giltig morsekod
            if (!morseToEnglish.containsKey(word)) {
                throw new IllegalArgumentException("Ogilitg morsekod: " + word);
            }
            // Konverterar morse till engelska
            sb.append(morseToEnglish(word));
        }
        return sb.toString();
    }

    //  Metod för engelska till morse
    public  String englishToMorse(String english) {
        //  Kollar så att input inte är null/tom
        if (english == null || english.isEmpty()) {
            throw new IllegalArgumentException("Engelska texten får inte vara tom");
        }
        StringBuilder sb = new StringBuilder();

        //  Går igenom arrayen med input
        //  Ändrar all text till versaler
        for (char c : english.toUpperCase().toCharArray()) {
            if (c == ' ') continue; //  Hoppar över mellanslag
            // Kontrollerar så att tecknet finns i HashMapen
            if (!englishToMorse.containsKey(String.valueOf(c))) {
                throw new IllegalArgumentException("Ogiltigt tecken:" + c);
            }
            //  Konverterar engelska till morse
            //  Lägger också till ett mellanslag för läskunnighet
            sb.append(englishToMorse.get(String.valueOf(c))).append(" ");
        }
        //Returnerar strängen så att den kan printas
        return sb.toString().trim();
    }

}
