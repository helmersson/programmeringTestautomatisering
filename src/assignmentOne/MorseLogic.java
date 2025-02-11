package assignmentOne;

import java.util.HashMap;
import java.util.Map;

public class MorseLogic {
    //  Skapar två HashMaps för engelska och morsekod
    private static final Map<String, String> morseTillEngelska = new HashMap<>();
    private static final Map<String, String> engelskaTillMorse = new HashMap<>();

    //  Mappar morse till A-Z
    // TODO Dra ner på dessa kodrader, altertivt lägga alftabeten i olika arrayer
    static {
        morseTillEngelska.put(".-", "A");
        morseTillEngelska.put("-...", "B");
        morseTillEngelska.put("-.-.", "C");
        morseTillEngelska.put("-..", "D");
        morseTillEngelska.put(".", "E");
        morseTillEngelska.put("..-.", "F");
        morseTillEngelska.put("--.", "G");
        morseTillEngelska.put("....", "H");
        morseTillEngelska.put("..", "I");
        morseTillEngelska.put(".---", "J");
        morseTillEngelska.put("-.-", "K");
        morseTillEngelska.put(".-..", "L");
        morseTillEngelska.put("--", "M");
        morseTillEngelska.put("-.", "N");
        morseTillEngelska.put("---", "O");
        morseTillEngelska.put(".--.", "P");
        morseTillEngelska.put("--.-", "Q");
        morseTillEngelska.put(".-.", "R");
        morseTillEngelska.put("...", "S");
        morseTillEngelska.put("-", "T");
        morseTillEngelska.put("..-", "U");
        morseTillEngelska.put("...-", "V");
        morseTillEngelska.put(".--", "W");
        morseTillEngelska.put("-..-", "X");
        morseTillEngelska.put("-.--", "Y");
        morseTillEngelska.put("--..", "Z");

        //Omvänd map för engelska till Morse
        for (Map.Entry<String, String> entry : morseTillEngelska.entrySet()){
            engelskaTillMorse.put(entry.getValue(), entry.getKey());
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
            sb.append(morseTillEngelska(word));
        }
        return sb.toString();
    }

    //  Metod för engelska till morse
    public  String engelskaTillMorse(String english) {
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
            //  Lägger också till ett mellanslag för läskunnighet
            sb.append(engelskaTillMorse.get(String.valueOf(c))).append(" ");
        }
        //Returnerar strängen så att den kan printas
        return sb.toString().trim();
    }
}