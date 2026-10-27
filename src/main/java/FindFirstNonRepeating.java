import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FindFirstNonRepeating {

    public Character firstNonRepeating(String text){

        if(text == null)
            throw new IllegalArgumentException("The string cant be null");

        Map<Character, Integer> characterHashMap = new HashMap<>();
        text.chars().mapToObj(c -> (char)c).forEach(c -> {
            Integer counter = (Integer)characterHashMap.get(c);
            if (counter == null) {
                counter = 1;
            } else {
                counter++;
            }
            characterHashMap.put(c, counter);
        });

        return text.chars()
                .mapToObj(c -> (char) c)
                // Find the minimum character based on its map value (default to Integer.MAX_VALUE if null)
                //.min(Comparator.comparingInt(c -> characterHashMap.getOrDefault(c, Integer.MAX_VALUE)))
                // With filter we remove everything that has higher value than 1
                .filter(c -> characterHashMap.getOrDefault(c,0) == 1)
                // We kept the first character of the remaining after the filter op
                .findFirst()
                // Throw an exception or provide a default fallback if the string was empty
                .orElseThrow(() -> new IllegalArgumentException("String is empty, or there is no non repeated character"));
    }

    public Character firstNonRepeatingTraditional(String text){

        if(text == null)
            throw new IllegalArgumentException("The string cant be null");

        Map<Character, Integer> characterHashMap = new HashMap<>();

        text.chars().mapToObj(c -> (char)c).forEach(c -> {
            Integer counter = (Integer)characterHashMap.get(c);
            if (counter == null) {
                counter = 1;
            } else {
                counter++;
            }
            characterHashMap.put(c, counter);
        });

        char[] chars = text.toCharArray();
        Character response = null;
        for(char c : chars) {
            int counter = characterHashMap.getOrDefault(c, 0);

            if(counter == 1) {
                response = c;
                break;
            }
        }

        if(response == null)
           throw new IllegalArgumentException("String is empty, or there is no non repeated character");

        return response;
    }
}
