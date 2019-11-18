import java.util.HashSet;

public class FirstUniqueChar {

    public int firstUniqChar(String s) {
        HashSet<Character> seen = new HashSet<>();
        HashSet<Character> unique = new HashSet<>();
        char[] charArray = s.toCharArray();
        for (Character c : charArray) {
            if (!seen.contains(c)) {
                seen.add(c);
                unique.add(c);
            }
            else {
                unique.remove(c);
            }
        }
        for(int i=0; i< charArray.length; i++) {
            if (unique.contains(charArray[i])) {
                return i;
            }
        }

        return -1;
    }
}
