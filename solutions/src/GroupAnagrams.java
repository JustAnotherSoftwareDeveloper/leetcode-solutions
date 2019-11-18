//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class GroupAnagrams {
//
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<Map<Character,Integer>,List<String>> anagrams = new HashMap<>();
//        for (String s: strs) {
//            Map<Character,Integer> freqMap = createFreqMap(s);
//            anagrams.computeIfAbsent(freqMap,k -> new ArrayList<>()).add(s);
//        }
//        return anagrams.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
//    }
//
//    public Map<Character,Integer> createFreqMap(String s) {
//        Map<Character,Integer> freqMap = new HashMap<>();
//        for (Character c: s.toCharArray()) {
//            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
//        }
//        return freqMap;
//    }
//}
