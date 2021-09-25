import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class App {
    public static void main(String[] args) {

        System.out.println(frequentWords("1.txt"));

    }

    public static String frequentWords(String filename) {
        Map<String, Integer> words_count = new HashMap<String, Integer>();
        try (BufferedReader buff = new BufferedReader(new FileReader(filename))) {
            String str;
            while ((str = buff.readLine()) != null) {
                for (String exo : str.split("\\s+|,|\\!|\\.|\\n|\\(|\\)|\\?|\\;|\\-|\"")) { 
                    if(exo != null && !exo.trim().isEmpty()){
                        if (!words_count.containsKey(exo)) {
                            words_count.put(exo, 1);
                        } else {
                            words_count.put(exo, words_count.get(exo) + 1);
                        }
                    }
                }
            }
            Integer frequency = null;
            String mostFrequent = null;
            for (String s : words_count.keySet()) {
                Integer i = words_count.get(s);
                if (frequency == null)
                    frequency = i;
                if (i > frequency) {
                    frequency = i;
                    mostFrequent = s;
                }
            }
            return "The word '" + mostFrequent + "' occurred " + frequency + " times";
        } catch (IOException e) {
            return e.getMessage();
        }

    }
}
