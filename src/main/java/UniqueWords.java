import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class UniqueWords {

    public void uniqueWordsCounter(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder fullString = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                fullString.append(line).append(" ");
            }
            String finalString = String.valueOf(fullString);
            finalString.replaceAll("  ", " ");
            String[] words = finalString.split(" ");
            HashMap <String, Integer> unic = new HashMap<>();
            for (String word : words) {
               unic.put(word, unic.get(word) == null ? 1 : unic.get(word) + 1);
            }
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(unic.entrySet());
            sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            for (Map.Entry<String, Integer> entry : sortedList) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
