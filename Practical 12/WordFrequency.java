import java.util.*;
public class WordFrequency {
    public static void main(String[] args) {
        String text = "java is easy java is powerful java programming";

        String[] words = text.toLowerCase().split("\\W+");
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            frequency.put(word,
                    frequency.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        list.sort(
                Comparator.comparingInt(
                        (Map.Entry<String, Integer> e) -> e.getValue()
                ).reversed()
                .thenComparing(Map.Entry::getKey)
        );

        System.out.println("Word Frequencies:");

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(
                    entry.getKey() + " : " + entry.getValue());
        }
    }
}
