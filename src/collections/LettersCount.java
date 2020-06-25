package collections;

import java.util.*;

public class LettersCount {
    public static List<String> convertToList(String word){
        char[] chars = word.toCharArray();
        List<String> wordList = new ArrayList<>();
        for(char character : chars) {
            if (character == ' ')
                continue;
            String characterString = String.valueOf(character).toUpperCase();
            wordList.add(characterString);
        }
        return wordList;
    }
    public static Map<String, Integer> createMap(Collection<String> collection){
        Collection<String> aCollection = new ArrayList<>();
        aCollection.addAll(collection);
        Iterator<String> iterator = aCollection.iterator();
        Map<String, Integer> aMap = new HashMap<>();
        while (iterator.hasNext()){
            String word = iterator.next();
            if(aMap.containsKey(word)){
                int num = aMap.get(word);
                num++;
                aMap.put(word, num);
            }else{
                aMap.put(word, 1);
            }

        }
        return aMap;
    }
    public static void displayCount(Map<String, Integer> map){
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> letter = iterator.next();
            StringBuilder letterCount = new StringBuilder(letter.getKey());
            letterCount.append(", ");
            letterCount.append(letter.getValue());
            System.out.println(letterCount.toString());
        }
    }
}
