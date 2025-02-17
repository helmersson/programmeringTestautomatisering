package assignmentOne;

import java.util.HashMap;
import java.util.Map;

public class MorseLogic {
    //  Skapar två HashMaps för engelska och morsekod
    private static final Map<String, String> morseTillEngelska = new HashMap<>();
    private static final Map<String, String> engelskaTillMorse = new HashMap<>();

    private static final  String[] engelskaAlfabetet = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    private static final String[] morseKod = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    //  En init som körs när klassen laddar
    static {
        //  loopar arrayerna för att fylla HashMapsen
        for (int i = 0; i < engelskaAlfabetet.length; i++) {
            morseTillEngelska.put(morseKod[i], engelskaAlfabetet[i]);
            engelskaTillMorse.put(engelskaAlfabetet[i],morseKod[i]);
        }
    }

    //  Metod för morse till engelska
    public String morseTillEngelska(String morse) {
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
            if (!morseTillEngelska.containsKey(word)) {
                throw new IllegalArgumentException("Ogilitg morsekod: " + word);
            }
            // Konverterar morse till engelska
            sb.append(morseTillEngelska.get(word));
        }
        return sb.toString();
    }

    //  Metod för engelska till morse
    public String engelskaTillMorse(String english) {
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
            if (!engelskaTillMorse.containsKey(String.valueOf(c))) {
                throw new IllegalArgumentException("Ogiltigt tecken:" + c);
            }
            //  Konverterar engelska till morse
            //  Lägger också till ett mellanslag efter varje morsetecken
            sb.append(engelskaTillMorse.get(String.valueOf(c))).append(" ");
        }
        //Returnerar strängen så att den kan printas samt tar bort extra mellanslag i slutet
        return sb.toString().trim();
    }
}